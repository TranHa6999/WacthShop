package com.poly.admin.wacthshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.poly.admin.wacthshop.Activity.ActivityLoaiDongHo;
import com.poly.admin.wacthshop.DAO.LoaiDongHoDAO;
import com.poly.admin.wacthshop.Model.LoaiDongHo;

import androidx.appcompat.app.AppCompatActivity;

public class ThemLoaiDongHo extends AppCompatActivity {
    private EditText edtMaLoaiDongHo;
    private EditText edtTenLoaiDongHo;
    private EditText edtMoTa;
    private FloatingActionButton btnAdd;
    LoaiDongHoDAO loaiDongHoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_loai_dong_ho);
        setTitle("Thêm Loại Thú Cưng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
    }

    private void initView() {
        edtMaLoaiDongHo = (EditText) findViewById(R.id.edtMaLoaiDongHo);
        edtTenLoaiDongHo = (EditText) findViewById(R.id.edtTenLoaiDongHo);
        edtMoTa = (EditText) findViewById(R.id.edtMoTa);
        btnAdd = (FloatingActionButton) findViewById(R.id.btnAdd);
    }

    public void themLoaiDongHo(View view) {
        loaiDongHoDAO = new LoaiDongHoDAO(ThemLoaiDongHo.this);
        LoaiDongHo loaiDongHo = new LoaiDongHo(
                edtMaLoaiDongHo.getText().toString(),
                edtTenLoaiDongHo.getText().toString(),
                edtMoTa.getText().toString());
        if (loaiDongHoDAO.inserLoaiDongHo(loaiDongHo) > 0) {
            Toast.makeText(getApplicationContext(), "Thêm thành công",
                    Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), ActivityLoaiDongHo.class));
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Thêm thất bại",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
