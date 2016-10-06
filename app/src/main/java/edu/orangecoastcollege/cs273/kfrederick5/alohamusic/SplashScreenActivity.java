package edu.orangecoastcollege.cs273.kfrederick5.alohamusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Define timer task to launch media activity
        TimerTask mediaTask = new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(SplashScreenActivity.this,
                        MediaActivity.class));
            }
        };

            Timer timer = new Timer();
            timer.schedule(mediaTask, 5000);
    }
}
