package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.HuifupinglunMapper;
import com.spring.entity.Huifupinglun;
import com.spring.service.HuifupinglunService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("HuifupinglunService")
public class HuifupinglunServiceImpl extends ServiceBase<Huifupinglun> implements HuifupinglunService {
    @Resource
    private HuifupinglunMapper dao;

    @Override
    protected HuifupinglunMapper getDao() {
        return dao;
    }
}
