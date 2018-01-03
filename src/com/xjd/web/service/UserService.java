package com.xjd.web.service;

import com.opensymphony.xwork2.Action;
import com.xjd.web.dao.UserDao;
import com.xjd.web.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/1/3.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Transactional
    public String registUser(User user) {
        User user1 = userDao.findUser(user.getName());
        if (null == user1) {
            userDao.insert(user);
            return Action.SUCCESS;
        }
        return Action.INPUT;

    }

    public String signIn(User user) {
        List user1 = userDao.findUser(user);
        if (null != user1&&user1.size()>0) {
            return Action.SUCCESS;
        }
        return Action.INPUT;
    }

}
