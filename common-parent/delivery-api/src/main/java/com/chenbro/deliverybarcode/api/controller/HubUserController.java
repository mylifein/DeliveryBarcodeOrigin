package com.chenbro.deliverybarcode.api.controller;

import com.chenbro.deliverybarcode.model.*;
import com.chenbro.deliverybarcode.model.base.Result;
import com.chenbro.deliverybarcode.model.base.ResultCode;
import com.chenbro.deliverybarcode.model.response.HubUserResult;
import com.chenbro.deliverybarcode.model.response.ProfileResult;
import com.chenbro.deliverybarcode.service.IBoxService;
import com.chenbro.deliverybarcode.service.IHubDepartmentService;
import com.chenbro.deliverybarcode.service.IHubUserService;
import com.chenbro.deliverybarcode.utils.ConstantsUtil;
import com.chenbro.deliverybarcode.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName DepartmentController
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/27 17:48
 * @Version 1.0
 **/
@RestController
@RequestMapping("hub")
public class HubUserController {

    @Autowired
    IHubUserService hubUserService;


    @Autowired
    private JwtUtils jwtUtils;

    @RequestMapping(value = "/user/assignRoles",method = RequestMethod.PUT)
    public Result assignUserRoles(@RequestBody Map<String,Object> map) throws CommonException {
        //1.获取被分配得用户id
        String userId = (String) map.get("id");
        //2.获取到角色的列表
        List<String> roleIds = (List<String>) map.get("roleIds");
        //3.调用Service完成角色分配
        hubUserService.assignRoles(userId,roleIds);
        return new Result(ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public Result findAllUser(){
        List<HubUser> hubUsers = hubUserService.findAll(1,10);
        return new Result(ResultCode.SUCCESS,hubUsers);
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public Result findUserById(@PathVariable(value = "id")String uuid) throws CommonException {
        HubUser hubUser = hubUserService.findByUUid(uuid);
        HubUserResult hubUserResult = new HubUserResult(hubUser);
        return new Result(ResultCode.SUCCESS,hubUserResult);
    }


    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public Result addUser(@RequestBody(required = false) HubUser hubUser){
        hubUserService.insert(hubUser);
        return new Result(ResultCode.SUCCESS);
    }


    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public Result updateUser(@RequestBody(required = false) HubUser hubUser){
        hubUserService.update(hubUser);
        return new Result(ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public Result deleteDepartment(@PathVariable(value = "id") String uuid) throws CommonException {
        hubUserService.deleteById(uuid);
        return new Result(ResultCode.SUCCESS);
    }

    /**
    * @Description //TODO  用户登录成功后,获取用户信息  1.获取用户Id 2.根据用户id查询用户  3.构建返回值对象 4.响应
    * @Date 2020/3/3 22:59
    * @return com.chenbro.deliverybarcode.model.base.Result
    **/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody Map<String,String> loginMap){
        //1.通过username 查询用户
        String username = loginMap.get("username");
        String password = loginMap.get("password");
        HubUser hubUser = hubUserService.findByUsername(username);
        //2.比较password
        if(hubUser == null || !hubUser.getPassword().equals(password)){
            return new Result(ResultCode.USERNAMEORPASSWORDERROR);
        }else{
            //登录成功 获得所有的可访问API权限
            //api权限字符串
            StringBuilder sb = new StringBuilder();
            for(HubRole hubRole : hubUser.getRoles()){
                Set<HubPermission> permissions = hubRole.getPermissions();
                for(HubPermission hubPermission : permissions){
                    String code = hubPermission.getCode();
                    if(hubPermission.getType() == ConstantsUtil.PY_API){
                        sb.append(hubPermission.getCode()).append(",");
                    }
                }
            }
            //3.登录成功生成jwt信息
            Map<String,Object> map = new HashMap<>();
            map.put("workNumer",hubUser.getWorkNumber());
            map.put("apis",sb.toString());
            String token = jwtUtils.createJwt(hubUser.getUuid(),hubUser.getUsername(),map);
            return new Result(ResultCode.SUCCESS,token);
        }
    }

    @RequestMapping(value = "/profile",method = RequestMethod.POST)
    public Result profile(HttpServletRequest request) throws CommonException {
        /**
         * 从请求头信息中获取token数据
         *   1.获取请求头信息： 名称 = Authorization
         *   2.替换 Bearer + 空格
         *   3.解析token
         *   4.获取claims
        **/
        Claims claims = (Claims) request.getAttribute("user_claims");
        if(claims != null){
            String userId = claims.getId();
            HubUser hubUser = hubUserService.findByUUid(userId);
            if(hubUser != null){
                return new Result(ResultCode.SUCCESS,new ProfileResult(hubUser));
            }
        }

        return new Result(ResultCode.FAIL);
    }
}
