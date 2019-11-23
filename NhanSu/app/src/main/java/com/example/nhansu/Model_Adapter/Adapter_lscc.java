package com.example.nhansu.Model_Adapter;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nhansu.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Adapter_lscc extends BaseAdapter {
    private List<item_lscc> listData;
    private int layout;
    private LayoutInflater layoutInflater;
    private ArrayList<item_lscc> arrayList;
    private Context context;

    public Adapter_lscc(Context context, int layout, List<item_lscc> listData) {
        this.context = context;
        this.layout=layout;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.arrayList = new ArrayList<item_lscc>();
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
        ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.row_lscc, null);
            holder = new ViewHolder();
            holder.today= (TextView)view.findViewById(R.id.txtngay);
            holder.gv= (TextView)view.findViewById(R.id.dulieugiovao);
            holder.gr= (TextView)view.findViewById(R.id.dulieugiora);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        item_lscc country = this.listData.get(i);
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
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        listData.clear();
        if (charText.length() == 0) {
            listData.addAll(arrayList);
        } else {
            for (item_lscc wp : arrayList) {
                if ((wp.getNgay().toLowerCase(Locale.getDefault()).contains(charText)) )
                {
                    listData.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
