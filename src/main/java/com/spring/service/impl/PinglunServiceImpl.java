package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.PinglunMapper;
import com.spring.entity.Pinglun;
import com.spring.service.PinglunService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("PinglunService")
public class PinglunServiceImpl extends ServiceBase<Pinglun> implements PinglunService {
    @Resource
    private PinglunMapper dao;

    @Override
    protected PinglunMapper getDao() {
        return dao;
    }
}
