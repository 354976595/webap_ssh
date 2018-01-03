package com.xjd.web.service;

import com.xjd.web.dao.BusDao;
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

}
