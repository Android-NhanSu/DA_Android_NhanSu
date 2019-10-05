package com.example.nhansu.Model_Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nhansu.R;

import java.util.List;




public class Adapter_khenthuong extends BaseAdapter {
    private List<item_khenthuong> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter_khenthuong(Context aContext, List<item_khenthuong> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
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
}
