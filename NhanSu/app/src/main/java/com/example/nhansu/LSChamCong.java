package com.example.nhansu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;


import com.example.nhansu.Model_Adapter.Adapter_lscc;
import com.example.nhansu.Model_Adapter.UserModel_chamcong;
import com.example.nhansu.Model_Adapter.item_lscc;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;

public class LSChamCong extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private static final String TAG = "pp";
    EditText editDate;
    ImageButton btn_tv;
    UserModel_chamcong us=new UserModel_chamcong();
    SearchView search;
    Adapter_lscc adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lscham_cong);


        //gọi getuserlist

        List<item_lscc> ls= null;
        try {
            ls = us.getuserlist();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        final ListView listView = (ListView) findViewById(R.id.chamcong);

        adapter= new Adapter_lscc(this, R.layout.row_lscc, ls);

        listView.setAdapter(adapter);

        // tim kiếm

        search=findViewById(R.id.search);
        search.setQuery("",false);
        search.setOnQueryTextListener(this);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }
}
