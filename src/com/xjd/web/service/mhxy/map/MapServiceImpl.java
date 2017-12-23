package com.xjd.web.service.mhxy.map;

import com.xjd.web.dao.ImhxyDao.TreaMapDaoInterface;
import com.xjd.web.po.TreasureMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MACHENIKE on 2017/12/19.
 */
@Service
public class MapServiceImpl implements MapServiceInterface {
    @Autowired
    private TreaMapDaoInterface mapDao;

    public List<TreasureMap> queryMap(TreasureMap treasureMap) {
        return mapDao.queryMap(treasureMap);
    }

    public List<TreasureMap> queryAll() {
        return mapDao.queryMapAll();
    }

    public void saveMap(TreasureMap treasureMap) {
        mapDao.saveMap(treasureMap);
    }

    public void deleteMap(Object o) {
        mapDao.deleteMap(o);
    }

    public void updateMap(Object o) {
        mapDao.updateMap(o);
    }
}
