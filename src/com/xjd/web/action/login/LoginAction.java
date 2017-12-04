package com.xjd.web.action.login;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.conversion.ObjectTypeDeterminer;
import com.xjd.web.dao.BusDao;
import com.xjd.web.po.BusEntity;
import com.xjd.web.util.ResponseToWeb;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/11/21.
 */
@ParentPackage(value = "json-default")
@Results({@Result(type = "json", name = "2json",params = {}),@Result(name = "input",type = "json")})
public class LoginAction implements Action {
    @Autowired
    private BusDao busDao;
    private List<BusEntity> busDaos;
    private java.util.Date date;
    private String jsonMsg;

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
        return null;
    }

    public String json2() {
        //ObjectTypeDeterminer.class
    jsonMsg="this is json string test";
        return "2json";
    }
    @org.apache.struts2.convention.annotation.Action(value = "jsonAction",results = {@Result(name = "json3",location = "../repair/repair.jsp")})
    public String json3(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd");
        Gson gson = gsonBuilder.create();
        date = new java.util.Date();
        String json = gson.toJson(date);
       //ResponseToWeb.responseToWeb(json);
        return "json3";
    }
}
