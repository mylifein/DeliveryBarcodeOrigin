package com.chenbro.deliverybarcode.web.controller;

import com.chenbro.deliverybarcode.model.HubUser;
import com.chenbro.deliverybarcode.model.SysLog;
import com.chenbro.deliverybarcode.service.ISysLogService;
import com.chenbro.deliverybarcode.utils.DateUtils;
import com.chenbro.deliverybarcode.utils.UuidUtils;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @ClassName LogAop
 * @Description TODO
 * @Author c8777
 * @Date 2020/5/9 23:06
 * @Version 1.0
 **/
@Component
@Aspect
public class LogAop {

    private Date startTime;
    private Class clazz;
    private Method method;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;

    //前置通知   主要获取开始时间，执行的类是哪一个，执行哪一个方法
    @Before("execution(* com.chenbro.deliverybarcode.web.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        startTime = new Date();
        clazz = jp.getTarget().getClass();
        String methodName = jp.getSignature().getName();
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        method = methodSignature.getMethod();
//        Object[] args = jp.getArgs();
////        if(args == null || args.length == 0){
////            method = clazz.getMethod(methodName);           //获取无参方法
////        }else{
////            Class[] classArgs = new Class[args.length];
////            for(int i = 0;i < args.length;i++){
////                classArgs[i] = args[i].getClass();
////            }
////            method = clazz.getMethod(methodName,classArgs);
////        }
    }

    @After("execution(* com.chenbro.deliverybarcode.web.controller.*.*(..))")
    public void doAfter(JoinPoint jp){
        long time = new Date().getTime() - startTime.getTime();
        String url = "";
        //获取url
        if(clazz != null && method != null && clazz != LogAop.class && clazz != SysLogController.class){
            //1.获取类上的@RequestMapping(xxx)
            RequestMapping clazzAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if(clazzAnnotation != null){
                String[] classValue = clazzAnnotation.value();

                //2.获取方法上的@RequestMapping(xxx)
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if(methodAnnotation != null){
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + "/" + methodValue[0];

                    //获取
                    String ip = request.getRemoteAddr();
                    //获取当前操作用户
                    HubUser opUser = (HubUser) SecurityUtils.getSubject().getPrincipal();
                    if(opUser != null){
                        SysLog sysLog = new SysLog();
                        sysLog.setUuid(UuidUtils.getUUID());
                        sysLog.setExecutionTime(time);
                        sysLog.setIp(ip);
                        sysLog.setUrl(url);
                        sysLog.setUsername(opUser.getUsername());
                        sysLog.setVisitTime(DateUtils.date2String(startTime,"yyyy-MM-dd HH:mm:ss"));
                        sysLog.setMethod("[类名] " + clazz.getName() + "[方法名] " + method.getName());

                        //调用Service完成记录操作
                        sysLogService.insert(sysLog);
                    }
                }
            }
        }

    }

}
