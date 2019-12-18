package com.marc285.minimo2;

//import com.marc285.minimo2.models.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //

    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    private API APIinterface;

    //Retrofit Methods (matching API interface)
    //recyclerview.setAdapter(new RVAdapter(param));
    //showProgress(false);

    public void showProgress (boolean visible){
        //Sets the visibility/invisibility of loadinglistProgressBar
        if(visible)
            this.progressBar.setVisibility(View.VISIBLE);
        else
            this.progressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewById
        progressBar = findViewById(R.id.loadinglistProgressBar);
        recyclerView = findViewById(R.id.listRecyclerView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://y.y.y/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIinterface = retrofit.create(API.class);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
