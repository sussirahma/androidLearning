package com.sussi.latihan7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity = findViewById(R.id.btn_masuk);
        btnMoveActivity.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_masuk) {
            Intent moveIntent = new Intent(MainActivity.this, ApkActivity.class);
            startActivity(moveIntent);
        }
    }
}