package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import net.jntoo.db.Query;

@Table(name = "youqinglianjie")
public class Youqinglianjie implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "wangzhanmingcheng")
    private String wangzhanmingcheng;
    @Column(name = "wangzhi")
    private String wangzhi;

    @Column(name = "addtime")
    private String addtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getWangzhanmingcheng() {
        return wangzhanmingcheng;
    }
    public void setWangzhanmingcheng(String wangzhanmingcheng) {
        this.wangzhanmingcheng = wangzhanmingcheng == null ? "" : wangzhanmingcheng.trim();
    }

    public String getWangzhi() {
        return wangzhi;
    }
    public void setWangzhi(String wangzhi) {
        this.wangzhi = wangzhi == null ? "" : wangzhi.trim();
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
