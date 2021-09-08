package com.example.t5;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetData {
    @GET("commande_ressource")
    Call<List<RetrofitRessource>> getAllRessources();
}
