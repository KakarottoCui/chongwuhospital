package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.YonghuMapper;
import com.spring.entity.Yonghu;
import com.spring.service.YonghuService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("YonghuService")
public class YonghuServiceImpl extends ServiceBase<Yonghu> implements YonghuService {
    @Resource
    private YonghuMapper dao;

    @Override
    protected YonghuMapper getDao() {
        return dao;
    }
    public Yonghu login(String username, String password) {
        Yonghu user = new Yonghu();
        user.setYonghuming(username);
            user.setMima(password);

        return this.dao.login(user);
    }

    public boolean updatePassword(int id, String newPassword) {
        Yonghu user = new Yonghu();
        user.setId(id);
            user.setMima(newPassword);
        int i = this.dao.updateByPrimaryKeySelective(user);
        return i == 1;
    }
}
