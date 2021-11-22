package com.example.springboot03_demo.utils;
import java.util.*;

public class getMap {

    public Map<String,Object> getMap(){
        Map<String,Object> map = new HashMap<>();

        return map;
    }
    public static Map<String,Object> success(Object obj){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","操作成功");
        map.put("data",obj);

        return map;
    }

    public static Map<String,Object> error(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",201);
        map.put("msg","操作失败");

        return map;
    }
}
