package com.xjd.web.MainTest;

import com.xjd.web.CustomerException.SizeTooBigException;

/**
 * Created by Administrator on 2017/12/22.
 */
public class Maintest {
    public static void main(String[] args) {
        String ar[] = new String[5];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = i + "";
        }
        String re=testE(ar);
        System.out.println(re);
    }

    public static String testE(String[] ar) {
        String re=null;
        try {
            if(re==null){
                throw  new SizeTooBigException("taichangle",null);
            }
            re=ar[6];
        } catch (Exception e) {
            re=e.toString();
            System.out.println("before exception return");
            return re;
        } finally {
            System.out.println("final");
        }
        System.out.println("return");
        return re;
    }
}
