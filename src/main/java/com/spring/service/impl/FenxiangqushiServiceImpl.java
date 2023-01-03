package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.FenxiangqushiMapper;
import com.spring.entity.Fenxiangqushi;
import com.spring.service.FenxiangqushiService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("FenxiangqushiService")
public class FenxiangqushiServiceImpl extends ServiceBase<Fenxiangqushi> implements FenxiangqushiService {
    @Resource
    private FenxiangqushiMapper dao;

    @Override
    protected FenxiangqushiMapper getDao() {
        return dao;
    }
}
