package com.poly.admin.wacthshop.Model;

public class LoaiDongHo {
    private String maLoaiDongHo;
    private String tenLoaiDongHo;
    private String moTa;

    public LoaiDongHo() {
    }

    public LoaiDongHo(String maLoaiDongHo, String tenLoaiDongHo, String moTa) {
        this.maLoaiDongHo = maLoaiDongHo;
        this.tenLoaiDongHo = tenLoaiDongHo;
        this.moTa = moTa;
    }

    public String getMaLoaiDongHo() {
        return maLoaiDongHo;
    }

    public void setMaLoaiDongHo(String maLoaiDongHo) {
        this.maLoaiDongHo = maLoaiDongHo;
    }

    public String getTenLoaiDongHo() {
        return tenLoaiDongHo;
    }

    public void setTenLoaiDongHo(String tenLoaiDongHo) {
        this.tenLoaiDongHo = tenLoaiDongHo;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return getMaLoaiDongHo() + " | " + getTenLoaiDongHo();
    }
}
