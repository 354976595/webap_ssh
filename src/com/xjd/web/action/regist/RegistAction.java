package com.xjd.web.action.regist;


import com.opensymphony.xwork2.Action;
import com.xjd.web.dao.NewBusDao;
import com.xjd.web.po.User;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2017/11/22.
 */
@Results({@Result(name ="haha",location = "../repair/repair.jsp"),@Result(name = "real-haha",location = "regist-haha.jsp")})
@Controller
public class RegistAction implements Action {
    @Autowired
    private NewBusDao newBusDao;
    public String regist(){
        System.out.println("haha");
        return "haha";
    }

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
        System.out.println("default");
        return "index";
    }
    public String testHibernate(){
        User user=new User();
        user.setName("xjd");
        List<User> list2= newBusDao.findList(user);
        for (User user2 :list2) {
            System.out.println(user2.getName()+user2.getPassword()+user.getId());
        }
       // busDao.findList(user);
        return "real-haha";

    }
}
