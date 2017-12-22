package com.xjd.web.action.bus;

import com.google.gson.Gson;
import com.opensymphony.xwork2.Action;
import com.xjd.web.dao.BusDao;
import com.xjd.web.po.BusEntity;
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
    private List<BusEntity> list;
    private Map<Integer,BusEntity> map;

    public List<BusEntity> getList() {
        return list;
    }

    public void setList(List<BusEntity> list) {
        this.list = list;
    }

    public Map<Integer, BusEntity> getMap() {
        return map;
    }

    public void setMap(Map<Integer, BusEntity> map) {
        this.map = map;
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
        BusEntity busEntity=new BusEntity();
        busEntity.setCompany("巴士一公司");
        list=busService.findByExample(busEntity);
        java.util.Map<Integer, BusEntity> map= new HashMap<Integer, BusEntity>();
        for (BusEntity entity : list) {
            System.out.println(entity.getBusNo());
        }
        for (int i = 0; i < list.size(); i++) {
            map.put(i,list.get(i));
        }
        Gson gson=new Gson();
        String js= gson.toJson(map);
        List<BusEntity> list1=null;
        try{
             list1= busService.select(busEntity);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        for (BusEntity entity : list1) {
            System.out.println("cre"+entity.getBusLine());
        }
       // responseToWeb(js);
        return LOGIN;
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
