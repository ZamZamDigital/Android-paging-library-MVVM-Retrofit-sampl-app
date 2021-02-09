package com.dasfilm.azzeddine.dasfilm.viewModels;


import android.util.Log;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.dasfilm.azzeddine.dasfilm.APIUtils.NetworkState;
import com.dasfilm.azzeddine.dasfilm.APIUtils.ServiceGenerator;
import com.dasfilm.azzeddine.dasfilm.DataSource.MoviesInTheaterDataSource;
import com.dasfilm.azzeddine.dasfilm.DataSource.MoviesInTheaterDataSourceFactory;
import com.dasfilm.azzeddine.dasfilm.Entities.BigSaveResponse;
import com.dasfilm.azzeddine.dasfilm.dataModels.TMDBWebService;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * Created by azeddine on 3/29/18.
 */

public class MoviesInTheaterViewModel extends ViewModel {
    private static final String TAG = "TheaterViewModel";
    private LiveData<PagedList<BigSaveResponse>> moviesInTheaterList;
    private LiveData<NetworkState> networkStateLiveData;
    private Executor executor;
    private LiveData<MoviesInTheaterDataSource> dataSource;


    public MoviesInTheaterViewModel() {
        Log.d(TAG, "MoviesInTheaterViewModel: ");
        executor = Executors.newFixedThreadPool(5);
        TMDBWebService webService = ServiceGenerator.createService(TMDBWebService.class);
        MoviesInTheaterDataSourceFactory factory = new MoviesInTheaterDataSourceFactory(executor,webService);
        dataSource =  factory.getMutableLiveData();

        networkStateLiveData = Transformations.switchMap(factory.getMutableLiveData(), new Function<MoviesInTheaterDataSource, LiveData<NetworkState>>() {
            @Override
            public LiveData<NetworkState> apply(MoviesInTheaterDataSource source) {
                Log.d(TAG, "apply: network change");
                return source.getNetworkState();
            }
        });

        PagedList.Config pageConfig = (new PagedList.Config.Builder())
                                                .setEnablePlaceholders(true)
                                                .setInitialLoadSizeHint(10)
                                                .setPageSize(20).build();

        moviesInTheaterList = (new LivePagedListBuilder<Long,BigSaveResponse>(factory,pageConfig))
                                                    .build();

    }

    public LiveData<PagedList<BigSaveResponse>> getMoviesInTheaterList() {
        Log.d(TAG, "getMoviesInTheaterList: ");
        return moviesInTheaterList;
    }

    public LiveData<NetworkState> getNetworkStateLiveData() {
        return networkStateLiveData;
    }
}

