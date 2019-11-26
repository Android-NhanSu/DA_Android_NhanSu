package com.example.nhansu.Model_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nhansu.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Adapter_luong extends BaseAdapter {
    private int layout;
    private List<item_luong> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    private ArrayList<item_luong> arrayList;

    public Adapter_luong(Context context, int layout, List<item_luong> listData) {
        this.context = context;
        this.layout=layout;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.arrayList = new ArrayList<item_luong>();
        this.arrayList.addAll(listData);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       Adapter_luong.ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.row_luong, null);
            holder = new Adapter_luong.ViewHolder();
            holder.toluong= (TextView)view.findViewById(R.id.luongg);

            view.setTag(holder);
        } else {
            holder = (Adapter_luong.ViewHolder) view.getTag();
        }

        item_luong country = this.listData.get(i);
        holder.toluong.setText(country.getLuong());
        return view;
    }
    static class ViewHolder {

        TextView toluong;
    }


}
