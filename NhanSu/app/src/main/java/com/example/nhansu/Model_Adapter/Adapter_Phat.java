package com.example.nhansu.Model_Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nhansu.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Adapter_Phat extends BaseAdapter{
    private List<item_phat> listDataPhat;
    private LayoutInflater layoutInflater;
    private Context context;
    private ArrayList<item_phat> arrayList;

    public Adapter_Phat(Context aContext, int griditem_phat, List<item_phat> listDataPhat) {
        this.context = aContext;
        this.listDataPhat = listDataPhat;
        layoutInflater = LayoutInflater.from(aContext);
        this.arrayList = new ArrayList<item_phat>();
        this.arrayList.addAll(listDataPhat);
    }

    @Override
    public int getCount() {
        return listDataPhat.size();
    }

    @Override
    public Object getItem(int position) {
        return listDataPhat.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Adapter_Phat.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.griditem_phat, null);
            holder = new Adapter_Phat.ViewHolder();
            holder.flagView = (TextView) convertView.findViewById(R.id.textViewNgayPhat);
            holder.countryNameView = (TextView) convertView.findViewById(R.id.textViewLyDoPhat);
            holder.populationView = (TextView) convertView.findViewById(R.id.textViewTienPhat);
            convertView.setTag(holder);
        } else {
            holder = (Adapter_Phat.ViewHolder) convertView.getTag();
        }

        item_phat country = this.listDataPhat.get(position);
        holder.flagView.setText( country.getNgayPhat());
        holder.countryNameView.setText(country.getLydoPhat());
        holder.populationView.setText( country.getTienPhat());


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
    public void filter1(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        listDataPhat.clear();
        if (charText.length() == 0) {
            listDataPhat.addAll(arrayList);
        } else {
            for (item_phat wp : arrayList) {
                if ((wp.getNgayPhat().toLowerCase(Locale.getDefault()).contains(charText)) )
                {
                    listDataPhat.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
