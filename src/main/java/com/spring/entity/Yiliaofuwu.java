package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import net.jntoo.db.Query;

@Table(name = "yiliaofuwu")
public class Yiliaofuwu implements Serializable {
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
    @Column(name = "yiyuyuerenshu")
    private Integer yiyuyuerenshu;
    @Column(name = "fuwuneirong")
    private String fuwuneirong;

    @Column(name = "addtime")
    private String addtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getFuwuyuyueCount()
    {
        return Query.make("fuwuyuyue").where("yiliaofuwuid" , id).count();
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

    public Integer getYiyuyuerenshu() {
        return yiyuyuerenshu;
    }
    public void setYiyuyuerenshu(Integer yiyuyuerenshu) {
        this.yiyuyuerenshu = yiyuyuerenshu == null ? 0 : yiyuyuerenshu;
    }

    public String getFuwuneirong() {
        return fuwuneirong;
    }
    public void setFuwuneirong(String fuwuneirong) {
        this.fuwuneirong = fuwuneirong == null ? "" : fuwuneirong.trim();
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
