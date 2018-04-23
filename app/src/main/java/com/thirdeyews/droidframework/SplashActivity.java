package com.thirdeyews.droidframework;

//initial loading activity

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by kapil on 27/12/16.
 */
public class SplashActivity extends Activity {
    private int splashTime = 2000;
    private ProgressBar mSpinner;
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        new Timer().schedule(new TimerTask(){
            public void run() {
                try {
                    // Checking for first time launch - before calling setContentView()
                    prefManager = new PrefManager(SplashActivity.this);
                    if (!prefManager.isFirstTimeLaunch()) {
                        launchHomeScreen();
                        finish();
                    }
                    else
                        startActivity(new Intent(SplashActivity.this,StartActivity.class));
                        finish();
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        }, splashTime );
    }

    private void launchHomeScreen() {
        /** change initial activity here **/
        /** yo need to change initial activity on startActivity also **/
        startActivity(new Intent(this, FrameworkActivity.class));
        finish();
    }
}
