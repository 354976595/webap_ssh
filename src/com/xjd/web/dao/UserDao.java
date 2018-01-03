package com.xjd.web.dao;

import com.xjd.web.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/1/3.
 */
@Repository
public class UserDao {
    @Autowired
    private HibernateTemplate ht;

    public void insert(User user) {
        ht.save(user);
    }

    public List findUser(User user) {
        return  ht.findByExample(user);
    }

    public User findUser(String name) {
        String sql="From User where name=?";
        return (User) ht.find(sql,name).get(0);
    }
}
