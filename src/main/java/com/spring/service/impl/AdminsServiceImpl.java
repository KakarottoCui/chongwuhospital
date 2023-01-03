package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.AdminsMapper;
import com.spring.entity.Admins;
import com.spring.service.AdminsService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("AdminsService")
public class AdminsServiceImpl extends ServiceBase<Admins> implements AdminsService {
    @Resource
    private AdminsMapper dao;

    @Override
    protected AdminsMapper getDao() {
        return dao;
    }
    public Admins login(String username, String password) {
        Admins user = new Admins();
        user.setUsername(username);
            user.setPwd(password);

        return this.dao.login(user);
    }

    public boolean updatePassword(int id, String newPassword) {
        Admins user = new Admins();
        user.setId(id);
            user.setPwd(newPassword);
        int i = this.dao.updateByPrimaryKeySelective(user);
        return i == 1;
    }
}
