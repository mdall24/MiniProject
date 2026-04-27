package com.example.miniproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;



public class eight_ball extends AppCompatActivity {


    private final String[] responses = {
            "Maybe", "Possibly", "Perchance", "Mayhaps", "Perhaps", "No", "Definitely Not", "Negatory", "Never", "Nope","Yes", "Guaranteed", "100 %", "Sure", "Certainly"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eight_ball);

        TextView tvAnswer = findViewById(R.id.tvAnswer);
        Button btnAsk = findViewById(R.id.btnAsk);

        btnAsk.setOnClickListener(v-> {
            int index = new Random().nextInt(responses.length);
            tvAnswer.setText(responses[index]);
        });
    }
}
