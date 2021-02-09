package com.dasfilm.azzeddine.dasfilm.dataModels;



import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by azeddine on 3/27/18.
 */

public interface TMDBWebService {


    /**
     * Get a list of movies in theatres.
     */
    @GET("product_list_big/20?")
    Call<ResponseBody> getMoviesInTheater(@Query("page") long pageNumber);



}
