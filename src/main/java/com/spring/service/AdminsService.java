package com.spring.service;

import com.base.IServiceBase;
import com.spring.entity.Admins;

public interface AdminsService extends IServiceBase<Admins> {
    public Admins login(String username, String password);
    public boolean updatePassword(int id, String newPassword);
}
