package com.dasfilm.azzeddine.dasfilm.APIUtils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by azeddine on 3/28/18.
 */

public class ServiceGenerator {
    private static final String BASE_URL = "https://noonexpress.com.bd/api/";
    public static final int API_DEFAULT_PAGE_KEY = 1;

    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL)
                                                            .addConverterFactory(GsonConverterFactory.create());
    static Retrofit retrofit = builder.build();

    private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor()
                                                                .setLevel(HttpLoggingInterceptor.Level.BODY);
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();




    public static <S> S createService(Class<S> serviceClass){
        if(!httpClient.interceptors().contains(logging)){
            //httpClient.addInterceptor(logging);
            builder.client(httpClient.build());
            retrofit = builder.build();
        }
        return  retrofit.create(serviceClass);
    }

}
