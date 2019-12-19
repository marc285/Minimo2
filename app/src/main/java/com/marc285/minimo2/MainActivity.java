package com.marc285.minimo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.marc285.minimo2.models.Museums;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    private MuseumsAPI APIinterface;

    //Retrofit Methods (matching MuseumsAPI interface)

    public void loadMuseums(){
        //Method getMuseums() of the API interface

        Call<Museums> call = APIinterface.getMuseums();
        call.enqueue(new Callback<Museums>() {
            @Override
            public void onResponse(Call<Museums> call, Response<Museums> response) {
                if(response.isSuccessful()){
                    Museums museums = response.body();
                    recyclerView.setAdapter(new RVAdapter(museums.getElements()));
                }
                else
                    Toast.makeText(getApplicationContext(), "Error Code: " + response.code(), Toast.LENGTH_LONG).show();
                showProgress(false);
            }
            @Override
            public void onFailure(Call<Museums> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error Code: " + t.getMessage(), Toast.LENGTH_LONG).show();
                showProgress(false);
            }
        });
    }

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

        progressBar = findViewById(R.id.loadinglistProgressBar);
        recyclerView = findViewById(R.id.listRecyclerView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://do.diba.cat/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIinterface = retrofit.create(MuseumsAPI.class);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        loadMuseums();
    }
}
