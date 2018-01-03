package com.xjd.web.action.login;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xjd.web.dao.BusDao;
import com.xjd.web.po.User;
import com.xjd.web.service.UserService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * Created by Administrator on 2017/11/21.
 */
@ParentPackage(value = "json-default")
@Results({@Result(type = "json", name = "2json", params = {}), @Result(name = "json3", location = "../repair/repair.jsp")})
public class LoginAction  extends  ActionSupport  {
    @Autowired
    private BusDao busDao;
    @Autowired
    private UserService userService;
    private User user;
    private java.util.Date date;
    private String jsonMsg;
    private String name;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    /**
     * to login jsp
     * @return
     */
    public String login() {
        return "input";
    }

    /**
     * IS LOGIN IN?
     * @return
     */
    public String signIn(){
        String result=userService.signIn(user);
        return result;
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
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.setAttribute("loginUser", "hahahah");
        Gson gson = gsonBuilder.create();
        date = new java.util.Date();
        String json = gson.toJson(date.toString());
       // ResponseToWeb.responseToWeb(json);
       // System.out.println("execute");
        HttpServletResponse response = ServletActionContext.getResponse();
        ServletOutputStream out = response.getOutputStream();
        response.setContentType("image/jpeg");
        byte[] b=new byte[8192];
        int count=0;
        System.out.println(ServletActionContext.getServletContext().getRealPath("/"));
        FileInputStream fileInputStream=new FileInputStream(new File(ServletActionContext.getServletContext().getRealPath("/")+"\\image\\1.png"));
      while (true){
          count=fileInputStream.read(b);
          if(count<0){
              break;
          }
        //  out.write(b,0,count);
          out.write(b);
      }
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
        ActionContext.getContext().put("test","testValue");//��ȡcontext����,put()�൱��httpervletrequest��setAttribute
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
