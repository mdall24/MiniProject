package com.example.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEightBall = findViewById(R.id.btnEightBall);
        Button btnFortune = findViewById(R.id.btnFortune);

        btnEightBall.setOnClickListener(v -> {
            Intent intent = new Intent(this, eight_ball.class);
            startActivity(intent);
        });

        btnFortune.setOnClickListener(v -> {
            Intent intent = new Intent(this, fortune_teller.class);
            startActivity(intent);
        });
    }
}