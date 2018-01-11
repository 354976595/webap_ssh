package com.xjd.web.MainTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/1/5.
 */
public  class AopTest {
    public static void main(String[] args) {
        invokeForClass("com.xjd.web.MainTest.TaskTest","test");
    }

    /**
     * default constractor invoke
     * @param className
     * @param methodName
     */
    public static void invokeForClass(String className,String methodName){
        Object o;
            Class c=null;
            Method[] methods;
            try {
                c =  Class.forName(className);
               // Constructor cons = c.getConstructor(String.class);
               // Object a = cons.newInstance("haha");
                 o=c.newInstance();
                methods=c.getMethods();
                for (Method method : methods) {
                    if(method.getName().trim().equals(methodName.trim())){
                        method.invoke(o);
                        System.gc();
                    }
                }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
     public static class  Aop{
         public void print(){
             System.out.println("print aop");
         }
    }
     public static class Test{
     public  void out(){
         System.out.println("test   print");
     }
    }
}
