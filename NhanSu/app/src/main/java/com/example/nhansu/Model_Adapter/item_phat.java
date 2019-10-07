package com.example.nhansu.Model_Adapter;

public class item_phat {
    private String NgayPhat;
    private String LydoPhat;
    private String TienPhat;

    public String getNgayPhat() {
        return NgayPhat;
    }

    public void setNgayPhat(String ngayPhat) {
        NgayPhat = ngayPhat;
    }

    public String getLydoPhat() {
        return LydoPhat;
    }

    public void setLydoPhat(String lydoPhat) {
        LydoPhat = lydoPhat;
    }

    public String getTienPhat() {
        return TienPhat;
    }

    public void setTienPhat(String tienPhat) {
        TienPhat = tienPhat;
    }

    public item_phat(String ngayPhat, String lydoPhat, String tienPhat) {
        NgayPhat = ngayPhat;
        LydoPhat = lydoPhat;
        TienPhat = tienPhat;
    }
}
