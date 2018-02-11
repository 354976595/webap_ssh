package com.xjd.web.juintTestPackage;

import com.xjd.web.dao.UserDao;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.commons.codec.binary.Base64;

/**
 * Created by Administrator on 2018/2/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-config.xml"})
public class SpringTest {
    @Autowired
    private UserDao userDAO;
    @Autowired
    private HibernateTemplate ht;

    @Ignore
    @Test
    public void springTest() {
        System.out.println(userDAO.findUser("xjd").toString());

    }

    @Test
    public void testconde() {
        String s = Base64encode("呵呵呵呵呵");
        System.out.println(s);
        System.out.println(Base64decode(s));
    }

    public static String Base64encode(String str) {
        byte[] b = Base64.encodeBase64(str.getBytes(), true);
        return new String(b);
    }
    public static String Base64decode(String str) {
        byte[] b = Base64.decodeBase64(str.getBytes());
      return new String(b);
     }
}
