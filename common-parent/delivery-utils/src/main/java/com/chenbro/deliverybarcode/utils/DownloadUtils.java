package com.chenbro.deliverybarcode.utils;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @ClassName DownloadUtils
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/19 23:45
 * @Version 1.0
 **/
@Component
public class DownloadUtils {

    public void download(ByteArrayOutputStream byteArrayOutputStream, HttpServletResponse response, String returnName) throws IOException {
        response.setContentType("application/octet-stream");
        returnName = response.encodeURL(new String(returnName.getBytes(), "iso8859-1"));        //保存的文件名，必须和页面编码一致
        response.addHeader("Content-disposition", "attachment;filename="+returnName);
        response.setContentLength(byteArrayOutputStream.size());
        ServletOutputStream outputStream = response.getOutputStream();      //取得输出流
        byteArrayOutputStream.writeTo(outputStream);                //写到输出流
        byteArrayOutputStream.close();                              //关闭
        outputStream.flush();                                       //刷新
    }
}
