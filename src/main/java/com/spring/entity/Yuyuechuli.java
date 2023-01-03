package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import net.jntoo.db.Query;

@Table(name = "yuyuechuli")
public class Yuyuechuli implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "bianhao")
    private String bianhao;
    @Column(name = "fuwuxiangmu")
    private String fuwuxiangmu;
    @Column(name = "tupian")
    private String tupian;
    @Column(name = "jiage")
    private Double jiage;
    @Column(name = "yuyuerenxingming")
    private String yuyuerenxingming;
    @Column(name = "lianxifangshi")
    private String lianxifangshi;
    @Column(name = "yuyueshijian")
    private String yuyueshijian;
    @Column(name = "yuyueren")
    private String yuyueren;
    @Column(name = "beizhu")
    private String beizhu;
    private Integer fuwuyuyueid;

    @Column(name = "addtime")
    private String addtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getBianhao() {
        return bianhao;
    }
    public void setBianhao(String bianhao) {
        this.bianhao = bianhao == null ? "" : bianhao.trim();
    }

    public String getFuwuxiangmu() {
        return fuwuxiangmu;
    }
    public void setFuwuxiangmu(String fuwuxiangmu) {
        this.fuwuxiangmu = fuwuxiangmu == null ? "" : fuwuxiangmu.trim();
    }

    public String getTupian() {
        return tupian;
    }
    public void setTupian(String tupian) {
        this.tupian = tupian == null ? "" : tupian.trim();
    }

    public Double getJiage() {
        return jiage;
    }
    public void setJiage(Double jiage) {
        this.jiage = jiage == null ? 0.0f : jiage;
    }

    public String getYuyuerenxingming() {
        return yuyuerenxingming;
    }
    public void setYuyuerenxingming(String yuyuerenxingming) {
        this.yuyuerenxingming = yuyuerenxingming == null ? "" : yuyuerenxingming.trim();
    }

    public String getLianxifangshi() {
        return lianxifangshi;
    }
    public void setLianxifangshi(String lianxifangshi) {
        this.lianxifangshi = lianxifangshi == null ? "" : lianxifangshi.trim();
    }

    public String getYuyueshijian() {
        return yuyueshijian;
    }
    public void setYuyueshijian(String yuyueshijian) {
        this.yuyueshijian = yuyueshijian == null ? "" : yuyueshijian.trim();
    }

    public String getYuyueren() {
        return yuyueren;
    }
    public void setYuyueren(String yuyueren) {
        this.yuyueren = yuyueren == null ? "" : yuyueren.trim();
    }

    public String getBeizhu() {
        return beizhu;
    }
    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? "" : beizhu.trim();
    }
    public Integer getFuwuyuyueid() {
        return fuwuyuyueid;
    }
    public void setFuwuyuyueid(Integer fuwuyuyueid) {
        this.fuwuyuyueid = fuwuyuyueid == null ? 0 : fuwuyuyueid;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
