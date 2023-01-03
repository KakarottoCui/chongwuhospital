package com.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import javax.persistence.*;

@Table(name = "shoucangjilu")
public class Shoucangjilu implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    private String username;

    private Integer xwid;

    private String biao;

    private String ziduan;
    private String biaoti;
    private String url;
    private String addtime;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public String getBiaoti() {
        return biaoti;
    }

    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * @return xwid
     */
    public Integer getXwid() {
        return xwid;
    }

    /**
     * @param xwid
     */
    public void setXwid(Integer xwid) {
        this.xwid = xwid;
    }

    /**
     * @return biao
     */
    public String getBiao() {
        return biao;
    }

    /**
     * @param biao
     */
    public void setBiao(String biao) {
        this.biao = biao == null ? null : biao.trim();
    }

    /**
     * @return ziduan
     */
    public String getZiduan() {
        return ziduan;
    }

    /**
     * @param ziduan
     */
    public void setZiduan(String ziduan) {
        this.ziduan = ziduan == null ? null : ziduan.trim();
    }

    /**
     * @return addtime
     */
    public String getAddtime() {
        return addtime;
    }

    /**
     * @param addtime
     */
    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}