package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.ShangpinfenleiMapper;
import com.spring.entity.Shangpinfenlei;
import com.spring.service.ShangpinfenleiService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("ShangpinfenleiService")
public class ShangpinfenleiServiceImpl extends ServiceBase<Shangpinfenlei> implements ShangpinfenleiService {
    @Resource
    private ShangpinfenleiMapper dao;

    @Override
    protected ShangpinfenleiMapper getDao() {
        return dao;
    }
}
