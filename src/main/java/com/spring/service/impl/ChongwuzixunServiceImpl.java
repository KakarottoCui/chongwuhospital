package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.ChongwuzixunMapper;
import com.spring.entity.Chongwuzixun;
import com.spring.service.ChongwuzixunService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("ChongwuzixunService")
public class ChongwuzixunServiceImpl extends ServiceBase<Chongwuzixun> implements ChongwuzixunService {
    @Resource
    private ChongwuzixunMapper dao;

    @Override
    protected ChongwuzixunMapper getDao() {
        return dao;
    }
}
