package com.poly.admin.wacthshop.Model;

public class DongHo {
    private String maDongHo;
    private String maLoaiDongHo;
    private String tenDongHo;
    private double gia;
    private int soLuong;

    public DongHo() {
    }

    public DongHo(String maLoaiDongHo, String maDongHo, String tenDongHo, double gia, int soLuong) {
        this.maLoaiDongHo = maLoaiDongHo;
        this.maDongHo = maDongHo;
        this.tenDongHo = tenDongHo;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public String getMaLoaiDongHo() {
        return maLoaiDongHo;
    }

    public void setMaLoaiDongHo(String maLoaiDongHo) {
        this.maLoaiDongHo = maLoaiDongHo;
    }

    public String getMaDongHo() {
        return maDongHo;
    }

    public void setMaDongHo(String maDongHo) {
        this.maDongHo = maDongHo;
    }

    public String getTenDongHo() {
        return tenDongHo;
    }

    public void setTenDongHo(String tenDongHo) {
        this.tenDongHo = tenDongHo;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "DongHo{" +
                "maLoaiDongHo='" + maLoaiDongHo + '\'' +
                ", maDongHo='" + maDongHo + '\'' +
                ", tenDongHo='" + tenDongHo + '\'' +
                ", gia=" + gia +
                ", soLuong=" + soLuong +
                '}';
    }
}
