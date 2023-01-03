package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.FuwuyuyueMapper;
import com.spring.entity.Fuwuyuyue;
import com.spring.service.FuwuyuyueService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("FuwuyuyueService")
public class FuwuyuyueServiceImpl extends ServiceBase<Fuwuyuyue> implements FuwuyuyueService {
    @Resource
    private FuwuyuyueMapper dao;

    @Override
    protected FuwuyuyueMapper getDao() {
        return dao;
    }
}
