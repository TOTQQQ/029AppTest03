package com.example.a029apptest03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        Button btnExp1 = findViewById(R.id.btn_exp1);
        Button btnExp2 = findViewById(R.id.btn_exp2);
        Button btnExp3 = findViewById(R.id.btn_exp3);
        Button btnExp4 = findViewById(R.id.btn_exp4);
        Button btnExp5 = findViewById(R.id.btn_exp5);

        btnExp1.setOnClickListener(v -> startActivity(new Intent(this, Experiment1Activity.class)));
        btnExp2.setOnClickListener(v -> startActivity(new Intent(this, Experiment2Activity.class)));
        btnExp3.setOnClickListener(v -> startActivity(new Intent(this, Experiment3Activity.class)));
        btnExp4.setOnClickListener(v -> startActivity(new Intent(this, Experiment4Activity.class)));
        btnExp5.setOnClickListener(v -> startActivity(new Intent(this, Experiment5Activity.class)));
    }
}
