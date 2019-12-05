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

public class SuaLoaiDongHo extends AppCompatActivity {
    private EditText edtMaLoaiDongHo;
    private EditText edtTenLoaiDongHo;
    private EditText edtMoTa;
    private FloatingActionButton btnUpdate;
    LoaiDongHoDAO loaiDongHoDAO;
    String maLoaiDongHo, tenLoaiDongHo, moTa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sua_loai_dong_ho);
        setTitle("Sửa Loại Thú Cưng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        maLoaiDongHo = bundle.getString("MALOAIDongHo");
        tenLoaiDongHo = bundle.getString("TENLOAIDongHo");
        moTa = bundle.getString("MOTA");
        edtMaLoaiDongHo.setText(maLoaiDongHo);
        edtTenLoaiDongHo.setText(tenLoaiDongHo);
        edtMoTa.setText(moTa);
    }

    private void initView() {
        edtMaLoaiDongHo = (EditText) findViewById(R.id.edtMaLoaiDongHo);
        edtTenLoaiDongHo = (EditText) findViewById(R.id.edtTenLoaiDongHo);
        edtMoTa = (EditText) findViewById(R.id.edtMoTa);
        btnUpdate = (FloatingActionButton) findViewById(R.id.btnUpdate);
        loaiDongHoDAO = new LoaiDongHoDAO(this);
    }

    public void updateDongHo(View view) {
        loaiDongHoDAO = new LoaiDongHoDAO(SuaLoaiDongHo.this);
        LoaiDongHo loaiDongHo = new LoaiDongHo(
                edtMaLoaiDongHo.getText().toString(),
                edtTenLoaiDongHo.getText().toString(),
                edtMoTa.getText().toString()
        );
        if (loaiDongHoDAO.updateLoaiDongHo(loaiDongHo) == 1) {
            Toast.makeText(getApplicationContext(), "Cap nhat thanh cong", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), ActivityLoaiDongHo.class));
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Cap nhat That Bai", Toast.LENGTH_LONG).show();
        }
    }
}
