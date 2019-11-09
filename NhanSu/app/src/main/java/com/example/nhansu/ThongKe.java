package com.example.nhansu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.nhansu.Model_Adapter.CustomListAdapter;
import com.example.nhansu.Model_Adapter.litsitem;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.lang.ref.SoftReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ThongKe extends AppCompatActivity {
    BarChart bc;
    EditText editDate;
    ImageButton btn_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);

        btn_tv = findViewById(R.id.btn_trove_tk);
        btn_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThongKe.this, Menu.class);
                startActivity(intent);
                finish();
            }
        });
        setWight();


        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonNgay();
            }
        });

        bc = (BarChart) findViewById(R.id.barchar);
        bc.setDrawBarShadow(false);
        bc.setDrawValueAboveBar(true);
        bc.setMaxVisibleValueCount(40);
        bc.setPinchZoom(false);
        bc.setDrawGridBackground(true);
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 26f));
        barEntries.add(new BarEntry(2, 20f));
        barEntries.add(new BarEntry(3, 6f));
        barEntries.add(new BarEntry(4, 5f));
        barEntries.add(new BarEntry(5, 1f));

        BarDataSet barDataSet = new BarDataSet(barEntries, "");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData data = new BarData(barDataSet);
        data.setBarWidth(0.7f);
        bc.setData(data);

      /*  String[] tk = new String[]{"t", "nl", "nn", "cp", "kp"};
        XAxis xAxis = bc.getXAxis();
        xAxis.setValueFormatter(new MyXAxisValuesFormatter(tk));

    }
    public class MyXAxisValuesFormatter extends ValueFormatter implements IAxisValueFormatter {
        private String[] mValues;

        public MyXAxisValuesFormatter(String[] values) {
            this.mValues = values;
        }

        public String getFormattedValue(float value, AxisBase axis) {
            return mValues[(int) value];
        }*/
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
