package com.example.learnandroiapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edtTaiKhoan, edtMatKhau;
    Button btnDangNhap;
    TextView tvDangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTaiKhoan = findViewById(R.id.edtTaiKhoan);
        edtMatKhau = findViewById(R.id.edtMatKhau);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        tvDangKy = findViewById(R.id.tvDangKy);

        edtTaiKhoan.requestFocus();

        btnDangNhap.setOnClickListener(v -> {
            String TaiKhoan = edtTaiKhoan.getText().toString().trim();
            if (TaiKhoan.isEmpty()) {
                TaiKhoan = "admin";
            }
            Intent intent = new Intent(MainActivity.this, DanhSachActivity.class);
            intent.putExtra("username", TaiKhoan);
            startActivity(intent);
        });

        tvDangKy.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DangKyActivity.class);
            startActivity(intent);
        });
    }
}
