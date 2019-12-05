package com.poly.admin.wacthshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.poly.admin.wacthshop.Activity.ActivityDongHo;
import com.poly.admin.wacthshop.Activity.ActivityLoaiDongHo;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("WacthShop");
    }

    public void ShowDongHo(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityDongHo.class);
        startActivity(intent);
    }

    public void ShowLoaiDongHo(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityLoaiDongHo.class);
        startActivity(intent);
    }

    public void ShowHoaDon(View view) {
    }

    public void ShowBanChay(View view) {
    }

    public void ShowThongKe(View view) {
    }
}
