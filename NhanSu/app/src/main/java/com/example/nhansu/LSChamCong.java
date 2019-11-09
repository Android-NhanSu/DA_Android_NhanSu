package com.example.nhansu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;


import com.example.nhansu.Model_Adapter.CustomListAdapter;
import com.example.nhansu.Model_Adapter.litsitem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.widget.ImageButton;
import android.widget.ListView;

public class LSChamCong extends AppCompatActivity {
    ImageButton btn_tvlscc;
    EditText editDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lscham_cong);

        btn_tvlscc = findViewById(R.id.btn_trove_lscc);
        btn_tvlscc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LSChamCong.this, Menu.class);
                startActivity(intent);
                finish();
            }
        });

        setWight();

        List<litsitem> image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.chamcong);
        listView.setAdapter(new CustomListAdapter(this,image_details));
        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonNgay();
            }
        });

    }

    private List<litsitem> getListData() {
        List<litsitem> list = new ArrayList<litsitem>();
        Date today=new Date(System.currentTimeMillis());
        SimpleDateFormat timeFormat= new SimpleDateFormat("dd/MM/yyyy");
        String s=timeFormat.format(today.getTime());
        litsitem vietnam = new litsitem(s, "11:20", "11:20");
        list.add(vietnam);

        return list;
    }

    private void setWight() {
        editDate = (EditText) findViewById(R.id.editTextDate);
    }
        private void ChonNgay () {
            final Calendar calendar = Calendar.getInstance();
            int ngay = calendar.get(Calendar.DATE);
            int thang = calendar.get(Calendar.MONTH);
            int nam = calendar.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    // i:năm - i1: tháng - i:2 ngày
                    calendar.set(i,i1,i2);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");
                    editDate.setText(simpleDateFormat.format(calendar.getTime()));
                }
            }, nam, thang, ngay);
            datePickerDialog.show();


        }
}
