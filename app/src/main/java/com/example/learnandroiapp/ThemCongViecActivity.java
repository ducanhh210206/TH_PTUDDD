package com.example.learnandroiapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ThemCongViecActivity extends AppCompatActivity {
    EditText edtTieuDe, edtThoiGian, edtGhiChu;
    Button btnLuu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_cong_viec);

        edtTieuDe = findViewById(R.id.edtTieuDe);
        edtThoiGian = findViewById(R.id.edtThoiGian);
        edtGhiChu = findViewById(R.id.edtGhiChu);
        btnLuu = findViewById(R.id.btnLuu);

        String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(new Date());
        edtThoiGian.setText(currentDateTime);

        btnLuu.setOnClickListener(v -> {
            String tieuDe = edtTieuDe.getText().toString().trim();
            String thoiGian = edtThoiGian.getText().toString().trim();
            String ghiChu = edtGhiChu.getText().toString().trim();

            if (tieuDe.isEmpty() || thoiGian.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập tiêu đề và thời gian hoàn thành", Toast.LENGTH_SHORT).show();
                return;
            }

            CongViec congViec = new CongViec(tieuDe, thoiGian, ghiChu, false);
            TaskRepository.addTask(congViec);

            Toast.makeText(this, "Thêm công việc thành công", Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK);
            finish();
        });
    }
}
