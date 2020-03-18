package com.chenbro.deliverybarcode.api.controller.shiro;

import com.chenbro.deliverybarcode.model.User;
import com.chenbro.deliverybarcode.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.UUID;

/**
 * @version 1.0
 * @ClassName ShiroRealm
 * @Description TODO
 * @Author Administrator
 * @Date 2019/11/30 16:24
 **/
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
     private IUserService userService;

    /**
     * @Author Administrator
     * @Description //授权
     * 1.该方法什么情况下会被调用
     *      1.1当访问需要角色权限时 访问
     *      1.2如果找到该角色，就不会再第二次调用
     * 2.该方法的入参是什么数据
     *      主体信息(用户名）
     * @Date 13:20 2019/12/2
     * @param principalCollection
     * @returnorg.apache.shiro.authz.AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //1.得到用户名信息
        String username = (String) principalCollection.getPrimaryPrincipal();
        //2.查询数据库，根据用户名称，查询该用户拥有哪些角色
        Set<String> roles = userService.selectRolesByUserName(username);               //new HashSet<>();
        if(roles.contains("R001")){
            roles = userService.selectRolesAllUserName();
        }

        //3.管理员拥有所有的角色(特殊权限）
        AuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo(roles);
        return authorizationInfo;
    }
    
    /**
     * @Author Administrator
     * @Description // 1.访方法什么情况下会被调用  currentUser.login(token)   2.该方法的入参是什么数据   UsernamePasswordToken
     * @Date 13:19 2019/12/2
     * @param authenticationToken
     * @returnorg.apache.shiro.authc.AuthenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        //1. 得到用户输入的用户名
        String username = upToken.getUsername();

        //2. 判断当前用户名在数据库中是否存在
        User user = userService.findByUUid(username);

        //3.如果用户名不存在  UnknowAccountException
        if(user == null){
            throw new UnknownAccountException("用户名不存在");
        }

        //4.如果用户的状态  锁定 LockedAccountException  status = 0  锁定，1 正常
        if(user.getDelFlag().equals("0")){
            throw new LockedAccountException("该帐户已被锁定");
        }
        //5.密码的比较(前台的密码与数据库查询的密码比较 Shiro内部来完成
        //Object principal, Object credentials, String realmName
        Object principal = username;
        Object credentials = user.getPassWord();                            // 数据库查询出的密码
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);       //加盐主体
        //AuthenticationInfo info = new SimpleAuthenticationInfo(principal,credentials,super.getName());
        AuthenticationInfo info = new SimpleAuthenticationInfo(principal,credentials,credentialsSalt,super.getName());
        return info;
    }

    public static void main(String[] args){
        //注册时存入的数据
        //对数据库的密码按照相应规则加密
        /**
         * hashAlgorithmName 加密名称
         * credentials 要加密的密码
         * hashIterations 加密的次数
         */
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        Object credentials = "123";
        String hashAlgorithmName = "MD5";
        String username = "lavine";
        Object salt = ByteSource.Util.bytes(username);
        int hashIterations = 1902;
        Object result = new SimpleHash(hashAlgorithmName,credentials,salt,hashIterations);
        System.out.println(result);
        System.out.println(uuid);
    }
}
