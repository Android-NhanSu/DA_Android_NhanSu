package com.example.nhansu.Model_Adapter;

public class item_suattnv {
    public String manv;
    public  String sdtuv;
    public  String diachiuv;
    public  String emailuv;


    public item_suattnv(String manv, String sdtuv, String diachiuv, String emailuv) {
        this.manv = manv;
        this.sdtuv = sdtuv;
        this.diachiuv = diachiuv;
        this.emailuv = emailuv;
    }

    public String getManv() {
        return manv;
    }

    public void setMauv(String mauv) {
        this.manv = mauv;
    }

    public String getSdtuv() {
        return sdtuv;
    }

    public void setSdtuv(String sdtuv) {
        this.sdtuv = sdtuv;
    }

    public String getDiachiuv() {
        return diachiuv;
    }

    public void setDiachiuv(String diachiuv) {
        this.diachiuv = diachiuv;
    }

    public String getEmailuv() {
        return emailuv;
    }

    public void setEmailuv(String emailuv) {
        this.emailuv = emailuv;
    }
}
