package com.xjd.web.po;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/18.
 */
public class MessageTest {
    public static void main(String[] args) {
        String json = "{\"jsonTicket\":[{\"id\":null,\"serialNumber\":\"18011800001\",\"driverCode\":null,\"driverName\":null,\"companyName\":null,\"filialeName\":null,\"lineName\":null,\"companyCode\":null,\"filialeCode\":null,\"lineCode\":null,\"busCode\":null}]}";
        Gson gson = new Gson();
        Map map = gson.fromJson(json, new TypeToken<Map<String,List< Map<String, Object>>>>() {
        }.getType());
        List map1 = (List) map.get("jsonTicket");
        Map map2= (Map) map1.get(0);
        String num = (String) map2.get("serialNumber");
        System.out.println(num);
    }
}
