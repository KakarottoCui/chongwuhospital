package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.YiliaofuwuMapper;
import com.spring.entity.Yiliaofuwu;
import com.spring.service.YiliaofuwuService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("YiliaofuwuService")
public class YiliaofuwuServiceImpl extends ServiceBase<Yiliaofuwu> implements YiliaofuwuService {
    @Resource
    private YiliaofuwuMapper dao;

    @Override
    protected YiliaofuwuMapper getDao() {
        return dao;
    }
}
