package com.example.learnandroiapp;

public class CongViec {
    private String TieuDe;
    private String ThoiGian;
    private String GhiChu;
    private boolean HoanThanh;

    public CongViec(String TieuDe, String ThoiGian, String GhiChu, boolean HoanThanh) {
        this.TieuDe = TieuDe;
        this.ThoiGian = ThoiGian;
        this.GhiChu = GhiChu;
        this.HoanThanh = HoanThanh;
    }

    public String getTieuDe() {
        return TieuDe;
    }

    public void setTieuDe(String tieuDe) {
        TieuDe = tieuDe;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(String thoiGian) {
        ThoiGian = thoiGian;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }

    public boolean isHoanThanh() {
        return HoanThanh;
    }

    public void setHoanThanh(boolean hoanThanh) {
        HoanThanh = hoanThanh;
    }
}
