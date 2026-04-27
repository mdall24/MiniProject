package com.example.miniproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class fortune_teller extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fortune_teller);

        //TextView tvAnswer = findViewById(R.id.tvAnswer);
       // Button btnAsk = findViewById(R.id.btnAsk);

        //btnAsk.setOnClickListener(v-> {
        //    int index = new Random().nextInt(responses.length);
        //    tvAnswer.setText(responses[index]);
        //});
    }
}
