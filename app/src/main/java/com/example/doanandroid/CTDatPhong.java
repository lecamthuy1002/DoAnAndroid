package com.example.doanandroid;

import java.util.Date;

public class CTDatPhong {
    private String name;
    private String cmnd;
    private String dienthoai;
    private String soluong;
    private Date ngaydat;
    private Date ngaynhan;

    public CTDatPhong(String name, String cmnd, String dienthoai, String soluong, Date ngaydat, Date ngaynhan) {
        this.name = name;
        this.cmnd = cmnd;
        this.dienthoai = dienthoai;
        this.soluong = soluong;
        this.ngaydat = ngaydat;
        this.ngaynhan = ngaynhan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public Date getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(Date ngaydat) {
        this.ngaydat = ngaydat;
    }

    public Date getNgaynhan() {
        return ngaynhan;
    }

    public void setNgaynhan(Date ngaynhan) {
        this.ngaynhan = ngaynhan;
    }
}
