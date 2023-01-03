package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.ShoucangjiluMapper;
import com.spring.entity.Shoucangjilu;
import com.spring.service.ShoucangjiluService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
/**
 *  业务类
 */
@Service("ShoucangjiluService")
public class ShoucangjiluServiceImpl extends ServiceBase<Shoucangjilu> implements ShoucangjiluService {
    @Resource
    protected ShoucangjiluMapper dao;
    @Override
    protected Mapper<Shoucangjilu> getDao() {
        return dao;
    }
}
