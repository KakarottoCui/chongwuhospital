package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.GouwucheMapper;
import com.spring.entity.Gouwuche;
import com.spring.service.GouwucheService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("GouwucheService")
public class GouwucheServiceImpl extends ServiceBase<Gouwuche> implements GouwucheService {
    @Resource
    private GouwucheMapper dao;

    @Override
    protected GouwucheMapper getDao() {
        return dao;
    }
}
