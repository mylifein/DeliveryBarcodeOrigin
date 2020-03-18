package com.chenbro.deliverybarcode.model.base;

import java.io.Serializable;

/**
 * @ClassName Result
 * @Description TODO 数据响应对象
 * {
 *     successs:
 *     code:
 *     message:
 *     data{
 *
 *     }
 * }
 * @Author c8777
 * @Date 2020/2/13 23:26
 * @Version 1.0
 **/
public class Result implements Serializable {

    private Boolean success;  //是否成功
    private Integer code;   //返回码
    private String message; //返回消息
    private Object data;    //返回数据

    public Result() {
    }

    public Result(ResultCode code){
        this.success = code.success;
        this.code = code.code;
        this.message = code.message;
    }

    public Result(ResultCode code,Object data){
        this.success = code.success;
        this.code = code.code;
        this.message = code.message;
        this.data = data;
    }

    public Result(Integer code,String message,Boolean success){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public static Result SUCCESS(){
        return new Result(ResultCode.SUCCESS);
    }

    public static Result ERROR(){
        return new Result(ResultCode.SERVER_ERROR);
    }

    public static Result FAIL(){
        return new Result(ResultCode.FAIL);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
