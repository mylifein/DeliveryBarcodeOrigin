package com.chenbro.deliverybarcode.api.handler;

import com.chenbro.deliverybarcode.model.CommonException;
import com.chenbro.deliverybarcode.model.base.Result;
import com.chenbro.deliverybarcode.model.base.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName BaseExceptionHandler
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/7 21:30
 * @Version 1.0
 **/
@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(HttpServletRequest request, HttpServletResponse response,Exception e){
        if(e.getClass() == CommonException.class){
            //类型转换
            e.printStackTrace();
            CommonException ce = (CommonException) e;
            return new Result(ce.getResultCode());
        }else{
            return new Result(ResultCode.SERVER_ERROR,e.getMessage());
        }
    }

}
