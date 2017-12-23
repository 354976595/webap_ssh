package com.xjd.web.action.login;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.ObjectTypeDeterminer;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.xjd.web.dao.BusDao;
import com.xjd.web.po.BusEntity;
import com.xjd.web.util.ResponseToWeb;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.interceptor.Interceptor;
import java.sql.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/11/21.
 */
@ParentPackage(value = "json-default")
@Results({@Result(type = "json", name = "2json", params = {}), @Result(name = "input", type = "json"), @Result(name = "json3", location = "../repair/repair.jsp")})
public class LoginAction  extends  ActionSupport  {
    @Autowired
    private BusDao busDao;
    private List<BusEntity> busDaos;
    private java.util.Date date;
    private String jsonMsg;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BusEntity> getBusDaos() {
        return busDaos;
    }

    public void setBusDaos(List<BusEntity> busDaos) {
        this.busDaos = busDaos;
    }

    public String getJsonMsg() {
        return jsonMsg;
    }

    public void setJsonMsg(String jsonMsg) {
        this.jsonMsg = jsonMsg;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public String login() {
        System.out.println(1231);
        busDaos = busDao.selectBus();
        for (int i = 0; i < busDaos.size(); i++) {
            System.out.println(busDaos.get(i).getBusLine());
        }
        return "input";
//        return "2json";
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
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd");
        Gson gson = gsonBuilder.create();
        date = new java.util.Date();
        String json = gson.toJson(date.toString());
        ResponseToWeb.responseToWeb(json);
        System.out.println("execute");
        return null;
    }

    public String json2() {
        //ObjectTypeDeterminer.class
        jsonMsg = "this is json string test";
        System.out.println("json2");
        return "2json";
    }public  String success(){
        return  Action.SUCCESS;
    }

   // @org.apache.struts2.convention.annotation.Action(value = "pageAction", results = {@Result(name = "json3", location = "../repair/repair.jsp")})
    //@Validations(requiredStrings = {@RequiredStringValidator(fieldName = "name", message = "name is required")})
    public String json3() {
        System.out.println("json3");
        ActionContext.getContext().put("test","testValue");//获取context对象,put()相当于httpervletrequest的setAttribute
        //ResponseToWeb.responseToWeb(json);
        ActionContext.getContext().getSession().put("test","test session");
        ActionContext.getContext().getApplication().put("test", "test applicationContext");
        int [] a=new int[3];
        a[5]=11;
        return "json3";
    }
    public  String exception(){
        System.out.println("exception action");
        return "exception";
    }
}
