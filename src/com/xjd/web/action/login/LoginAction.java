package com.xjd.web.action.login;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xjd.web.dao.BusDao;
import com.xjd.web.dao.UserDao;
import com.xjd.web.po.User;
import com.xjd.web.service.UserService;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
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
public class LoginAction extends ActionSupport {
    private Logger logger = Logger.getLogger(LoginAction.class);
    @Autowired
    private BusDao busDao;
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;
    private User user;
    private java.util.Date date;
    private String jsonMsg;
    private String name;
    private Integer xjd;

    public Integer getXjd() {
        return xjd;
    }

    public void setXjd(Integer xjd) {
        this.xjd = xjd;
    }

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
     *
     * @return
     */
    public String login() {
        return "input";
    }

    /**
     * IS LOGIN IN?
     *
     * @return
     */
    public String signIn() {
        System.out.println(ServletActionContext.getRequest().getRealPath("/image"));

        Cookie[] cookie = ServletActionContext.getRequest().getCookies();
        for (Cookie cookie1 : cookie) {
            System.out.println("cookie name=" + cookie1.getName() + "\ncookie value=" + cookie1.getValue());
        }
        Cookie cookie1 = new Cookie("user.name", user.getName());
        Cookie cookie2 = new Cookie("user.password", user.getPassword());
        ServletActionContext.getResponse().addCookie(cookie1);
        ServletActionContext.getResponse().addCookie(cookie2);
        logger.info(user.toString() + "is  in ");
        synchronized (this) {
            String result = userService.signIn(user);
            logger.debug(user.toString() + "login  in ");
            return result;
        }
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
        byte[] b = new byte[1024];
        int count = 0;
        System.out.println(ServletActionContext.getServletContext().getRealPath("/"));
        FileInputStream fileInputStream = new FileInputStream(new File(ServletActionContext.getServletContext().getRealPath("/") + "\\image\\1.png"));
        while (true) {
            count = fileInputStream.read(b);
            if (count < 0) {
                break;
            }
            //  out.write(b,0,count);
            out.write(b);
        }
        return null;
    }

    public String json2() {
        //ObjectTypeDeterminer.class
        jsonMsg = "this is json string com.xjd.web.juintTestPackage";
        System.out.println("json2");
        return "2json";
    }

    public String success() {
        return Action.SUCCESS;
    }

    // @org.apache.struts2.convention.annotation.Action(value = "pageAction", results = {@Result(name = "json3", location = "../repair/repair.jsp")})
    //@Validations(requiredStrings = {@RequiredStringValidator(fieldName = "name", message = "name is required")})
    public String json3() {
        System.out.println("json3");
        ActionContext.getContext().put("com/xjd/web/juintTestPackage", "testValue");//��ȡcontext����,put()�൱��httpervletrequest��setAttribute
        //ResponseToWeb.responseToWeb(json);
        ActionContext.getContext().getSession().put("com/xjd/web/juintTestPackage", "com.xjd.web.juintTestPackage session");
        ActionContext.getContext().getApplication().put("com/xjd/web/juintTestPackage", "com.xjd.web.juintTestPackage applicationContext");
        int[] a = new int[3];
        a[5] = 11;
        return "json3";
    }

    public String exception() {
        System.out.println("exception action");
        return "exception";
        //   map.put("lineCode", "000800");
    }

    public String heihie() {
        List<Object[]> ol = userDao.findUser();
        for (Object[] objects : ol) {
            System.out.println(objects.length);
            System.out.println(objects[3]);
        }
        return null;

    }

    public String test() {
        // System.out.println(this.xjd++);
//        com.xjd.web.po.Test com.xjd.web.juintTestPackage = new Test();
//        com.xjd.web.juintTestPackage.setLineCode("001800");
//        com.xjd.web.juintTestPackage.setBusCode("bucode");
//        com.xjd.web.juintTestPackage.setDriverCode("321321312");
//        com.xjd.web.juintTestPackage.setDriverName("asdasdas");
//        Gson gson = new Gson();
//        String json = gson.toJson(com.xjd.web.juintTestPackage);
//        userDao.insertUser();
//        System.out.println(json);
//        Map<Object,Object> map=new HashMap<Object, Object>();
//        map.put("driverCode","321321312");
//        map.put("driverName","asdasdas");
//        map.put("lineCode","001800");
//        map.put("busCode","bucode");
//        String sss1 = null;
//        sss1=gson.toJson(map);
//        System.out.println(sss1);
//        System.out.println(sss1.equals(json));
        //   String result = UrlRequest.sendPost("http://192.168.0.152:8080/bimp-base-bst/saveTicket.do", "json=" + json);
        //   System.out.println(result);


        return null;
    }
}
