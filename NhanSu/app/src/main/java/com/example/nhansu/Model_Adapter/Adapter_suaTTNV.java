package com.example.nhansu.Model_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nhansu.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_suaTTNV extends BaseAdapter {
    private List<item_suattnv> listData;
    private int layout;
    private LayoutInflater layoutInflater;
    private ArrayList<item_suattnv> arrayList;
    private Context context;

    public Adapter_suaTTNV(Context context, int layout, List<item_suattnv> listData) {
        this.context = context;
        this.layout=layout;
        this.listData =listData;
        layoutInflater = LayoutInflater.from(context);
        this.arrayList = new ArrayList<item_suattnv>();
        this.arrayList.addAll(listData);
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
        Adapter_suaTTNV.ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.row_suattnv, null);
            holder = new Adapter_suaTTNV.ViewHolder();
            holder.maunv= (EditText) view.findViewById(R.id.manv);
            holder.sdtuv= (EditText) view.findViewById(R.id.sdtnv);
            holder.dcuv= (EditText) view.findViewById(R.id.diachinv);
            holder.emailuv= (EditText) view.findViewById(R.id.emailnv);
            view.setTag(holder);
        } else {
            holder = (Adapter_suaTTNV.ViewHolder) view.getTag();
        }

        item_suattnv country = this.listData.get(i);
        holder.maunv.setText(country.getManv());
        holder.sdtuv.setText(country.getSdtuv());
        holder.dcuv.setText(country.getDiachiuv());
        holder.emailuv.setText(country.getEmailuv());
        return view;
    }
    static class ViewHolder {
        EditText maunv;
        EditText sdtuv;
        EditText dcuv;
        EditText emailuv;
    }
}