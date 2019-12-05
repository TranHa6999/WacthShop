package com.poly.admin.wacthshop.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.poly.admin.wacthshop.Adapter.AdapterLoaiDongHo;
import com.poly.admin.wacthshop.DAO.LoaiDongHoDAO;
import com.poly.admin.wacthshop.Model.LoaiDongHo;
import com.poly.admin.wacthshop.R;
import com.poly.admin.wacthshop.SuaLoaiDongHo;
import com.poly.admin.wacthshop.ThemLoaiDongHo;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityLoaiDongHo extends AppCompatActivity {
    public static List<LoaiDongHo> dsLoaiDongHo = new ArrayList<>();
    ListView lvLoaiDongHo;
    AdapterLoaiDongHo adapter = null;
    LoaiDongHoDAO loaiDongHoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loai_dong_ho);
        setTitle("Loại Thú Cưng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvLoaiDongHo = findViewById(R.id.lvLoaiDongHo);
        registerForContextMenu(lvLoaiDongHo);
        loaiDongHoDAO = new LoaiDongHoDAO(ActivityLoaiDongHo.this);
        dsLoaiDongHo = loaiDongHoDAO.getAllLoaiDongHo();
        adapter = new AdapterLoaiDongHo(this, dsLoaiDongHo);
        lvLoaiDongHo.setAdapter(adapter);
        lvLoaiDongHo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ActivityLoaiDongHo.this, SuaLoaiDongHo.class);
                Bundle bundle = new Bundle();
                bundle.putString("MALOAIDongHo", dsLoaiDongHo.get(i).getMaLoaiDongHo());
                bundle.putString("TENLOAIDongHo", dsLoaiDongHo.get(i).getTenLoaiDongHo());
                bundle.putString("MOTA", dsLoaiDongHo.get(i).getMoTa());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_loai_dong_ho, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Intent intent = new Intent(this, ThemLoaiDongHo.class);
                startActivity(intent);
                break;
            case R.id.search:
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
