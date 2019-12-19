package com.marc285.minimo2;

import com.marc285.minimo2.models.Museums;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MuseumsAPI {

    //GET the List of Museums
    @GET("dataset/museus/format/json/pag-ini/1/pag-fi/15")
    Call<Museums> getMuseums();

}
