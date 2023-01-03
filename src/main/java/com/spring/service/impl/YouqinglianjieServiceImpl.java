package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.YouqinglianjieMapper;
import com.spring.entity.Youqinglianjie;
import com.spring.service.YouqinglianjieService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("YouqinglianjieService")
public class YouqinglianjieServiceImpl extends ServiceBase<Youqinglianjie> implements YouqinglianjieService {
    @Resource
    private YouqinglianjieMapper dao;

    @Override
    protected YouqinglianjieMapper getDao() {
        return dao;
    }
}
