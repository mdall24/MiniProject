package com.example.miniproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class eight_ball extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor gravitySensor;
    private TextView tvAnswer;

    private TextView cancel;

    private final String[] responses = {
            "Maybe", "Possibly", "Perchance", "Mayhaps", "Perhaps",
            "No", "Definitely Not", "Negatory", "Never", "Nope",
            "Yes", "Guaranteed", "100 %", "Sure", "Certainly"
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_ball);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        gravitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);

        if (gravitySensor == null) {
            Toast.makeText(this, "Gravity sensor not available on this device", Toast.LENGTH_LONG).show();
            finish();
        }
        tvAnswer = findViewById(R.id.tvAnswer);
        Button btnAsk = findViewById(R.id.btnAsk);
        btnAsk.setOnClickListener(v -> showRandomResponse());

        cancel = findViewById(R.id.backBall);
        cancel.setOnClickListener(view -> {
            Intent intent = new Intent(eight_ball.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void showRandomResponse() {
        int index = new Random().nextInt(responses.length);
        tvAnswer.setText(responses[index]);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, gravitySensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_GRAVITY) {
            float gravityZ = event.values[2];
            if (gravityZ < 5.0f) { // phone is tilted significantly
                showRandomResponse();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}