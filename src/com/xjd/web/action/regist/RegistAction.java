package com.xjd.web.action.regist;


import com.opensymphony.xwork2.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 * Created by Administrator on 2017/11/22.
 */
@Results({@Result(name ="haha",location = "../repair/repair.jsp")})

public class RegistAction implements Action {
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
}
