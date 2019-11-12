package com.example.nhansu.Model_Adapter;

import java.sql.Date;
import java.sql.Time;

public class item_lscc {
    private String ngay;
    private String giovao;
    private String giora;

    public item_lscc(String ngay, String giovao, String giora) {
        this.ngay = ngay;
        this.giovao = giovao;
        this.giora = giora;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getGiovao() {
        return giovao;
    }

    public void setGiovao(String giovao) {
        this.giovao = giovao;
    }

    public String getGiora() {
        return giora;
    }

    public void setGiora(String giora) {
        this.giora = giora;
    }
}
