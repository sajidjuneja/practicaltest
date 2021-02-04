package com.example.practicaltest.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.practicaltest.model.Users;
import com.example.practicaltest.network.ApiDataService;
import com.example.practicaltest.network.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersRepository {

    private static final String TAG = "UsersRepository";
    private ArrayList<Users> usersArrayList = new ArrayList<>();
    private MutableLiveData<List<Users>> mutableLiveData = new MutableLiveData<>();

    public UsersRepository(){

    }

    public MutableLiveData<List<Users>> getMutableLiveData() {

        ///ini Retrofit Class
        final ApiDataService userDataService = RetrofitClient.getService();

        ///call the API that define In Interface
        Call<JsonArray> call = userDataService.getApiRequestsArray();

        call.enqueue(new Callback<JsonArray>() {
            String message;

            @Override
            public void onResponse(@NonNull Call<JsonArray> call, @NonNull Response<JsonArray> resp) {

                Gson gson = new GsonBuilder().create();

                if (resp != null && resp.body() != null) {
                    JsonArray json = new JsonParser().parse(resp.body().toString()).getAsJsonArray();
                    if (json != null) {

                        for (int i = 0; i <= json.size() - 1; i++) {
                            try {

                                JsonObject jsonobj = new JsonParser().parse(json.get(i).toString()).getAsJsonObject();

                                Users responseModel = gson.fromJson(jsonobj, Users.class);

                                usersArrayList.add(responseModel);

                            } catch (Exception ex) {

                            }


                        }
                        mutableLiveData.setValue(usersArrayList);

                    }
                }


            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                t.printStackTrace();

            }
        });


        return mutableLiveData;
    }
}
