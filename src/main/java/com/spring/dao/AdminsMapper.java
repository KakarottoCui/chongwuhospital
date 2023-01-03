package com.spring.dao;

import com.base.MapperBase;
import com.spring.entity.Admins;

import org.springframework.stereotype.Repository;


@Repository
public interface AdminsMapper extends MapperBase<Admins> {
    Admins login(Admins admins);
}
