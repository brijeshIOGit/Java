package com.scaler.Album;

import com.scaler.rest.JSONPlaceholder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class AlbumClient {



    private JSONPlaceholder api;
    public AlbumClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();

        api = retrofit.create((JSONPlaceholder.class));

    }
    public JSONPlaceholder getApi() {
        return api;
    }
}
