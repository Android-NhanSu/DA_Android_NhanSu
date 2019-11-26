package com.example.nhansu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SearchView;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.example.nhansu.Model_Adapter.Adapter_Phat;
import com.example.nhansu.Model_Adapter.Adapter_khenthuong;
import com.example.nhansu.Model_Adapter.Adapter_lscc;
import com.example.nhansu.Model_Adapter.Adapter_luong;
import com.example.nhansu.Model_Adapter.UserModel_Luong;
import com.example.nhansu.Model_Adapter.UserModel_Phat;
import com.example.nhansu.Model_Adapter.UserModel_listLuong;
import com.example.nhansu.Model_Adapter.item_khenthuong;
import com.example.nhansu.Model_Adapter.item_lscc;
import com.example.nhansu.Model_Adapter.item_luong;
import com.example.nhansu.Model_Adapter.item_phat;
public class Luong<lsss, search> extends AppCompatActivity  implements SearchView.OnQueryTextListener, com.example.nhansu.phat, Luongg {
    private static final String TAG = "pp";
    EditText editDate;
    UserModel_Luong luong = new UserModel_Luong();
    UserModel_Phat phat = new UserModel_Phat();
    UserModel_listLuong listLuong = new UserModel_listLuong();
    Adapter_khenthuong adapter;
    Adapter_Phat adapter_phat;
    Adapter_luong adapter_luong;
    SearchView search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luong);


       // editDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ChonNgay();
//            }
//        });
/////////////// khen thuong /////////////////////
        List<item_khenthuong> ls= null;
        try {
            ls = luong.getuserlist_KhenThuong();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    final GridView gridView = (GridView)findViewById(R.id.gridviewKhenThuong);

    adapter= new Adapter_khenthuong(this, R.layout.griditem_khenthuong, ls);

        gridView.setAdapter(adapter);

//////////////// ky luat /////////////////////////////////
        List<item_phat> lss= null;
        try {
            lss = phat.getuserlist_Phat();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        final GridView gridView1 = (GridView) findViewById(R.id.gridviewPhat);

        adapter_phat= new Adapter_Phat(this, R.layout.griditem_phat, lss);

        gridView1.setAdapter(adapter_phat);

/////////////////////////// luong /////////////////////////////
        List<item_luong> lsss= null;

        try {
            lsss = listLuong.getuserlist_luong();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    final ListView listView = (ListView) findViewById(R.id.list_luong);

    adapter_luong= new Adapter_luong(this, R.layout.row_luong, lsss);

        listView.setAdapter(adapter_luong);

        // tim kiếm

        search = findViewById(R.id.Search1);

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


   // @Override
    public boolean onQueryTextSubmit1(String query1) {
        return false;
    }

    public boolean onQueryTextChange1(String newText) {
        String text = newText;
        adapter_phat.filter1(text);
        return false;
    }

    //    private void ChonNgay () {
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
}

