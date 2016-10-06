package com.example.faruk.hci_ib130051.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RestFactoryClient {

    private static final String BASE_URL = "http://5.189.152.86/";

//    private static final String BASE_URL = "http://192.168.0.19:61719/api/";
    private static FApiService fApiService;

    public static void resetClient() {
        RestFactoryClient restFactoryClient = new RestFactoryClient();
        fApiService = restFactoryClient.getRestAdapter().create(FApiService.class);
    }

    private Retrofit getRestAdapter() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getHttpClient())
                .build();

        return retrofit;
    }

    public static FApiService getfApiService() {
        return fApiService;
    }

    // Http client
    private OkHttpClient getHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.networkInterceptors().add(getHttpLoggingInterceptor());
        return httpClient.build();
    }

    // Logger for requests
    private HttpLoggingInterceptor getHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

}
