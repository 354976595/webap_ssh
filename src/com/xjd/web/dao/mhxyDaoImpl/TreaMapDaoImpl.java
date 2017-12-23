package com.xjd.web.dao.mhxyDaoImpl;

import com.xjd.web.dao.ImhxyDao.TreaMapDaoInterface;
import com.xjd.web.po.TreasureMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

/**
 * Created by MACHENIKE on 2017/12/19.
 */
@Repository
public class TreaMapDaoImpl implements TreaMapDaoInterface {
    @Autowired
    private HibernateTemplate ht;

    public void saveMap(TreasureMap treasureMap) {
        ht.save(treasureMap);
    }

    public List<TreasureMap> queryMapAll() {
        String hql="from TreasureMap";
        return ht.find(hql);
    }

    public List<TreasureMap> queryMap(TreasureMap condition) {
        String hql="from TreasureMap where address=? and item like ?";
        return ht.find(hql,condition.getAddress(),"'"+condition.getItem()+"'");
    }

    public void updateMap(Object treasureMap) {
        ht.update(treasureMap);
    }


    public void deleteMap(Object objects) {
    ht.delete(objects);
    }


}
