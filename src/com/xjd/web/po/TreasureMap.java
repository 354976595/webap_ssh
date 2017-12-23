package com.xjd.web.po;

import javax.persistence.*;

/**
 * Created by MACHENIKE on 2017/12/19.
 */
@Entity
@Table(name = "treasure_map", schema = "", catalog = "baoxiu")
public class TreasureMap {
    private Double x;
    private Double y;
    private String item;//物品
    private String address;//地点
    private Integer id;//id

    @Basic
    @Column(name = "x", nullable = false, insertable = true, updatable = true, precision = 0)
    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    @Basic
    @Column(name = "y", nullable = false, insertable = true, updatable = true, precision = 0)
    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Basic
    @Column(name = "item", nullable = true, insertable = true, updatable = true, length = 9)
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Basic
    @Column(name = "address", nullable = true, insertable = true, updatable = true, length = 10)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreasureMap that = (TreasureMap) o;

        if (x != null ? !x.equals(that.x) : that.x != null) return false;
        if (y != null ? !y.equals(that.y) : that.y != null) return false;
        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x != null ? x.hashCode() : 0;
        result = 31 * result + (y != null ? y.hashCode() : 0);
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TreasureMap{" +
                "x=" + x +
                ", y=" + y +
                ", item='" + item + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                '}';
    }
}
