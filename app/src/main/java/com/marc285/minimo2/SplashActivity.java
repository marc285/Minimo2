package com.marc285.minimo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    //Autentication control (if the user has already authenticated in the app)
    public static final String MY_CREDENTIALS = "CredentialsFile";
    public Boolean validated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final SharedPreferences prefs = getSharedPreferences(MY_CREDENTIALS, MODE_PRIVATE);

        final Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {

                String name = prefs.getString("usr1", "x");
                if(name.equals("x")){
                    //Open the Login activity
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    intent.putExtra("validated", validated);
                    startActivityForResult(intent, 1);
                    onActivityResult(1, RESULT_OK, intent);
                    if(validated){
                        SharedPreferences.Editor SPeditor = prefs.edit();
                        SPeditor.putString("usr1", "user");
                        SPeditor.putString("usr1pwd", "dsamola");
                        SPeditor.apply();
                    }
                }
                else{
                    //Open the Main Activity
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }
            }
        }, 4000); //

    }
}
