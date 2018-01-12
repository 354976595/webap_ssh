package com.xjd.web.MainTest;

import java.util.*;

/**
 * Created by Administrator on 2018/1/12.
 */

/***
 * 数据结构  列表  数组 树状结构
 */
public class LinkenListTest {
    public static void main(String[] args) {
        List list1=new ArrayList<String>();
        list1.add("11");
        list1.add("22");
        list1.add("33");
        list1.add(2,"arrayList insert");
        for (Object o : list1) {
            System.out.println(o.toString());
        }
        LinkedList<String> list=new LinkedList<String>();
        list.addAll(list1);
        list.add(2,"charu");
        for (String s : list) {
            System.out.println(s);
        }
    }

}
