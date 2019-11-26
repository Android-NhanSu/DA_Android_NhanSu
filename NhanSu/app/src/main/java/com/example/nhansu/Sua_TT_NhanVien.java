package com.example.nhansu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nhansu.Model_Adapter.Adapter_suaTTNV;
import com.example.nhansu.Model_Adapter.UserModel_NV;
import com.example.nhansu.Model_Adapter.item_suattnv;

import java.sql.SQLException;
import java.util.List;


public class Sua_TT_NhanVien extends AppCompatActivity {
    Button btn_sua;
    UserModel_NV nv=new UserModel_NV();
    Adapter_suaTTNV adapter;
    EditText manv, sdt,dc,emai;
    String manv1,sdt1,dc1,email1;
    String users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua__tt__nhan_vien);

         users = getIntent().getStringExtra("Username");

        List<item_suattnv> ls= null;
        try {
            ls = nv.loadhsuv(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final ListView listView = (ListView) findViewById(R.id.ttcs);

        adapter= new Adapter_suaTTNV(this,R.layout.row_suattnv,ls);
        listView.setAdapter(adapter);


    }
    public void sua(View view) {
        manv = (EditText) findViewById(R.id.manv);
        sdt = (EditText) findViewById(R.id.sdtnv);
        dc=(EditText) findViewById(R.id.diachinv);
        emai=(EditText) findViewById(R.id.emailnv) ;
        manv1  = manv.getText().toString();
        sdt1  = sdt.getText().toString();
        dc1  = dc.getText().toString();
        email1  = emai.getText().toString();

        try {
            if(nv.Update(manv1,sdt1,dc1,email1)==true)
            {

                List<item_suattnv> ls= null;
                try {
                    ls = nv.loadhsuv(users);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                final ListView listView = (ListView) findViewById(R.id.ttcs);
                adapter= new Adapter_suaTTNV(this,R.layout.row_suattnv,ls);
                listView.setAdapter(adapter);
                Toast.makeText(this, "Thành công", Toast.LENGTH_LONG).show();

            }
            else {
                Toast.makeText(this, "Thất bại", Toast.LENGTH_LONG).show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(this, "Thất bại", Toast.LENGTH_LONG).show();
        }


    }
}
