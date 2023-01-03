package com.spring.service;

import com.base.IServiceBase;
import com.spring.entity.Yonghu;

public interface YonghuService extends IServiceBase<Yonghu> {
    public Yonghu login(String username, String password);
    public boolean updatePassword(int id, String newPassword);
}
