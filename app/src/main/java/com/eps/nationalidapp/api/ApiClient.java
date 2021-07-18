package com.eps.nationalidapp.api;

import android.os.Environment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    private static final String BASE_URL = "";
    private static Retrofit retrofit = null;
    private static OkHttpClient okHttpClient = null;
    private static final long REQUEST_TIMEOUT = 60L;
    public static final String TAG = ApiClient.class.getName();


    public static Retrofit getClient() {
        if (okHttpClient == null) {
            initHttpClient();
        }
        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

    private static void initHttpClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
                .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(interceptor);

        okHttpClient = builder.build();

    }

}
