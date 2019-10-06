package com.example.nhansu;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

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
import java.util.ArrayList;

public class ThongKe extends AppCompatActivity {
    BarChart bc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);

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



}
