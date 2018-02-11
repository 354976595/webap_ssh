package com.xjd.web.util;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/1/24.
 */
public class TestInterface implements It{
    public void class1() {

    }

    public void shaha() {

    }

    public static void main(String[] args) {
        TestInterface t=new TestInterface();
       Method[] methods= t.getClass().getMethods();
        for (Method method : methods) {
            System.out.print(method.getName()+"\t");
            System.out.println(method.getModifiers()==0x00000001?"public":"other");
        }
    }
}
