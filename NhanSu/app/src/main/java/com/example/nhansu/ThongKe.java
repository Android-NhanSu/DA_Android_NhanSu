package com.example.nhansu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);
        setWight();


        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonNgay();
            }
        });

        bc=(BarChart) findViewById(R.id.barchar);
        bc.setDrawBarShadow(false);
        bc.setDrawValueAboveBar(true);
        bc.setMaxVisibleValueCount(40);
        bc.setPinchZoom(false);
        bc.setDrawGridBackground(true);
        ArrayList<BarEntry> barEntries=new ArrayList<>();
        barEntries.add(new BarEntry(1,26f));
        barEntries.add(new BarEntry(2,20f));
        barEntries.add(new BarEntry(3,6f));
        barEntries.add(new BarEntry(4,5f));
        barEntries.add(new BarEntry(5,1f));

        BarDataSet barDataSet=new BarDataSet(barEntries,"");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData data =new BarData(barDataSet);
        data.setBarWidth(0.7f);
        bc.setData(data);

       String[] tk=new String[]{"Tổng ","ngày làm","Số ngày nghĩ","Nghĩ ","co phép"};
        XAxis xAxis=bc.getXAxis();
        xAxis.setValueFormatter(new MyXAxisValuesFormatter(tk));
        //xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);

    }
    public class MyXAxisValuesFormatter extends ValueFormatter implements IAxisValueFormatter {
        private String[]mValues;
        public MyXAxisValuesFormatter(String[] values)
        {
            this.mValues=values;
        }
        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mValues[(int)value];
        }
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
