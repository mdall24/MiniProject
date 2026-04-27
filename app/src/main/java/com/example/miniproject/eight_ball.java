package com.example.miniproject;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Random;
private SensorManager mSensorManager;
private Sensor mSensor;



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
        mSensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        if(mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)!=null){
            List<Sensor> gravSensor = mSensorManager.getSensorList(Sensor.TYPE_GRAVITY);
            for(int i = 0; i < gravSensor.size(); i++){
                if((gravSensor.get(i).getVendor().contains("Google")) && (gravSensor.get(i).getVersion() == 3)){
                    mSensor = gravSensor.get(i);
                    break;
                }
            }
        }
        else if(mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)!=null){
                mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            }
        }
    }