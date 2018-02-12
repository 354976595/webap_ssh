package com.xjd.web.action.login;

import com.mchange.v2.codegen.CodegenUtils;
import com.opensymphony.xwork2.Action;
import com.xjd.web.dao.UserDao;
import com.xjd.web.po.User;
import com.xjd.web.util.CodeUtil;
import com.xjd.web.util.ResponseToWeb;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2018/2/9.
 */
public class UserAction  implements Action{
    @Autowired
    private UserDao userDao;
    /**
     * Where the logic of the action is executed.
     *
     * @return a string representing the logical result of the execution.
     * See constants in this interface for a list of standard result values.
     * @throws Exception thrown if a system level exception occurs.
     *                   <b>Note:</b> Application level exceptions should be handled by returning
     *                   an error value, such as <code>Action.ERROR</code>.
     */
    public String execute() throws Exception {
        return null;
    }
    public String addUser(){
        User user=new User();
        user.setName(CodeUtil.Base64encode("name xujiadong"));
        user.setPassword(CodeUtil.Base64encode("pass xujiadong"));
        userDao.addUser(user);
        ResponseToWeb.responseToWeb("save User"+CodeUtil.Base64encode("name xujiadong"));
        return null;
    }
    public String testIntercepter() {

        List<Object[]> ol = userDao.findUser();
        for (Object[] objects : ol) {
            System.out.println(objects.length);
            System.out.println(objects[3]);
        }
        return null;

    }

}
