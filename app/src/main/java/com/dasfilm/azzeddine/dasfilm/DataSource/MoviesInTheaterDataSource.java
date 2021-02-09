package com.dasfilm.azzeddine.dasfilm.DataSource;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;
import androidx.annotation.NonNull;
import android.util.Log;

import com.dasfilm.azzeddine.dasfilm.APIUtils.JSONParser;
import com.dasfilm.azzeddine.dasfilm.APIUtils.NetworkState;
import com.dasfilm.azzeddine.dasfilm.APIUtils.ServiceGenerator;
import com.dasfilm.azzeddine.dasfilm.Entities.BigSaveResponse;

import com.dasfilm.azzeddine.dasfilm.dataModels.TMDBWebService;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class MoviesInTheaterDataSource extends PageKeyedDataSource<Long,BigSaveResponse> {
    private static final String TAG = "MoviesInTheaterDataSou";
    private TMDBWebService tmdbWebService;
    private MutableLiveData<NetworkState> networkState;
    private MutableLiveData<NetworkState> initialLoading;
    private Executor retryExecutor;

    public MoviesInTheaterDataSource(Executor retryExecutor,TMDBWebService webService) {
        tmdbWebService = webService;
        networkState = new MutableLiveData<>();
        initialLoading = new MutableLiveData<>();
        this.retryExecutor = retryExecutor;
    }

    public MutableLiveData<NetworkState> getNetworkState() {
        return networkState;
    }

    public MutableLiveData getInitialLoading() {

        return initialLoading;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull final LoadInitialCallback<Long, BigSaveResponse> callback) {
        Log.d(TAG, "loadInitial: ");
        initialLoading.postValue(NetworkState.LOADING);
        networkState.postValue(NetworkState.LOADING);
        tmdbWebService.getMoviesInTheater(ServiceGenerator.API_DEFAULT_PAGE_KEY).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String responseString;
                List<BigSaveResponse> moviesList;

                Log.e(TAG, "onResponse error "+response.body());
                if (response.isSuccessful() && response.code() ==200) {
                        try {

                            initialLoading.postValue(NetworkState.LOADING);
                            networkState.postValue(NetworkState.LOADED);
                            responseString = response.body().string();
                            moviesList = JSONParser.getMovieList(responseString);
                            callback.onResult(moviesList,null, (long) 2);

                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }
                }else {
                    Log.e(TAG, "onResponse error "+response.message());
                    initialLoading.postValue(new NetworkState(NetworkState.Status.FAILED,response.message()));
                    networkState.postValue(new NetworkState(NetworkState.Status.FAILED,response.message()));
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                String errorMessage = t.getMessage();
                Log.e(TAG, "onFailure: "+errorMessage );
                networkState.postValue(new NetworkState(NetworkState.Status.FAILED,errorMessage));
            }
    });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, BigSaveResponse> callback) {

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Long> params, @NonNull final LoadCallback<Long, BigSaveResponse> callback) {
        networkState.postValue(NetworkState.LOADING);
        tmdbWebService.getMoviesInTheater(params.key).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                JSONObject responseJson;
                String responseString;
                List<BigSaveResponse> moviesList;
                Long nextKey;

                if (response.isSuccessful()) {


                    try {
                        initialLoading.postValue(NetworkState.LOADING);
                        networkState.postValue(NetworkState.LOADED);

                        Log.e(TAG, "onResponse error "+response.message());

                        responseString = response.body().string();
                        moviesList = JSONParser.getMovieList(responseString);



                        responseJson = new JSONObject(responseString);
                        nextKey = (params.key == responseJson.getInt("page")) ? null : params.key+1;

                        callback.onResult(moviesList, nextKey);

                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
                }else {
                    Log.e(TAG, "onResponse error "+response.message());
                    networkState.postValue(new NetworkState(NetworkState.Status.FAILED,response.message()));
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                String errorMessage = t.getMessage();
                Log.e(TAG, "onFailure: "+errorMessage );
                networkState.postValue(new NetworkState(NetworkState.Status.FAILED,errorMessage));
            }
        });
    }



}

