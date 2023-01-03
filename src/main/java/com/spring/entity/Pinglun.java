package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import net.jntoo.db.Query;

@Table(name = "pinglun")
public class Pinglun implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "bianhao")
    private String bianhao;
    @Column(name = "fuwuxiangmu")
    private String fuwuxiangmu;
    @Column(name = "yuyueren")
    private String yuyueren;
    @Column(name = "pingfen")
    private String pingfen;
    @Column(name = "pinglunneirong")
    private String pinglunneirong;
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

    public Long getHuifupinglunCount()
    {
        return Query.make("huifupinglun").where("pinglunid" , id).count();
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

    public String getYuyueren() {
        return yuyueren;
    }
    public void setYuyueren(String yuyueren) {
        this.yuyueren = yuyueren == null ? "" : yuyueren.trim();
    }

    public String getPingfen() {
        return pingfen;
    }
    public void setPingfen(String pingfen) {
        this.pingfen = pingfen == null ? "" : pingfen.trim();
    }

    public String getPinglunneirong() {
        return pinglunneirong;
    }
    public void setPinglunneirong(String pinglunneirong) {
        this.pinglunneirong = pinglunneirong == null ? "" : pinglunneirong.trim();
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
