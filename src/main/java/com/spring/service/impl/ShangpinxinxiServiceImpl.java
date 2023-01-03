package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.ShangpinxinxiMapper;
import com.spring.entity.Shangpinxinxi;
import com.spring.service.ShangpinxinxiService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("ShangpinxinxiService")
public class ShangpinxinxiServiceImpl extends ServiceBase<Shangpinxinxi> implements ShangpinxinxiService {
    @Resource
    private ShangpinxinxiMapper dao;

    @Override
    protected ShangpinxinxiMapper getDao() {
        return dao;
    }
}
