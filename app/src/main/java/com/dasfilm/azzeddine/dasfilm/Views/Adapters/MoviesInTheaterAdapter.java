package com.dasfilm.azzeddine.dasfilm.Views.Adapters;

import androidx.paging.PagedListAdapter;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dasfilm.azzeddine.dasfilm.APIUtils.NetworkState;
import com.dasfilm.azzeddine.dasfilm.Entities.BigSaveResponse;
import com.dasfilm.azzeddine.dasfilm.R;
import com.dasfilm.azzeddine.dasfilm.Views.CostumView.LimitedChatTextView;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;


/**
 * Created by azeddine on 3/31/18.
 */

public class MoviesInTheaterAdapter extends PagedListAdapter<BigSaveResponse,RecyclerView.ViewHolder> {
    private static final String TAG = "MoviesInTheaterAdapter";
    public static final int MOVIE_ITEM_VIEW_TYPE = 1;
    public static final int LOAD_ITEM_VIEW_TYPE  = 0;
    private Context mContext;
    private NetworkState mNetworkState;

    public MoviesInTheaterAdapter(Context context) {
        super(BigSaveResponse.DIFF_CALL);
        mContext = context;
    }


    @Override
    public int getItemViewType(int position) {
        return ( isLoadingData() && position == getItemCount()-1 )  ? LOAD_ITEM_VIEW_TYPE : MOVIE_ITEM_VIEW_TYPE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        if (viewType == MOVIE_ITEM_VIEW_TYPE) {
            view = inflater.inflate(R.layout.movie_item_v1, parent, false);
            return  new MovieViewHolder(view);
        } else{
            view = inflater.inflate(R.layout.load_progress_item, parent, false);
            return new ProgressViewHolder(view);
         }

    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if( holder instanceof MovieViewHolder){
            MovieViewHolder movieViewHolder = (MovieViewHolder) holder;
            BigSaveResponse movie = getItem(position);
            movieViewHolder.bind(movie,mContext);

        }


    }

    public void setNetworkState(NetworkState networkState) {
        NetworkState prevState = networkState;
        boolean wasLoading = isLoadingData();
        mNetworkState = networkState;
        boolean willLoad =  isLoadingData();
        if(wasLoading != willLoad){
            if (wasLoading) notifyItemRemoved(getItemCount()); else  notifyItemInserted(getItemCount());
        }
    }

    public boolean isLoadingData(){
        return  ( mNetworkState != null && mNetworkState != NetworkState.LOADED);
    }

    private static class MovieViewHolder extends RecyclerView.ViewHolder{
        LimitedChatTextView movieTitleTextView;
        TextView reviewsNumberTextView;
        ImageView moviePosterImageView;
        SimpleRatingBar ratingBar;
        public MovieViewHolder(View itemView) {
            super(itemView);
            movieTitleTextView = itemView.findViewById(R.id.movie_title);
            reviewsNumberTextView = itemView.findViewById(R.id.reviews_number);
            moviePosterImageView = itemView.findViewById(R.id.movie_poster);
            ratingBar = itemView.findViewById(R.id.movie_rating_bar);
        }
        public void bind(BigSaveResponse movie,Context context){
            movieTitleTextView.setMaxTextChar(15);
            movieTitleTextView.setText(movie.getName());
            Glide.with(context).load(movie.getPhoto()).into(moviePosterImageView);

        }
    }
    private static class ProgressViewHolder extends RecyclerView.ViewHolder{

        public ProgressViewHolder(View itemView) {
            super(itemView);
        }
    }
}
