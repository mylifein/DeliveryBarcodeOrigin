package com.chenbro.deliverybarcode.utils;

import org.springframework.cglib.beans.BeanMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName BeanMapUtils
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/1 17:57
 * @Version 1.0
 **/
public class BeanMapUtils {
    
    /**
    * @Description //TODO  将对象属性转化为Map集合
    * @Date 2020/3/1 17:57
    * @return 
    **/
    public static <T> Map<String,Object> beanToMap(T bean){
        Map<String,Object> map = new HashMap<>();
        if(bean != null){
            BeanMap beanMap = BeanMap.create(bean);
            for(Object key : beanMap.keySet()){
                map.put(key+"",beanMap.get(key));
            }
        }
        return map;
    }

    /**
    * @Description //TODO 将map集合中的数据转化为指定对象的同名属性中
    * @Date 2020/3/1 18:20
    * @return 
    **/
    public static <T> T mapToBean(Map<String,Object> map,Class<T> clazz) throws Exception{
        T bean = clazz.newInstance();
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }
}
