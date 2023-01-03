package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.DingdanxinxiMapper;
import com.spring.entity.Dingdanxinxi;
import com.spring.service.DingdanxinxiService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("DingdanxinxiService")
public class DingdanxinxiServiceImpl extends ServiceBase<Dingdanxinxi> implements DingdanxinxiService {
    @Resource
    private DingdanxinxiMapper dao;

    @Override
    protected DingdanxinxiMapper getDao() {
        return dao;
    }
}
