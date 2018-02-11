package com.xjd.web.juintTestPackage;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

/**
 * Created by Administrator on 2018/2/8.
 */
public class TestSpringHibernate {
    private static ApplicationContext applicationContext;

    @BeforeClass
    public static   void init(){
        applicationContext=new ClassPathXmlApplicationContext("spring-test.xml");
            
    }
    @Test
    public void t(){
        Object i=applicationContext.getBean("test");
        Object sessionFactory = applicationContext.getBean("sessionFactory2", org.hibernate.impl.SessionFactoryImpl.class);
        System.out.println(i);
        System.out.println(sessionFactory);
    }
}
