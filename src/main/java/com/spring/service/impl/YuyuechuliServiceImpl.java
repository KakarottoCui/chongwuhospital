package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.YuyuechuliMapper;
import com.spring.entity.Yuyuechuli;
import com.spring.service.YuyuechuliService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("YuyuechuliService")
public class YuyuechuliServiceImpl extends ServiceBase<Yuyuechuli> implements YuyuechuliService {
    @Resource
    private YuyuechuliMapper dao;

    @Override
    protected YuyuechuliMapper getDao() {
        return dao;
    }
}
