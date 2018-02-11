package com.xjd.web.po;

/**
 * Created by Administrator on 2018/1/17.
 */
public class Test {
    private String driverCode;
    private String        driverName;
    private String lineCode;
    private String busCode;

    @Override
    public String toString() {
        return "Test{" +
                "driverCode='" + driverCode + '\'' +
                ", driverName='" + driverName + '\'' +
                ", lineCode='" + lineCode + '\'' +
                ", busCode='" + busCode + '\'' +
                '}';
    }

    public String getDriverCode() {
        return driverCode;
    }

    public void setDriverCode(String driverCode) {
        this.driverCode = driverCode;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public String getBusCode() {
        return busCode;
    }

    public void setBusCode(String busCode) {
        this.busCode = busCode;
    }
}
