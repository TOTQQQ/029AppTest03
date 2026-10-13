package com.example.a029apptest03;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Experiment3Activity extends AppCompatActivity {

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_experiment3);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvTest = findViewById(R.id.tv_test);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_experiment3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        } else if (id == R.id.menu_font_small) {
            tvTest.setTextSize(10f);
            return true;
        } else if (id == R.id.menu_font_medium) {
            tvTest.setTextSize(16f);
            return true;
        } else if (id == R.id.menu_font_large) {
            tvTest.setTextSize(20f);
            return true;
        } else if (id == R.id.menu_normal) {
            Toast.makeText(this, "您点击了普通菜单项", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_color_red) {
            tvTest.setTextColor(0xFFFF0000);
            return true;
        } else if (id == R.id.menu_color_black) {
            tvTest.setTextColor(0xFF000000);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
