package com.marc285.minimo2;

//import com.marc285.minimo2.models.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //findViewById

        final Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Open the Main activity
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        }, 4000);

    }
}
