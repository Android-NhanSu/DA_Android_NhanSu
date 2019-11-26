package com.example.nhansu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.nhansu.Model_Adapter.Adapter_lscc;
import com.example.nhansu.Model_Adapter.Adapter_nv;
import com.example.nhansu.Model_Adapter.UserModel_NV;
import com.example.nhansu.Model_Adapter.item_lscc;
import com.example.nhansu.Model_Adapter.item_nv;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class activity_TTNhanVien extends AppCompatActivity {
    ImageButton btn_tv;
    UserModel_NV nv=new UserModel_NV();
    Adapter_nv adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__ttnhan_vien);


       /* List<item_nv> ls= null;
        try {
            ls = nv.loadnv();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final ListView listView = (ListView) findViewById(R.id.lwnv);

        adapter= new Adapter_nv(this,ls);
        listView.setAdapter(adapter);*/


        ////////////////////////////////////
        btn_tv = findViewById(R.id.Suattnv);
        btn_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_TTNhanVien.this, Sua_TT_NhanVien.class);
                startActivity(intent);
            }
        });
    }
    private List<item_nv> getListData() {
        ArrayList<item_nv> list = new ArrayList<>();
        list.add(new item_nv("2001160306","Lê Thị Mỹ Hương","nữ","0376007840","huong98@gmail.com","17 Bùi Xuân Phái","Trưởng Phòng"
                ,"Nhân sự","Tiếng anh","Đại học","2/10/2015","16/02/1998","Quảng Ngãi"));
        return list;
    }

}
