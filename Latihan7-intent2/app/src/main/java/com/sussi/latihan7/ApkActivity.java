package com.sussi.latihan7;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ApkActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNilai1, edtNilai2;
    private Button btnPlus, btnMinus, btnDivide, btnMultiply, btnHitung, btnClear;
    private TextView tvHasil;

    // Variabel untuk menyimpan operator yang dipilih
    private String operator = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_apk);

        // Hubungkan ID dari layout XML
        edtNilai1 = findViewById(R.id.edt_Nilai1);
        edtNilai2 = findViewById(R.id.edt_Nilai2);
        btnPlus = findViewById(R.id.btn_Plus);
        btnMinus = findViewById(R.id.btn_Minus);
        btnDivide = findViewById(R.id.btn_Divide);
        btnMultiply = findViewById(R.id.btn_Multiply);
        btnHitung = findViewById(R.id.btn_Hitung);
        btnClear = findViewById(R.id.btn_Clear);
        tvHasil = findViewById(R.id.tv_Hasil);

        // Set listener untuk semua tombol
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnHitung.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btn_Clear) {
            edtNilai1.setText("");
            edtNilai2.setText("");
            tvHasil.setText("Hasil");
            operator = ""; // reset operator
            edtNilai1.requestFocus();
            return;
        }

        if (id == R.id.btn_Plus) {
            operator = "tambah";
            tvHasil.setText("Operasi: +");
            return;
        } else if (id == R.id.btn_Minus) {
            operator = "kurang";
            tvHasil.setText("Operasi: -");
            return;
        } else if (id == R.id.btn_Multiply) {
            operator = "kali";
            tvHasil.setText("Operasi: ×");
            return;
        } else if (id == R.id.btn_Divide) {
            operator = "bagi";
            tvHasil.setText("Operasi: ÷");
            return;
        }

        if (id == R.id.btn_Hitung) {
            String nilai1Str = edtNilai1.getText().toString().trim();
            String nilai2Str = edtNilai2.getText().toString().trim();

            if (TextUtils.isEmpty(nilai1Str)) {
                edtNilai1.setError("Nilai 1 tidak boleh kosong");
                return;
            }
            if (TextUtils.isEmpty(nilai2Str)) {
                edtNilai2.setError("Nilai 2 tidak boleh kosong");
                return;
            }

            double n1 = Double.parseDouble(nilai1Str);
            double n2 = Double.parseDouble(nilai2Str);
            double hasilTerakhir = 0;

            // Cek operator yang dipilih
            if (operator.equals("tambah")) {
                hasilTerakhir = n1 + n2;
            } else if (operator.equals("kurang")) {
                hasilTerakhir = n1 - n2;
            } else if (operator.equals("kali")) {
                hasilTerakhir = n1 * n2;
            } else if (operator.equals("bagi")) {
                if (n2 == 0) {
                    edtNilai2.setError("Tidak bisa dibagi dengan nol");
                    return;
                }
                hasilTerakhir = n1 / n2;
            } else {
                // kalau belum pilih operasi
                tvHasil.setText("Pilih operasi dulu!");
                return;
            }

            tvHasil.setText("= " + hasilTerakhir);
        }
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
