package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import net.jntoo.db.Query;

@Table(name = "gouwuche")
public class Gouwuche implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "shangpinbianhao")
    private String shangpinbianhao;
    @Column(name = "shangpinmingcheng")
    private String shangpinmingcheng;
    @Column(name = "tupian")
    private String tupian;
    @Column(name = "jiage")
    private Double jiage;
    @Column(name = "goumaishuliang")
    private Integer goumaishuliang;
    @Column(name = "xiaoji")
    private Double xiaoji;
    @Column(name = "goumairen")
    private String goumairen;
    private Integer shangpinxinxiid;

    @Column(name = "addtime")
    private String addtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getShangpinbianhao() {
        return shangpinbianhao;
    }
    public void setShangpinbianhao(String shangpinbianhao) {
        this.shangpinbianhao = shangpinbianhao == null ? "" : shangpinbianhao.trim();
    }

    public String getShangpinmingcheng() {
        return shangpinmingcheng;
    }
    public void setShangpinmingcheng(String shangpinmingcheng) {
        this.shangpinmingcheng = shangpinmingcheng == null ? "" : shangpinmingcheng.trim();
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

    public Integer getGoumaishuliang() {
        return goumaishuliang;
    }
    public void setGoumaishuliang(Integer goumaishuliang) {
        this.goumaishuliang = goumaishuliang == null ? 0 : goumaishuliang;
    }

    public Double getXiaoji() {
        return xiaoji;
    }
    public void setXiaoji(Double xiaoji) {
        this.xiaoji = xiaoji == null ? 0.0f : xiaoji;
    }

    public String getGoumairen() {
        return goumairen;
    }
    public void setGoumairen(String goumairen) {
        this.goumairen = goumairen == null ? "" : goumairen.trim();
    }
    public Integer getShangpinxinxiid() {
        return shangpinxinxiid;
    }
    public void setShangpinxinxiid(Integer shangpinxinxiid) {
        this.shangpinxinxiid = shangpinxinxiid == null ? 0 : shangpinxinxiid;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
