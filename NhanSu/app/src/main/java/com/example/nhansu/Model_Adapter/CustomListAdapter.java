package com.example.nhansu.Model_Adapter;

import android.annotation.SuppressLint;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nhansu.R;

import java.sql.Time;
import java.util.List;


public class CustomListAdapter extends BaseAdapter {
    private List<litsitem> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter( Context context,List<litsitem> listData) {
        this.context = context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.layout_row, null);
            holder = new ViewHolder();
            holder.today= (TextView)view.findViewById(R.id.txtngay);
            holder.gv= (TextView)view.findViewById(R.id.dulieugiovao);
            holder.gr= (TextView)view.findViewById(R.id.dulieugiora);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        litsitem country = this.listData.get(i);
        holder.today.setText(country.getNgay());
        holder.gv.setText(country.getGiovao());
        holder.gr.setText(country.getGiora());
        return view;
    }
    static class ViewHolder {
        TextView today;
        TextView gv;
        TextView gr;
    }
}
