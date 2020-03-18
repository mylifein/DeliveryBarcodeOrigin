package com.chenbro.deliverybarcode.model;

import com.chenbro.deliverybarcode.model.base.ResultCode;

/**
 * @ClassName CommonException
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/1 18:41
 * @Version 1.0
 **/
public class CommonException extends Exception{

    private ResultCode resultCode;

    public CommonException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }


    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
