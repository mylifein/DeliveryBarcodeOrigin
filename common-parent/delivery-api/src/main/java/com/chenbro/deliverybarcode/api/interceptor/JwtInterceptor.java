package com.chenbro.deliverybarcode.api.interceptor;

import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.model.base.ResultCode;
import com.chenbro.deliverybarcode.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName JwtInterceptor
 * @Description TODO            自定义拦截器 ,继承HandlerInterceptorAdapter
 * TODO             preHandle:进入控制器方法之前执行的内容  boolean  true:可以继续执行控制器方法 false:拦截，postHandle：进入控制器方法之后执行的内容 aftercompletion：响应结束前执行的那日容
 *  1.简化获取token数据的代码编写
 *          统一的用户权限校验(是否登录)
 *  2.判断用户是否具有当前访问接口的权限
 * @Author c8777
 * @Date 2020/3/4 8:55
 * @Version 1.0
 **/
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

    /**
     * 1.通过拦截器获取到token数据
     * 2.通过request获取请求token信息
     * 3.从token中解析获取claims
     * 4.将claims绑定到request域中
     **/
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.通过拦截器获取到token数据
        String authrization = request.getHeader("Authorization");
        //2.判断请求头信息是否为空，或者是否以Bearer 开头
        if(!StringUtils.isEmpty(authrization) && authrization.startsWith("Bearer")){
            //获取token数据
            String token = authrization.replace("Bearer ","");
            //3.解析token获取claims
            Claims claims = jwtUtils.parseJwt(token);
            if(claims != null){
                //通过claims 获取当前用户可访问API权限字符串
                String apis = (String) claims.get("apis");
                //通过Handler
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                //获取接口上的requestMapping的注解
                RequestMapping methodAnnotation = handlerMethod.getMethodAnnotation(RequestMapping.class);
                //获取当前请求接口中的name属性
                String name = methodAnnotation.name();
                //判断当前用户是否具有响应的请求权限
                if(apis.contains(name)){
                    request.setAttribute("user_claims",claims);
                    return true;
                }else{
                    throw new CommonException(ResultCode.UNAUTHORISE);
                }

            }
    }
        throw new CommonException(ResultCode.UNAUTHENTICATED);
    }


}
