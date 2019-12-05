package com.poly.admin.wacthshop.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.poly.admin.wacthshop.Database.DBHelper;
import com.poly.admin.wacthshop.Model.LoaiDongHo;

import java.util.ArrayList;
import java.util.List;

public class LoaiDongHoDAO {
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public static final String TABLE_NAME = "LoaiDongHo";
    public static final String SQL_LOAI_THU_CUNG = "CREATE TABLE LoaiDongHo (maLoaiDongHo text primary key, tenLoaiDongHo text, moTa text);";
    public static final String TAG = "LoaiDongHoDAO";

    public LoaiDongHoDAO(Context context) {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    //insert
    public int inserLoaiDongHo(LoaiDongHo loaiDongHo) {
        ContentValues values = new ContentValues();
        values.put("maLoaiDongHo", loaiDongHo.getMaLoaiDongHo());
        values.put("tenLoaiDongHo", loaiDongHo.getTenLoaiDongHo());
        values.put("moTa", loaiDongHo.getMoTa());
        try {
            if (db.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
        }
        return 1;
    }

    //update
    public int updateLoaiDongHo(LoaiDongHo loaiDongHo) {
        ContentValues values = new ContentValues();
        values.put("maLoaiDongHo", loaiDongHo.getMaLoaiDongHo());
        values.put("tenLoaiDongHo", loaiDongHo.getTenLoaiDongHo());
        values.put("moTa", loaiDongHo.getMoTa());
        int result = db.update(TABLE_NAME, values, "maLoaiDongHo=?", new String[]{loaiDongHo.getMaLoaiDongHo()});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int updateInfoLoaDongHo(String maLoaiDongHo, String s, String s1, String s2, String s3) {
        ContentValues values = new ContentValues();
        values.put("maLoaiDongHo", s);
        values.put("tenLoaiDongHo", s1);
        values.put("moTa", s2);
        int result = db.update(TABLE_NAME, values, "maLoaiDongHo=?", new
                String[]{maLoaiDongHo});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    //delete
    public int deleteLoaiDongHo(String maLoaiDongHo) {
        int result = db.delete(TABLE_NAME, "maLoaiDongHo=?", new String[]{maLoaiDongHo});
        if (result == 0)
            return -1;
        return 1;
    }

    //getAllTheLoai
    public List<LoaiDongHo> getAllLoaiDongHo() {
        List<LoaiDongHo> dsLoaiDongHo = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            LoaiDongHo loaiDongHo = new LoaiDongHo();
            loaiDongHo.setMaLoaiDongHo(c.getString(0));
            loaiDongHo.setTenLoaiDongHo(c.getString(1));
            loaiDongHo.setMoTa(c.getString(2));
            dsLoaiDongHo.add(loaiDongHo);
            Log.d("//=====", loaiDongHo.toString());
            c.moveToNext();
        }
        c.close();
        return dsLoaiDongHo;
    }

}
