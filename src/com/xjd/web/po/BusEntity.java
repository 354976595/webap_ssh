package com.xjd.web.po;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/11/22.
 */
@Entity
@Table(name = "bus", schema = "", catalog = "baoxiu")
public class BusEntity {
    private int id;
    private String company;
    private String busLine;
    private String busNo;
    private String license;
    private String hostVersion;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "company", nullable = true, insertable = true, updatable = true, length = 255)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "bus_line", nullable = true, insertable = true, updatable = true, length = 255)
    public String getBusLine() {
        return busLine;
    }

    public void setBusLine(String busLine) {
        this.busLine = busLine;
    }

    @Basic
    @Column(name = "bus_no", nullable = true, insertable = true, updatable = true, length = 255)
    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    @Basic
    @Column(name = "license", nullable = true, insertable = true, updatable = true, length = 255)
    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Basic
    @Column(name = "host_version", nullable = true, insertable = true, updatable = true, length = 255)
    public String getHostVersion() {
        return hostVersion;
    }

    public void setHostVersion(String hostVersion) {
        this.hostVersion = hostVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusEntity busEntity = (BusEntity) o;

        if (id != busEntity.id) return false;
        if (company != null ? !company.equals(busEntity.company) : busEntity.company != null) return false;
        if (busLine != null ? !busLine.equals(busEntity.busLine) : busEntity.busLine != null) return false;
        if (busNo != null ? !busNo.equals(busEntity.busNo) : busEntity.busNo != null) return false;
        if (license != null ? !license.equals(busEntity.license) : busEntity.license != null) return false;
        if (hostVersion != null ? !hostVersion.equals(busEntity.hostVersion) : busEntity.hostVersion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (busLine != null ? busLine.hashCode() : 0);
        result = 31 * result + (busNo != null ? busNo.hashCode() : 0);
        result = 31 * result + (license != null ? license.hashCode() : 0);
        result = 31 * result + (hostVersion != null ? hostVersion.hashCode() : 0);
        return result;
    }
}
