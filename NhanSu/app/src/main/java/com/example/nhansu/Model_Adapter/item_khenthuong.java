package com.example.nhansu.Model_Adapter;

public class item_khenthuong {
    private String Ngay;
    private String Lydo;
    private String Tienthuong;

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String ngay) {
        Ngay = ngay;
    }

    public String getLydo() {
        return Lydo;
    }

    public void setLydo(String lydo) {
        Lydo = lydo;
    }

    public String getTienthuong() {
        return Tienthuong;
    }

    public void setTienthuong(String tienthuong) {
        Tienthuong = tienthuong;
    }

    public item_khenthuong(String ngay, String lydo, String tienthuong) {
        Ngay = ngay;
        Lydo = lydo;
        Tienthuong = tienthuong;
    }
}
