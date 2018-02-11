package com.xjd.web.juintTestPackage;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2018/2/8.
 */

public class JtestTest {
    private  Jtest jtest;
   @Before
   public  void befor(){
       this.jtest=new Jtest();
   }

    @Test(expected = Exception.class)
    public void testAdd(){
        assertEquals(3, jtest.devide(1, 2));
    }
}
