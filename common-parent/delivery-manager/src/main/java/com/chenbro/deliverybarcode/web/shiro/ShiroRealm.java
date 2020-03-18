package com.chenbro.deliverybarcode.web.shiro;

import com.chenbro.deliverybarcode.model.HubRole;
import com.chenbro.deliverybarcode.model.HubUser;
import com.chenbro.deliverybarcode.service.IHubUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName ShiroRealm
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/8 14:18
 * @Version 1.0
 **/
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private IHubUserService hubUserService;

    @Override
    public void setName(String name) {
        super.setName("ShiroRealm");
    }

    /**
    * @Description //TODO 授權 1.該方法什麽情況下會被調用 ,访问授权页面时 调用  2.該方法的入參是什麽數據，认证的主体信息principals(用户名)
    * @Date 2020/3/10 10:56
    * @return org.apache.shiro.authz.AuthorizationInfo
    **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //1.得到用户名
        String username = (String) principals.getPrimaryPrincipal();
        //2.根据用户名称，查询该用户有哪些角色和权限
        Set<HubRole> roles = new HashSet<>();
        new SimpleAuthorizationInfo();
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //1.得到用户输入的用户名
        String username = usernamePasswordToken.getUsername();
        //2.判断当前用户名在数据库中是否存在
        HubUser hubUser = hubUserService.findByUsername(username);

        //3.如果判断用户不存在 抛出异常 unknownAccountException
        if(hubUser == null){
            throw new UnknownAccountException();
        }

        //4.如果用户的状态 锁定 LockedAccountException  status = 0  1正常
        Object principal = username;
        Object credentials = hubUser.getPassword();
        //5.密码的比较(前台密码=数据库中查询的密码） shiro内部来完成
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);  //加盐主体

        //SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,credencials,getName());
        AuthenticationInfo info = new SimpleAuthenticationInfo(principal,credentials,credentialsSalt,getName());
        return info;
    }


    public static void main(String[] args) {
        Object credentials = "12345";
        String hashAlgorithmName = "MD5";
        String username = "kervin";
        Object salt = ByteSource.Util.bytes(username);
        int hashIterations = 1902;
        Object result = new SimpleHash(hashAlgorithmName,credentials,salt,hashIterations);
        System.out.println(result);

    }
}
