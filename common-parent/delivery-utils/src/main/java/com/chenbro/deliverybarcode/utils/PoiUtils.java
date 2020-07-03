package com.chenbro.deliverybarcode.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.stereotype.Component;

/**
 * @ClassName PoiUtils
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/19 8:48
 * @Version 1.0
 **/
@Component
public class PoiUtils {



    public Object getCellValue(Cell cell){
        //1.获取单元格的属性类型
        CellType cellType = cell.getCellType();
        //2.根据单元格数据类型获取数据
        Object value = null;
        switch (cellType){
            case STRING:
                value = cell.getStringCellValue();
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case NUMERIC:
                //日期格式判断
                if(DateUtil.isCellDateFormatted(cell)){
                    //日期格式
                    value = cell.getDateCellValue();
                }else {
                    //数字
                    value = cell.getNumericCellValue();
                }
            case FORMULA: //公式
                value = cell.getCellFormula();
                break;
            default:
                break;
        }
        return value;
    }

}
