package com.example.myphonesensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvSensor = findViewById(R.id.tvSensor);
        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList = sm.getSensorList(Sensor.TYPE_ALL);

        String sensorInfo = "센서의 개수:";
        sensorInfo = sensorInfo + sensorList.size();
        int i = 1;
        for(Sensor s : sensorList) {
            sensorInfo = sensorInfo + "\n" + i++ +"\nName: " + s.getName() +
                    "\n해상도: " + s.getResolution() + "\n최대범위" + s.getMaximumRange();
        }

        tvSensor.setText(sensorInfo);
    }
}