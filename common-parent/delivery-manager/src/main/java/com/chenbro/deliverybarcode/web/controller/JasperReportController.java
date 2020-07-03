package com.chenbro.deliverybarcode.web.controller;

import net.sf.jasperreports.engine.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * @ClassName JasperReport
 * @Description TODO
 * @Author c8777
 * @Date 2020/5/29 0:05
 * @Version 1.0
 **/
@Controller
@RequestMapping("jsr")
public class JasperReportController {


    @RequestMapping("deliveryNote")
    public void createPDF(HttpServletResponse response) throws IOException{
        //1.引入jasper文件
        Resource resource = new ClassPathResource("templates/deliveryNote.jasper");
        FileInputStream fis = new FileInputStream(resource.getFile());

        ServletOutputStream os = response.getOutputStream();
        //2.创建JasperPrint，向jasper文件中填充数据
        /** 参数说明
         *  fis : jasper 文件输入流
         *  new HashMap:向模板中输入的参数
         *  JasperDataSource：数据源(和数据库数据源不同）   填充模板的数据来源(connection ,javabean,Map)
         *  填充空的数据源:JREmptyDataSource
         */
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(fis, new HashMap<String, Object>(), new JREmptyDataSource());

            //3.将JasperPrint以PDFd的形式输出
            JasperExportManager.exportReportToPdfStream(jasperPrint,os);
        } catch (JRException e) {
            e.printStackTrace();
        } finally {
            os.flush();
        }


    }

}
