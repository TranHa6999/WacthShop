package com.poly.admin.wacthshop.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import com.poly.admin.wacthshop.Adapter.AdapterDongHo;
import com.poly.admin.wacthshop.DAO.DongHoDAO;
import com.poly.admin.wacthshop.Model.DongHo;
import com.poly.admin.wacthshop.R;
import com.poly.admin.wacthshop.ThemDongHo;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityDongHo extends AppCompatActivity {
    public static List<DongHo> dsDongHo = new ArrayList<>();
    ListView lvDongHo;
    AdapterDongHo adapter = null;
    com.poly.admin.wacthshop.DAO.DongHoDAO DongHoDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dong_ho);
        setTitle("Thú Cưng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvDongHo = findViewById(R.id.lvDongHo);
        registerForContextMenu(lvDongHo);
        DongHoDAO = new DongHoDAO(ActivityDongHo.this);
        dsDongHo = DongHoDAO.getAllDongHo();
        adapter = new AdapterDongHo(this, dsDongHo);
        lvDongHo.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_dong_ho, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Intent intent = new Intent(this, ThemDongHo.class);
                startActivity(intent);
                break;
            case R.id.search:
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
