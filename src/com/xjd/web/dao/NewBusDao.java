package com.xjd.web.dao;

import com.xjd.web.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/2/8.
 */
@Repository
public class NewBusDao {
    @Autowired
    private HibernateTemplate ht;
    public List<User> findList(Object t){
        return ht.findByExample(t);
    }
}
