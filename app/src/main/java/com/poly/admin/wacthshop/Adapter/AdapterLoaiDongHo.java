package com.poly.admin.wacthshop.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.poly.admin.wacthshop.DAO.LoaiDongHoDAO;
import com.poly.admin.wacthshop.Model.LoaiDongHo;
import com.poly.admin.wacthshop.R;

import java.util.List;

public class AdapterLoaiDongHo extends BaseAdapter {

    List<LoaiDongHo> arrLoaiDongHo;
    public Activity context;
    public LayoutInflater inflater;
    LoaiDongHoDAO loaiDongHoDAO;

    public AdapterLoaiDongHo(Activity context, List<LoaiDongHo> arrLoaiDongHo) {
        this.arrLoaiDongHo = arrLoaiDongHo;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        loaiDongHoDAO = new LoaiDongHoDAO(context);
    }


    @Override
    public int getCount() {
        return arrLoaiDongHo.size();
    }

    @Override
    public Object getItem(int i) {
        return arrLoaiDongHo.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public static class ViewHolder {
        ImageView imgLogo;
        TextView tvMaLoaDongHo;
        TextView tvTenLoaiDongHo;
        ImageView imgDelete;

    }

    @Override
    public View getView(final int i, View view, final ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item_loai_dong_ho, null);
            holder.imgLogo = (ImageView) view.findViewById(R.id.imgLogo);
            holder.tvMaLoaDongHo = (TextView) view.findViewById(R.id.tvMaLoaDongHo);
            holder.tvTenLoaiDongHo = (TextView) view.findViewById(R.id.tvTenLoaiDongHo);
            holder.imgDelete = (ImageView) view.findViewById(R.id.imgDelete);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loaiDongHoDAO.deleteLoaiDongHo(arrLoaiDongHo.get(i).getMaLoaiDongHo());
                    arrLoaiDongHo.remove(i);
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    notifyDataSetChanged();
                }
            });
            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }
        LoaiDongHo loaiDongHo = (LoaiDongHo) arrLoaiDongHo.get(i);
        holder.tvMaLoaDongHo.setText(loaiDongHo.getMaLoaiDongHo());
        holder.tvTenLoaiDongHo.setText(loaiDongHo.getTenLoaiDongHo());
        return view;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDataset(List<LoaiDongHo> items) {
        this.arrLoaiDongHo = items;
        notifyDataSetChanged();
    }
}
