package com.example.doanandroid;

public class DatPhong {
    private String id;
    private String ten;
    private String cmnd;
    private String dienthoai;
    private String soluong;
    private String ngaydat;
    private String ngaynhan;

    public DatPhong(String id, String ten, String cmnd, String dienthoai, String soluong, String ngaydat, String ngaynhan) {
        this.id = id;
        this.ten = ten;
        this.cmnd = cmnd;
        this.dienthoai = dienthoai;
        this.soluong = soluong;
        this.ngaydat = ngaydat;
        this.ngaynhan = ngaynhan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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

    public String getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(String ngaydat) {
        this.ngaydat = ngaydat;
    }

    public String getNgaynhan() {
        return ngaynhan;
    }

    public void setNgaynhan(String ngaynhan) {
        this.ngaynhan = ngaynhan;
    }
}
