package com.chenbro.deliverybarcode.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtils
 * @Description TODO
 * @Author c8777
 * @Date 2019/12/29 10:45
 * @Version 1.0
 **/
public class DateUtils {
    
    /**
    * @Description //日期转换成字符串    日期建议格式：yyyy-MM-dd HH:mm:ss
    * @Date 2019/12/29 10:47
    * @return java.lang.String
    **/
    public static String date2String(Date date, String patt) {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }

    /**
    * @Description //字符串转换成日期
    * @Date 2019/12/29 10:51
    * @return java.util.Date
    **/
    public static Date string2Date(String str,String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date parse = sdf.parse(str);
        return parse;
    }


    public static Timestamp string2DateStandard(String str, String patt) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date parse = sdf.parse(str.replace("T"," ") + ":00");
        Timestamp ts = new Timestamp(parse.getTime());
        return ts;
    }
}
