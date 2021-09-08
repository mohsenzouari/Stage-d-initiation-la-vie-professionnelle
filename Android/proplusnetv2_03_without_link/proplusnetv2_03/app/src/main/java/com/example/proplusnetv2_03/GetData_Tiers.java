package com.example.proplusnetv2_03;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetData_Tiers {
    @GET("tiers")
    Call<List<Tiers>> getAllTiers();
}
