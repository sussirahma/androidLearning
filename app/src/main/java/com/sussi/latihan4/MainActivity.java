package com.sussi.latihan4;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNilai1, edtNilai2;
    private Button btnTambah, btnKurang, btnKali, btnBagi, btnHitung;
    private TextView tvHasil;
    private double hasilTerakhir = 0;
    private String operasi = ""; // simpan operasi yang dipilih

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtNilai1 = findViewById(R.id.edt_nilai1);
        edtNilai2 = findViewById(R.id.edt_nilai2);
        btnTambah = findViewById(R.id.btn_tambah);
        btnKurang = findViewById(R.id.btn_kurang);
        btnKali = findViewById(R.id.btn_kali);
        btnBagi = findViewById(R.id.btn_bagi);
        btnHitung = findViewById(R.id.btn_hitung);
        tvHasil = findViewById(R.id.tv_hasil);

        btnTambah.setOnClickListener(this);
        btnKurang.setOnClickListener(this);
        btnKali.setOnClickListener(this);
        btnBagi.setOnClickListener(this);
        btnHitung.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        int id = v.getId();

        // Jika tombol operasi diklik, simpan operasi yang dipilih
        if (id == R.id.btn_tambah) {
            operasi = "tambah";
            tvHasil.setText("Operasi: +");
            return;
        } else if (id == R.id.btn_kurang) {
            operasi = "kurang";
            tvHasil.setText("Operasi: -");
            return;
        } else if (id == R.id.btn_kali) {
            operasi = "kali";
            tvHasil.setText("Operasi: ×");
            return;
        } else if (id == R.id.btn_bagi) {
            operasi = "bagi";
            tvHasil.setText("Operasi: ÷");
            return;
        }

        // Kalau yang diklik adalah tombol HITUNG:
        if (id == R.id.btn_hitung) {
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

            if (operasi.equals("tambah")) {
                hasilTerakhir = n1 + n2;
            } else if (operasi.equals("kurang")) {
                hasilTerakhir = n1 - n2;
            } else if (operasi.equals("kali")) {
                hasilTerakhir = n1 * n2;
            } else if (operasi.equals("bagi")) {
                if (n2 == 0) {
                    edtNilai2.setError("Tidak bisa dibagi dengan nol");
                    return;
                }
                hasilTerakhir = n1 / n2;
            } else {
                // Kalau belum pilih operasi
                tvHasil.setText("Pilih operasi dulu!");
                return;
            }

            tvHasil.setText("= " + hasilTerakhir);
        }
    }
}
