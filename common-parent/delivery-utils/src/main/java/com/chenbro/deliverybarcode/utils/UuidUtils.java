package com.chenbro.deliverybarcode.utils;
import java.util.UUID;

/**
 * @ClassName ToolUtils
 * @Description TODO
 * @Author c8777
 * @Date 2019/12/30 14:06
 * @Version 1.0
 **/
public class UuidUtils {

    /**
    * @Description //获得UUID
    * @Date 2019/12/30 14:08
    * @return java.lang.String
    **/
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }


}
