package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import net.jntoo.db.Query;

@Table(name = "dingdanxinxi")
public class Dingdanxinxi implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "dingdanhao")
    private String dingdanhao;
    @Column(name = "shangpinxinxi")
    private String shangpinxinxi;
    @Column(name = "dingdanjine")
    private Double dingdanjine;
    @Column(name = "shouhuoren")
    private String shouhuoren;
    @Column(name = "lianxifangshi")
    private String lianxifangshi;
    @Column(name = "shouhuodizhi")
    private String shouhuodizhi;
    @Column(name = "dingdanzhuangtai")
    private String dingdanzhuangtai;
    @Column(name = "xiadanren")
    private String xiadanren;
    private String iszf;

    @Column(name = "addtime")
    private String addtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getDingdanhao() {
        return dingdanhao;
    }
    public void setDingdanhao(String dingdanhao) {
        this.dingdanhao = dingdanhao == null ? "" : dingdanhao.trim();
    }

    public String getShangpinxinxi() {
        return shangpinxinxi;
    }
    public void setShangpinxinxi(String shangpinxinxi) {
        this.shangpinxinxi = shangpinxinxi == null ? "" : shangpinxinxi.trim();
    }

    public Double getDingdanjine() {
        return dingdanjine;
    }
    public void setDingdanjine(Double dingdanjine) {
        this.dingdanjine = dingdanjine == null ? 0.0f : dingdanjine;
    }

    public String getShouhuoren() {
        return shouhuoren;
    }
    public void setShouhuoren(String shouhuoren) {
        this.shouhuoren = shouhuoren == null ? "" : shouhuoren.trim();
    }

    public String getLianxifangshi() {
        return lianxifangshi;
    }
    public void setLianxifangshi(String lianxifangshi) {
        this.lianxifangshi = lianxifangshi == null ? "" : lianxifangshi.trim();
    }

    public String getShouhuodizhi() {
        return shouhuodizhi;
    }
    public void setShouhuodizhi(String shouhuodizhi) {
        this.shouhuodizhi = shouhuodizhi == null ? "" : shouhuodizhi.trim();
    }

    public String getDingdanzhuangtai() {
        return dingdanzhuangtai;
    }
    public void setDingdanzhuangtai(String dingdanzhuangtai) {
        this.dingdanzhuangtai = dingdanzhuangtai == null ? "" : dingdanzhuangtai.trim();
    }

    public String getXiadanren() {
        return xiadanren;
    }
    public void setXiadanren(String xiadanren) {
        this.xiadanren = xiadanren == null ? "" : xiadanren.trim();
    }
    public String getIszf() {
        return iszf;
    }
    public void setIszf(String iszf) {
        this.iszf = iszf == null ? "" : iszf.trim();
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
