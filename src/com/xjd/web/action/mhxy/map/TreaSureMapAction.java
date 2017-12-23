package com.xjd.web.action.mhxy.map;


import com.opensymphony.xwork2.Action;
import com.xjd.web.po.TreasureMap;
import com.xjd.web.service.mhxy.map.MapServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by MACHENIKE on 2017/12/19.
 */
public class TreaSureMapAction implements Action {
    private    final  String SAVE="save";
    private    final  String QUERY="query";
    private    final  String QUERYALL="mapAll";
    private TreasureMap map;
    private List<TreasureMap> list;
    private static final String[] address;
    private static final String[] item;
    @Autowired
    private MapServiceInterface mapService;

    public TreasureMap getMap() {
        return map;
    }

    public void setMap(TreasureMap map) {
        this.map = map;
    }

    public List<TreasureMap> getList() {
        return list;
    }

    public void setList(List<TreasureMap> list) {
        this.list = list;
    }

    public String execute() throws Exception {
        return INPUT;
    }
    static {
        address=new String[]{"��ׯ","����","����","����","ʨ��","����","����","Ů����","����ɽ","������","���ٴ�","���ٽ���","����","��ҵ",""};
        item=new String[]{"50","60","70","��������","60����","�屦","�ڿ�","����","����","����","�޾�"};
    }

    public static String[] getAddress() {
        return address;
    }

    public static String[] getItem() {
        return item;
    }

    public String saveMapData(){
       if(null!=map){
           System.out.println(map.toString());
           mapService.saveMap(map);
           return SAVE;
       }

        return SAVE;
    }
    public String queryMap(){
        return QUERY;
    }
    public String queryAll(){
        list=mapService.queryAll();
        for (TreasureMap treasureMap : list) {
            System.out.println(treasureMap.toString());
        }
        return QUERYALL;
    }
}
