package com.example.nhansu.Model_Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nhansu.LSChamCong;
import com.example.nhansu.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Adapter_khenthuong extends BaseAdapter {
    private List<item_khenthuong> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    private ArrayList<item_khenthuong> arrayList;

    public Adapter_khenthuong(Context aContext, int griditem_khenthuong, List<item_khenthuong> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
        this.arrayList = new ArrayList<item_khenthuong>();
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

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.griditem_khenthuong, null);
            holder = new ViewHolder();
            holder.flagView = (TextView) convertView.findViewById(R.id.textViewNgay);
            holder.countryNameView = (TextView) convertView.findViewById(R.id.textViewLyDo);
            holder.populationView = (TextView) convertView.findViewById(R.id.textViewTienThuong);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        item_khenthuong country = this.listData.get(position);
        holder.flagView.setText( country.getNgay());
        holder.countryNameView.setText(country.getLydo());
        holder.populationView.setText( country.getTienthuong());


        return convertView;
    }

    // Tìm ID của Image ứng với tên của ảnh (Trong thư mục mipmap).
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();

        // Trả về 0 nếu không tìm thấy.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomGridView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    static class ViewHolder {

        TextView countryNameView;
        TextView populationView;
        TextView flagView;
    }

    // seach view
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        listData.clear();
        if (charText.length() == 0) {
            listData.addAll(arrayList);
        } else {
            for (item_khenthuong wp : arrayList) {
                if ((wp.getNgay().toLowerCase(Locale.getDefault()).contains(charText)) )
                {
                    listData.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
