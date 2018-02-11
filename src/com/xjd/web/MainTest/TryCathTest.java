package com.xjd.web.MainTest;

import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2018/1/24.
 */
public class TryCathTest {
    static Logger logger=Logger.getLogger(TryCathTest.class);
    static TryCathTest test;
    public static void main(String[] args) {
            test.print();
    }
    static  int print(){
        try{
            int[] a=new int[]{1,323,21,3,2,3,4};
            System.out.println(a[20]);
        }catch (Exception e){
            logger.error(e +"\t" +TryCathTest.class.getName());
          //  System.out.println(e);
        }finally {
            System.out.println("final");
        }

        return 0;
    }
    static {
        test=new TryCathTest();
    }
}
