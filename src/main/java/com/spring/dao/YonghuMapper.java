package com.spring.dao;

import com.base.MapperBase;
import com.spring.entity.Yonghu;

import org.springframework.stereotype.Repository;


@Repository
public interface YonghuMapper extends MapperBase<Yonghu> {
    Yonghu login(Yonghu yonghu);
}
