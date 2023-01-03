package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.ChongzhiMapper;
import com.spring.entity.Chongzhi;
import com.spring.service.ChongzhiService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("ChongzhiService")
public class ChongzhiServiceImpl extends ServiceBase<Chongzhi> implements ChongzhiService {
    @Resource
    private ChongzhiMapper dao;

    @Override
    protected ChongzhiMapper getDao() {
        return dao;
    }
}
