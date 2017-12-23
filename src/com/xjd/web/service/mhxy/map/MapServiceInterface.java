package com.xjd.web.service.mhxy.map;

import com.xjd.web.po.TreasureMap;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MACHENIKE on 2017/12/19.
 */
//@Service
public interface MapServiceInterface {
    List<TreasureMap> queryMap(TreasureMap treasureMap);
    List<TreasureMap> queryAll( );
    void saveMap(TreasureMap treasureMap);
    void deleteMap(Object o);
    void updateMap(Object o);
}
