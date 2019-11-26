package com.example.nhansu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    Button btn_nv;
    Button btn_luong;
    Button btn_chamCong;
    Button btn_dx;
    Button btn_tk;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        user = getIntent().getStringExtra("Username");

        btn_nv = findViewById(R.id.btn_ttnv);
        btn_nv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, activity_TTNhanVien.class);
                intent.putExtra("Username",user);
                startActivity(intent);
            }
        });

        btn_luong = findViewById(R.id.btn_luong);
        btn_luong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Luong.class);
                startActivity(intent);
            }
        });
        btn_chamCong = findViewById(R.id.btn_lscc);
        btn_chamCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, LSChamCong.class);
                startActivity(intent);
            }
        });
        btn_tk = findViewById(R.id.btn_tk);
        btn_tk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, ThongKe.class);
                startActivity(intent);
            }
        });
        btn_dx = findViewById(R.id.btn_dx);
        btn_dx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

}
