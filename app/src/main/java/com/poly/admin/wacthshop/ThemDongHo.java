package com.poly.admin.wacthshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.poly.admin.wacthshop.Activity.ActivityDongHo;
import com.poly.admin.wacthshop.DAO.DongHoDAO;
import com.poly.admin.wacthshop.DAO.LoaiDongHoDAO;
import com.poly.admin.wacthshop.Model.DongHo;
import com.poly.admin.wacthshop.Model.LoaiDongHo;


import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class ThemDongHo extends AppCompatActivity {
    private Spinner spnMaLoaiDongHo;
    private EditText edtMaDongHo;
    private EditText edtTenDongHo;
    private EditText edtGia;
    private EditText edtSoLuong;
    private FloatingActionButton btnAdd;
    com.poly.admin.wacthshop.DAO.DongHoDAO DongHoDAO;
    LoaiDongHoDAO loaiDongHoDAO;
    String maLoaiDongHo = "";
    List<LoaiDongHo> listLoaiDongHo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_dong_ho);
        setTitle("Thêm Thú Cưng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
        getLoaiDongHo();
    }

    private void getLoaiDongHo() {
        loaiDongHoDAO = new LoaiDongHoDAO(ThemDongHo.this);
        listLoaiDongHo = loaiDongHoDAO.getAllLoaiDongHo();
        ArrayAdapter<LoaiDongHo> arrayAdapter = new ArrayAdapter<LoaiDongHo>(this, R.layout.support_simple_spinner_dropdown_item, listLoaiDongHo);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spnMaLoaiDongHo.setAdapter(arrayAdapter);
    }

    private void initView() {
        spnMaLoaiDongHo = (Spinner) findViewById(R.id.spnMaLoaiDongHo);
        edtMaDongHo = (EditText) findViewById(R.id.edtMaDongHo);
        edtTenDongHo = (EditText) findViewById(R.id.edtTenDongHo);
        edtGia = (EditText) findViewById(R.id.edtGia);
        edtSoLuong = (EditText) findViewById(R.id.edtSoLuong);
        btnAdd = (FloatingActionButton) findViewById(R.id.btnAdd);

        spnMaLoaiDongHo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                maLoaiDongHo = listLoaiDongHo.get(spnMaLoaiDongHo.getSelectedItemPosition()).getMaLoaiDongHo();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void themDongHo(View view) {
        DongHoDAO = new DongHoDAO(ThemDongHo.this);
        DongHo DongHo = new DongHo(
                maLoaiDongHo,
                edtMaDongHo.getText().toString(),
                edtTenDongHo.getText().toString(),
                Double.parseDouble(edtGia.getText().toString()),
                Integer.parseInt(edtSoLuong.getText().toString())
        );
        if (DongHoDAO.inserDongHo(DongHo) > 0) {
            Toast.makeText(getApplicationContext(), "Thêm thành công",
                    Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), ActivityDongHo.class));
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Thêm thất bại",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public int checkPositionTheLoai(String strTheLoai) {
        for (int i = 0; i < listLoaiDongHo.size(); i++) {
            if (strTheLoai.equals(listLoaiDongHo.get(i).getMaLoaiDongHo())) {
                return i;
            }
        }
        return 0;
    }


}
