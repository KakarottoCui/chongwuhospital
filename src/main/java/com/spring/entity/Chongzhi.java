package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import net.jntoo.db.Query;

@Table(name = "chongzhi")
public class Chongzhi implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "yonghuming")
    private String yonghuming;
    @Column(name = "xingming")
    private String xingming;
    @Column(name = "chongzhijine")
    private Double chongzhijine;
    @Column(name = "chongzhiren")
    private String chongzhiren;
    private Integer yonghuid;

    @Column(name = "addtime")
    private String addtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getYonghuming() {
        return yonghuming;
    }
    public void setYonghuming(String yonghuming) {
        this.yonghuming = yonghuming == null ? "" : yonghuming.trim();
    }

    public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
        this.xingming = xingming == null ? "" : xingming.trim();
    }

    public Double getChongzhijine() {
        return chongzhijine;
    }
    public void setChongzhijine(Double chongzhijine) {
        this.chongzhijine = chongzhijine == null ? 0.0f : chongzhijine;
    }

    public String getChongzhiren() {
        return chongzhiren;
    }
    public void setChongzhiren(String chongzhiren) {
        this.chongzhiren = chongzhiren == null ? "" : chongzhiren.trim();
    }
    public Integer getYonghuid() {
        return yonghuid;
    }
    public void setYonghuid(Integer yonghuid) {
        this.yonghuid = yonghuid == null ? 0 : yonghuid;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
