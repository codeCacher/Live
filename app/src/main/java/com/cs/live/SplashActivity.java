package com.cs.live;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

        //waite this activity to show a few seconds,start the MainActivity and finish it
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                MainActivity.openMainActivity(getApplicationContext(), Intent.FLAG_ACTIVITY_NEW_TASK);
            }
        };
        timer.schedule(task,2000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
