package com.xjd.web.action.bus;

import com.google.gson.Gson;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.xjd.web.dao.BusDao;
import com.xjd.web.service.BusService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/21.
 */
public class BusAction implements Action {
    @Autowired
    private BusService busService;
    @Autowired
    private BusDao busDao;
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
        return LOGIN;
    }
   @Validations(requiredStrings = {
           @RequiredStringValidator(fieldName = "BusEntity.busNo",message = "dasda")
   })
    public  String testJquery(){
        System.out.println(123);
        return "success";

    }

    public static void responseToWeb(String js) throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;utf-8");
        PrintWriter pt = response.getWriter();
        pt.println(js);
        pt.flush();
        pt.close();
    }
}
