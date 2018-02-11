package com.xjd.web.util;

import com.xjd.web.po.User;

/**
 * Created by Administrator on 2018/1/24.
 */
public class OverRideTest {
   abstract class SuperA{
        protected abstract Object print() throws IllegalAccessException, InstantiationException;
    }
    class B extends  SuperA{
        @Override
        protected User print() throws IllegalAccessException, InstantiationException {
            return  User.class.newInstance();
        }
    }
}
