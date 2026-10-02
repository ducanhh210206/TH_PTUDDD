package com.example.learnandroiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DanhSachActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_THEM = 1;
    LinearLayout danhSachHomNay, danhSachSapToi;
    Button btnThem, btnDangXuat;
    TextView tvTaiKhoan;
    String username = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach);

        tvTaiKhoan = findViewById(R.id.tvTaiKhoan);
        btnThem = findViewById(R.id.btnThem);
        btnDangXuat = findViewById(R.id.btnDangXuat);
        danhSachHomNay = findViewById(R.id.danhSachHomNay);
        danhSachSapToi = findViewById(R.id.danhSachSapToi);

        if (getIntent() != null && getIntent().hasExtra("username")) {
            username = getIntent().getStringExtra("username");
        }
        tvTaiKhoan.setText(username);

        btnThem.setOnClickListener(v -> {
            Intent intent = new Intent(DanhSachActivity.this, ThemCongViecActivity.class);
            startActivityForResult(intent, REQUEST_CODE_THEM);
        });

        btnDangXuat.setOnClickListener(v -> {
            finish();
        });

        hienThiDanhSach();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_THEM && resultCode == RESULT_OK) {
            hienThiDanhSach();
        }
    }

    private void hienThiDanhSach() {
        danhSachHomNay.removeAllViews();
        danhSachSapToi.removeAllViews();

        String currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        List<CongViec> tasks = TaskRepository.getTaskList();
        for (CongViec cv : tasks) {
            View itemView = getLayoutInflater().inflate(R.layout.item_cong_viec, null);
            CheckBox chkHoanThanh = itemView.findViewById(R.id.chkHoanThanh);
            TextView tvTieuDe = itemView.findViewById(R.id.tvTieuDe);
            TextView tvThoiGian = itemView.findViewById(R.id.tvThoiGian);
            TextView tvGhiChu = itemView.findViewById(R.id.tvGhiChu);

            tvTieuDe.setText(cv.getTieuDe());
            tvThoiGian.setText("Thời gian: " + cv.getThoiGian());
            if (cv.getGhiChu() != null && !cv.getGhiChu().isEmpty()) {
                tvGhiChu.setText("Ghi chú: " + cv.getGhiChu());
                tvGhiChu.setVisibility(View.VISIBLE);
            } else {
                tvGhiChu.setVisibility(View.GONE);
            }

            chkHoanThanh.setChecked(cv.isHoanThanh());
            chkHoanThanh.setOnCheckedChangeListener((buttonView, isChecked) -> {
                cv.setHoanThanh(isChecked);
            });

            // Classify: Today vs Upcoming based on date prefix (YYYY-MM-DD)
            String taskDate = cv.getThoiGian();
            if (taskDate.length() >= 10) {
                taskDate = taskDate.substring(0, 10);
            }
            if (taskDate.equals(currentDate)) {
                danhSachHomNay.addView(itemView);
            } else {
                danhSachSapToi.addView(itemView);
            }
        }
    }
}
