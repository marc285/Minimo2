package com.marc285.minimo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    private EditText usr;
    private EditText pwd;
    private Button login;

    Context context;

    //"DataBase" of existing users
    private HashMap<String,String> registeredusers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usr = findViewById(R.id.userEditText);
        pwd = findViewById(R.id.passwordEditText);
        login = findViewById(R.id.loginButton);

        registeredusers = new HashMap<>();

        //We simulate a database of Users: "user" is the only one allowed to enter the application
        registeredusers.put("dsamola", "user");

        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                //"Validation"
                Boolean validated;

                if(usr.getText().toString().equals(registeredusers.get(pwd.getText().toString()))) {
                    validated = true;
                    Intent intent = new Intent(context, SplashActivity.class);
                    intent.putExtra("validated", validated);
                    setResult(RESULT_OK, intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Usuario o Contraseña incorrecto/s", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
