package com.example.miniproject;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Random;


public class eight_ball extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor gravitySensor;

    private final String[] responses = {
            "Maybe", "Possibly", "Perchance", "Mayhaps", "Perhaps", "No", "Definitely Not", "Negatory", "Never", "Nope", "Yes", "Guaranteed", "100 %", "Sure", "Certainly"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_ball);

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        gravitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);

        if (gravitySensor == null) {
            Toast.makeText(this, "Gravity sensor not available on this device", Toast.LENGTH_LONG).show();
            finish(); 
        }

        TextView tvAnswer = findViewById(R.id.tvAnswer);
        Button btnAsk = findViewById(R.id.btnAsk);

        btnAsk.setOnClickListener(v -> {
            int index = new Random().nextInt(responses.length);
            tvAnswer.setText(responses[index]);
        });

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
        if(event.sensor.getType() == Sensor.TYPE_GRAVITY){
            float gravityX = event.values[0];
            float gravityY = event.values[1];
            float gravityZ = event.values[2];
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
