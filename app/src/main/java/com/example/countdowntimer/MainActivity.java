package com.example.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final long startTime = 61000;
    private final long interval = 1000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView Time = findViewById(R.id.times);
        TextView timeElapsed = findViewById(R.id.timeElapsed);
        Button reset = findViewById(R.id.resetTimer);
        final  CountDownTimer countDownTimer = new CountDownTimer(startTime,interval) {
            @Override
            public void onTick(long l) {
                Time.setText("Time: "+l/1000);
                timeElapsed.setText("Time Elapsed: "+(startTime-l)/1000);
            }

            @Override
            public void onFinish() {
                Time.setText("Time Up!");
            }
        }.start();


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                countDownTimer.start();
            }
        });
        
    }
}