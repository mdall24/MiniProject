package com.example.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class fortune_teller extends AppCompatActivity {
    private static final int SPEECH_REQUEST_CODE = 100;
    private final String[] fortunes = {
            "Something good is coming your way!",
            "A new opportunity will present itself to you soon.",
            "Your intuition is strong, trust it and it will guide you to something wonderful.",
            "Someone thinks of your more than you know.",
            "Your worries will resolve, when you share what is on your mind.",
            "Kindness will get you to your destination.",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.fortune_teller);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button talk = findViewById(R.id.talk);
        talk.setOnClickListener(v -> startSpeech());
    }
    private void startSpeech(){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US");
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "I'm listening...");

        try {
            startActivityForResult(intent, SPEECH_REQUEST_CODE);
        }
        catch (Exception e){
            Toast.makeText(this, "Speech not supported on this device", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String userQuestion = result.get(0);

            Random random = new Random();
            String fortune = fortunes[random.nextInt(fortunes.length)];

            Toast.makeText(this, fortune, Toast.LENGTH_LONG).show();
        }
    }
}