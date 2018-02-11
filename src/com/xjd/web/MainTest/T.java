package com.xjd.web.MainTest;

import com.xjd.web.util.UrlRequest;

/**
 * Created by Administrator on 2018/2/7.
 */
public class T {
    public static void main(String[] args) {
        String json1="{\"busCode\":\"S0K-1044\",\"workNo\":\"1802071116\"}";
        String json2="{'busCode':'S0K-1044','workNo':'1802071116'}";
        //String re=UrlRequest.sendPost("http://192.168.0.216:8082/bimp-base-bst/getFireBusCheckSearch.do","Json="+json1);
        System.out.println(json2);
        System.out.println(json1
        );

    }
}
