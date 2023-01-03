package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.GuanyuMapper;
import com.spring.entity.Guanyu;
import com.spring.service.GuanyuService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("GuanyuService")
public class GuanyuServiceImpl extends ServiceBase<Guanyu> implements GuanyuService {
    @Resource
    private GuanyuMapper dao;

    @Override
    protected GuanyuMapper getDao() {
        return dao;
    }
}
