package com.dasfilm.azzeddine.dasfilm.Views.Activities;


import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dasfilm.azzeddine.dasfilm.APIUtils.NetworkState;
import com.dasfilm.azzeddine.dasfilm.Entities.BigSaveResponse;
import com.dasfilm.azzeddine.dasfilm.R;
import com.dasfilm.azzeddine.dasfilm.Views.Adapters.MoviesInTheaterAdapter;
import com.dasfilm.azzeddine.dasfilm.viewModels.MoviesInTheaterViewModel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private MoviesInTheaterViewModel mMoviesViewModel;
    private RecyclerView mRecyclerView;
    private MoviesInTheaterAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.list);

        adapter = new MoviesInTheaterAdapter(this);

        mMoviesViewModel = ViewModelProviders.of(this).get(MoviesInTheaterViewModel.class);
        mMoviesViewModel.getMoviesInTheaterList().observe(this, new Observer<PagedList<BigSaveResponse>>() {
            @Override
            public void onChanged(@Nullable PagedList<BigSaveResponse> movies) {
                Log.d(TAG, "onChanged: "+movies.size());
                adapter.submitList(movies);
            }
        });
        mMoviesViewModel.getNetworkStateLiveData().observe(this, new Observer<NetworkState>() {
            @Override
            public void onChanged(@Nullable NetworkState networkState) {
                Log.d(TAG, "onChanged: network state changed");
                adapter.setNetworkState(networkState);
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        mRecyclerView.setAdapter(adapter);
    }
}
