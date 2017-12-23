package com.xjd.web.dao.ImhxyDao;

import com.xjd.web.po.TreasureMap;

import java.util.List;
import java.util.Objects;

/**
 * Created by MACHENIKE on 2017/12/19.
 */
public interface TreaMapDaoInterface {
    void saveMap(TreasureMap treasureMap);
    List<TreasureMap> queryMapAll();
    List<TreasureMap> queryMap(TreasureMap treasureMap);
    void updateMap(Object treasureMap);
    void deleteMap(Object objects);
}
