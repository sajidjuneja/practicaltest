package com.example.practicaltest.network;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiDataService {


    @GET("api/users?page=1")
    Call<JsonArray> getApiRequestsArray();

}
