package com.xjd.web.dao;

import com.sun.rmi.rmid.ExecPermission;
import com.xjd.web.po.BusEntity;
import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.awt.image.BufferStrategy;
import java.sql.SQLException;
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
    public List<BusEntity> selectBus(final BusEntity entity,int currentPage){
        return hibernateTemplate.execute(new HibernateCallback<List<BusEntity>>() {
            public List<BusEntity> doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(entity.getClass());
                criteria.setReadOnly(false);
                criteria.setFlushMode(FlushMode.COMMIT);
                List list = criteria.list();
                if(list.size()>10){
                    try {
                        throw new Exception("too  big");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return list;
            }
        });
    }
    public List<BusEntity> findByExample(BusEntity busEntity,int fristPage,int pageSize){
        return hibernateTemplate.findByExample(busEntity, 0, 10);
    }

}
