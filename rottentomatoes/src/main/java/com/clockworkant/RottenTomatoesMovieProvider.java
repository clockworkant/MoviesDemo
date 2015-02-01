package com.clockworkant;

import com.clockworkant.movies.lib.Movie;
import com.clockworkant.movies.lib.MoviesProvider;
import com.clockworkant.retrofit.RTReleasesResponse;
import com.clockworkant.retrofit.RTService;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RottenTomatoesMovieProvider implements MoviesProvider{

    @Override
    public void getMovies(final MoviesCallback moviesCallback) {
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint("http://api.rottentomatoes.com").build();
        RTService rtService = adapter.create(RTService.class);

        rtService.getNewReleases("p459835aac72zf69tw2t8wmq", new Callback<RTReleasesResponse>() {
            @Override
            public void success(RTReleasesResponse rtReleasesResponse, Response response) {
                moviesCallback.onMoviesRecieved(new ArrayList<Movie>(rtReleasesResponse.movies));
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }

}
