package com.example.nhansu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.example.nhansu.Model_Adapter.Adapter_Phat;
import com.example.nhansu.Model_Adapter.Adapter_khenthuong;
import com.example.nhansu.Model_Adapter.item_khenthuong;
import com.example.nhansu.Model_Adapter.item_phat;
public class Luong extends AppCompatActivity {

    EditText editDate;

    //KhenThuong
    GridView gridViewKT;
    item_khenthuong a= new item_khenthuong("1/1/1111","acb","1000000");
    item_khenthuong b= new item_khenthuong("1/1/1111","acb","1000000");
    List<item_khenthuong> itemssss_KT;

   //Phat
    GridView gridViewPhat;
    item_phat c= new item_phat("1/1/1111","acb","1000000");
    item_phat d= new item_phat("1/1/1111","acb","1000000");
    List<item_phat> itemssss_Phat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luong);
        setWight();

        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonNgay();
            }
        });


        itemssss_KT= new ArrayList<item_khenthuong>();
        itemssss_KT.add(a);
        itemssss_KT.add(b);
        Adapter_khenthuong arrayAdapter= new Adapter_khenthuong(this, itemssss_KT);
        gridViewKT.setAdapter(arrayAdapter);


        itemssss_Phat= new ArrayList<item_phat>();
        itemssss_Phat.add(c);
        itemssss_Phat.add(d);
        Adapter_Phat arrayAdapter_P= new Adapter_Phat(this, itemssss_Phat);
        gridViewPhat.setAdapter(arrayAdapter_P);


    }
    private void setWight(){
        editDate = (EditText) findViewById(R.id.editTextDate);
        gridViewKT= (GridView) findViewById(R.id.gridviewKhenThuong);
        gridViewPhat= (GridView) findViewById(R.id.gridviewPhat);

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



    private  List<item_khenthuong> getListData() {
        List<item_khenthuong> list = new ArrayList<item_khenthuong>();
        item_khenthuong ds_khenthuong = new item_khenthuong("Ngày", "Lý do", "Tiền thưởng");

        list.add(ds_khenthuong);
        return list;
    }

    private  List<item_phat> getListDataPhat() {
        List<item_phat> list = new ArrayList<item_phat>();
        item_phat ds_Phat = new item_phat("Ngày", "Lý do", "Tiền phạt");

        list.add(ds_Phat);

        return list;
    }

}

