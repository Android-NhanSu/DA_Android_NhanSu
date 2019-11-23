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

        btn_tv = findViewById(R.id.btn_trove_lscc);
        btn_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LSChamCong.this, Menu.class);
                startActivity(intent);
                finish();
            }
        });
       // setWight();

        //gọi getuserlist

        List<item_lscc> ls= null;
        try {
            ls = us.getuserlist();
            Log.d(TAG, "onCreate: "+ls.size());
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

//        editDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ChonNgay();
//            }
//        });

    }

    //    private List<item_lscc> getListData() {
//        ArrayList<item_lscc> list=new ArrayList<>();
////        List<item_lscc> list = new ArrayList<item_lscc>();
////        Date today=new Date(System.currentTimeMillis());
//     //   SimpleDateFormat timeFormat= new SimpleDateFormat("dd/MM/yyyy");
//       // String s=timeFormat.format(today.getTime());
//      //  item_lscc cc = new item_lscc(s, "8:00", "17:00");
//        list.add(new item_lscc("01/11/2019","8:00","17:00"));
//        list.add(new item_lscc("02/11/2019","7:50","17:20"));
//        list.add(new item_lscc("03/11/2019","8:10","17:10"));
//        list.add(new item_lscc("04/11/2019","7:59","17:05"));
//        list.add(new item_lscc("05/11/2019","8:02","17:00"));
//        list.add(new item_lscc("06/11/2019","8:00","17:01"));
//        list.add(new item_lscc("07/11/2019","8:07","17:11"));
//        list.add(new item_lscc("08/11/2019","8:04","16:59"));
//        list.add(new item_lscc("09/11/2019","8:19","18:00"));
//        return list;
//    }
//    private void setWight() {
//        editDate = (EditText) findViewById(R.id.editTextDate);
//    }
//        private void ChonNgay () {
//            final Calendar calendar = Calendar.getInstance();
//            int ngay = calendar.get(Calendar.DATE);
//            int thang = calendar.get(Calendar.MONTH);
//            int nam = calendar.get(Calendar.YEAR);
//            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//                @Override
//                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
//                    // i:năm - i1: tháng - i:2 ngày
//                    calendar.set(i,i1,i2);
//                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");
//                    editDate.setText(simpleDateFormat.format(calendar.getTime()));
//                }
//            }, nam, thang, ngay);
//            datePickerDialog.show();
//        }

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
