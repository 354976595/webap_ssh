package com.xjd.web.dao;

import com.xjd.web.po.BusEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/11/22.
 */
@Repository
public class BusDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    public List<BusEntity> selectBus(){
        String hql="from BusEntity";
     return    hibernateTemplate.find(hql);
    }
}
