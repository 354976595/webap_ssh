package com.xjd.web.action.login;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.xjd.web.dao.BusDao;
import com.xjd.web.po.BusEntity;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/11/21.
 */

@Results({@Result(name = "input",location = "login-input.jsp")})
public class LoginAction  implements Action {
    @Autowired
    private BusDao busDao;
    private List<BusEntity> busDaos;
    public String login() {
        System.out.println(1231);
        busDaos=busDao.selectBus();
        for (int i=0;i<busDaos.size();i++){
            System.out.println(busDaos.get(i).getBusLine());
        }
        return "input";
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
        return null;
    }
}
