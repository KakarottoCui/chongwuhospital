package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.LunbotuMapper;
import com.spring.entity.Lunbotu;
import com.spring.service.LunbotuService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("LunbotuService")
public class LunbotuServiceImpl extends ServiceBase<Lunbotu> implements LunbotuService {
    @Resource
    private LunbotuMapper dao;

    @Override
    protected LunbotuMapper getDao() {
        return dao;
    }
}
