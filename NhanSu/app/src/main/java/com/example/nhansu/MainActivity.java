package com.example.nhansu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nhansu.Model_Adapter.UserModel_dangnhap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    EditText Username, Password;
    Button btn_dn;
    UserModel_dangnhap dn = new UserModel_dangnhap();
    String user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);



//
    }

    public void dangnhap(View view) {

        Username = (EditText) findViewById(R.id.User);
        Password = (EditText) findViewById(R.id.Password);
        user = Username.getText().toString();
        pass = Password.getText().toString();
        if(user.length()==0 || pass.length()==0) {
            Toast.makeText(this, "Vui lòng nhập đủ thông tin" , Toast.LENGTH_LONG).show();

        }
        else {
            try {
                if (dn.kiemtra_user(user, pass)) {
                    Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, Menu.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Thất bại", Toast.LENGTH_LONG).show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
