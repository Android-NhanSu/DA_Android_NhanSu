package com.example.nhansu.Model_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nhansu.R;

import java.util.List;

public class Adapter_nv extends BaseAdapter {
    private List<item_nv> listData;
    private LayoutInflater layoutInflater;
    private Context context;

      public Adapter_nv(Context context, List<item_nv> listData) {
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
        Adapter_nv.ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.row_nv, null);
            holder = new Adapter_nv.ViewHolder();
            holder.manv= (TextView) view.findViewById(R.id.edit_ma);
            holder.hoten= (EditText) view.findViewById(R.id.edit_ten);
            holder.gioitinh= (TextView) view.findViewById(R.id.edit_gioitinh);
            holder.sdt= (EditText) view.findViewById(R.id.edit_sdt);
            holder.email= (EditText) view.findViewById(R.id.edit_email);
            holder.dc= (TextView) view.findViewById(R.id.edit_dc);
            holder.cv= (EditText) view.findViewById(R.id.edit_cv);
            holder.phong= (EditText) view.findViewById(R.id.edit_phong);
            holder.nn=(EditText) view.findViewById(R.id.edit_nn);
            holder.trinhdo=(EditText) view.findViewById(R.id.edit_td);
            holder.nvlam=(EditText) view.findViewById(R.id.edit_nvl);
            holder.ns=(TextView) view.findViewById(R.id.edit_ns);
            holder.quequan=(TextView) view.findViewById(R.id.edit_quequan);

            view.setTag(holder);
        } else {
            holder = (Adapter_nv.ViewHolder) view.getTag();
        }

        item_nv country = this.listData.get(i);
        holder.manv.setText(country.getManv());
        holder.hoten.setText(country.getHoten());
        holder.gioitinh.setText(country.getGioitinh());
        holder.sdt.setText(country.getSdt());
        holder.email.setText(country.getEmail());
        holder.dc.setText(country.getDc());
        holder.cv.setText(country.getCv());
        holder.phong.setText(country.getPhong());
        holder.nn.setText(country.getNn());
        holder.trinhdo.setText(country.getTrinhdo());
        holder.nvlam.setText(country.getNvlam());
        return view;
    }
    static class ViewHolder {
        TextView manv;
        EditText hoten;
        TextView gioitinh;
        EditText sdt;
        EditText email;
        TextView dc;
        EditText cv;
        EditText phong;
        EditText nn;
        EditText trinhdo;
        EditText nvlam;
        TextView ns;
        TextView quequan;
    }
}
