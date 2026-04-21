package com.example.miniproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
public class eight_ball extends AppCompatActivity {


    private final String[] responses = {
            "Yes",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eight_ball);
    }

    TextView tvAnswer = findViewById(R.id.tvAnswer);
    Button btnAsk = findViewById(R.id.btnAsk);
}
