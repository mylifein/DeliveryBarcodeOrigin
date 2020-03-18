package com.chenbro.deliverybarcode.web.controller;

import com.chenbro.deliverybarcode.model.*;
import com.chenbro.deliverybarcode.service.IHubDepartmentService;
import com.chenbro.deliverybarcode.service.IHubUserService;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/11 13:39
 * @Version 1.0
 **/
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IHubUserService userService;


    @Autowired
    private IHubDepartmentService hubDepartmentService;

    
    @RequestMapping("login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam(value = "remember", required = false) String remember, Model model) throws CommonException {
        Subject currentUser = SecurityUtils.getSubject();
        try {
            if (!currentUser.isAuthenticated()) {
                UsernamePasswordToken token = new UsernamePasswordToken(username, password);
                if (remember != null && remember.equals("1")) {
                    token.setRememberMe(true);
                }
                currentUser.login(token);
            }
        } catch (UnknownAccountException uce) {
            model.addAttribute("msg","用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException ice) {
            model.addAttribute("msg","密码不正确");
            return "login";
        } catch (LockedAccountException lae) {
            model.addAttribute("msg","当前用户已被锁定");
            return "login";
        }catch (AuthenticationException e) {
            model.addAttribute("msg","用户名/密码错误");
            return "login";
        }
        return "main";
    }

    @RequestMapping("find")
    public String find(String uuid) throws CommonException {

        HubUser user = userService.findByUUid(uuid);
        System.out.println("user:" + user);
        return null;
    }

    @RequestMapping("index")
    public String index() {
        return "login";
    }

    @RequestMapping("main")
    public String toMain() {
        return "main";
    }

    /**
    * @Description //TODO  登出
    * @Date 2020/3/9 23:51
    * @return java.lang.String
    **/
    @RequestMapping("logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }


    @RequestMapping("query")
    public String query(Model model,@RequestParam(name = "page",required =true,defaultValue = "1")Integer pageNum,@RequestParam(name ="size",required = true,defaultValue = "10") Integer pageSize){
        List<HubUser> userList = userService.findAll(pageNum,pageSize);
        //PageInfo就是一个分页bean
        PageInfo pageInfo = new PageInfo(userList);
        model.addAttribute("pageInfo",pageInfo);
        return "user/query";
    }

    public String save(Model model, @RequestBody HubUser hubUser){

        return "user/query";
    }

    @RequestMapping("expire")
    public String expire(){
        return "login";
    }
}
