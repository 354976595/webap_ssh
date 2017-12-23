package com.xjd.web.service;

import com.xjd.web.dao.BusDao;
import com.xjd.web.po.BusEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 */
@Service
public class BusService {
    @Autowired
    private BusDao busDao;
    public List<BusEntity> findByExample(BusEntity busEntity){
        return busDao.findByExample(busEntity,1,10);
    }
    public List<BusEntity> select(BusEntity busEntity){
        return busDao.selectBus(busEntity,1);
    }
}
