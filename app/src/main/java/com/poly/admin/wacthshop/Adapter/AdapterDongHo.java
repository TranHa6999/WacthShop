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

import com.poly.admin.wacthshop.DAO.DongHoDAO;
import com.poly.admin.wacthshop.Model.DongHo;
import com.poly.admin.wacthshop.R;

import java.util.List;


public class AdapterDongHo extends BaseAdapter {

    List<DongHo> arrDongHo;
    public Activity context;
    public LayoutInflater inflater;
    com.poly.admin.wacthshop.DAO.DongHoDAO DongHoDAO;

    public AdapterDongHo(Activity context, List<DongHo> arrDongHo) {
        super();
        this.context = context;
        this.arrDongHo = arrDongHo;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        DongHoDAO = new DongHoDAO(context);
    }

    @Override
    public int getCount() {
        return arrDongHo.size();
    }

    @Override
    public Object getItem(int i) {
        return arrDongHo.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public static class ViewHolder {
        ImageView imgLogo;
        TextView tvMaDongHo;
        TextView tvTenDongHo;
        TextView tvSoLuong;
        ImageView imgDelete;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item_dong_ho, null);
            holder.imgLogo = (ImageView) view.findViewById(R.id.imgLogo);
            holder.tvMaDongHo = (TextView) view.findViewById(R.id.tvMaDongHo);
            holder.tvTenDongHo = (TextView) view.findViewById(R.id.tvTenDongHo);
            holder.tvSoLuong = (TextView) view.findViewById(R.id.tvSoLuong);
            holder.imgDelete = (ImageView) view.findViewById(R.id.imgDelete);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DongHoDAO.deleteDongHo(arrDongHo.get(i).getMaDongHo());
                    arrDongHo.remove(i);
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    notifyDataSetChanged();
                }
            });
            view.setTag(holder);

        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        DongHo DongHo = arrDongHo.get(i);
        holder.tvMaDongHo.setText(DongHo.getMaDongHo());
        holder.tvTenDongHo.setText(DongHo.getTenDongHo());
        holder.tvSoLuong.setText(DongHo.getSoLuong() + "");
        return view;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDataset(List<DongHo> items) {
        this.arrDongHo = items;
        notifyDataSetChanged();
    }
}
