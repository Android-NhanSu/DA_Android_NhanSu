package com.example.nhansu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class activity_TTNhanVien extends AppCompatActivity {
    ImageButton btn_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__ttnhan_vien);


        btn_tv = findViewById(R.id.btn_trove_ttnv);
        btn_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_TTNhanVien.this, Menu.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
