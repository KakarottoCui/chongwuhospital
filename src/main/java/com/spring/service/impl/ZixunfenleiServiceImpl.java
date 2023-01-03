package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.ZixunfenleiMapper;
import com.spring.entity.Zixunfenlei;
import com.spring.service.ZixunfenleiService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("ZixunfenleiService")
public class ZixunfenleiServiceImpl extends ServiceBase<Zixunfenlei> implements ZixunfenleiService {
    @Resource
    private ZixunfenleiMapper dao;

    @Override
    protected ZixunfenleiMapper getDao() {
        return dao;
    }
}
