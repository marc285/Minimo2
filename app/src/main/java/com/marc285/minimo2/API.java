package com.marc285.minimo2;

//import com.marc285.minimo2.models.*;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    //GET X
    @GET("z/z/z")
    Call<String> getx();

}
