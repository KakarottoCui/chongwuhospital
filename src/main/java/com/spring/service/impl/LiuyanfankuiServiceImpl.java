package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.LiuyanfankuiMapper;
import com.spring.entity.Liuyanfankui;
import com.spring.service.LiuyanfankuiService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("LiuyanfankuiService")
public class LiuyanfankuiServiceImpl extends ServiceBase<Liuyanfankui> implements LiuyanfankuiService {
    @Resource
    private LiuyanfankuiMapper dao;

    @Override
    protected LiuyanfankuiMapper getDao() {
        return dao;
    }
}
