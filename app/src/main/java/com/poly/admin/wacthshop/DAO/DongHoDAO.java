package com.poly.admin.wacthshop.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.poly.admin.wacthshop.Database.DBHelper;
import com.poly.admin.wacthshop.Model.DongHo;

import java.util.ArrayList;
import java.util.List;

public class DongHoDAO {
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public static final String TABLE_NAME = "DongHo";
    public static final String SQL_THU_CUNG = "CREATE TABLE DongHo (maDongHo text primary key, maLoaiDongHo text, tenDongHo text, gia double, soLuong number);";
    public static final String TAG = "DongHoDAO";

    public DongHoDAO(Context context) {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int inserDongHo(DongHo DongHo) {
        ContentValues values = new ContentValues();
        values.put("maDongHo", DongHo.getMaDongHo());
        values.put("maLoaiDongHo", DongHo.getMaLoaiDongHo());
        values.put("tenDongHo", DongHo.getTenDongHo());
        values.put("gia", DongHo.getGia());
        values.put("soLuong", DongHo.getSoLuong());
        if (checkPrimaryKey(DongHo.getMaDongHo())) {
            int result = db.update(TABLE_NAME, values, "maDongHo=?", new
                    String[]{DongHo.getMaDongHo()});
            if (result == 0) {
                return -1;
            }
        } else {
            try {
                if (db.insert(TABLE_NAME, null, values) == -1) {
                    return -1;
                }
            } catch (Exception ex) {
                Log.e(TAG, ex.toString());
            }
        }
        return 1;
    }

    //getAll
    public List<DongHo> getAllDongHo() {
        List<DongHo> dsDongHo = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            DongHo DongHo = new DongHo();
            DongHo.setMaDongHo(c.getString(0));
            DongHo.setMaLoaiDongHo(c.getString(1));
            DongHo.setTenDongHo(c.getString(2));
            DongHo.setGia(c.getDouble(3));
            DongHo.setSoLuong(c.getInt(4));
            dsDongHo.add(DongHo);
            Log.d("//=====", DongHo.toString());
            c.moveToNext();
        }
        c.close();
        return dsDongHo;
    }

    //update
    public int updateSach(String maDongHo, String a, String b, double c, int d) {
        ContentValues values = new ContentValues();
        values.put("maDongHo", a);
        values.put("tenDongHo", b);
        values.put("gia", c);
        values.put("soLuong", d);
        int result = db.update(TABLE_NAME, values, "maDongHo=?", new
                String[]{maDongHo});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    //delete
    public int deleteDongHo(String maDongHo){
        int result = db.delete(TABLE_NAME,"maDongHo=?",new String[]{maDongHo});
        if (result == 0)
            return -1;
        return 1;
    }

    private boolean checkPrimaryKey(String strPrimaryKey) {
        //SELECT
        String[] columns = {"masach"};
        //WHERE clause
        String selection = "masach=?";
        //WHERE clause arguments
        String[] selectionArgs = {strPrimaryKey};
        Cursor c = null;
        try {
            c = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null,
                    null);
            c.moveToFirst();
            int i = c.getCount();
            c.close();
            if (i <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
