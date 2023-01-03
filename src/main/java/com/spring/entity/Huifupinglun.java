package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import net.jntoo.db.Query;

@Table(name = "huifupinglun")
public class Huifupinglun implements Serializable {
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
    @Column(name = "huifuneirong")
    private String huifuneirong;
    private Integer pinglunid;

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

    public String getHuifuneirong() {
        return huifuneirong;
    }
    public void setHuifuneirong(String huifuneirong) {
        this.huifuneirong = huifuneirong == null ? "" : huifuneirong.trim();
    }
    public Integer getPinglunid() {
        return pinglunid;
    }
    public void setPinglunid(Integer pinglunid) {
        this.pinglunid = pinglunid == null ? 0 : pinglunid;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
