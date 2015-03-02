package com.clockworkant.movies.providers.rt;

import com.clockworkant.movies.lib.Movie;
import com.clockworkant.movies.lib.MoviesProvider;
import com.clockworkant.movies.providers.rt.retrofit.RTReleasesResponse;
import com.clockworkant.movies.providers.rt.retrofit.RTService;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import rx.Observable;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

public class RottenTomatoesMovieProvider implements MoviesProvider {

    private final RTService rtService;
    private final BehaviorSubject<List<Movie>> movies;

    public RottenTomatoesMovieProvider() {
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint("http://api.rottentomatoes.com").build();
        rtService = adapter.create(RTService.class);
        movies = BehaviorSubject.create((List<Movie>)new ArrayList<Movie>());
    }

    @Override
    public Observable<List<Movie>> getMovies() {
        //Todo think about caching response
        Observable<RTReleasesResponse> rtObservable = rtService.getNewReleases("p459835aac72zf69tw2t8wmq");
        rtObservable.subscribe(new Action1<RTReleasesResponse>() {
            @Override
            public void call(RTReleasesResponse rtReleasesResponse) {
                movies.onNext(new ArrayList<Movie>(rtReleasesResponse.movies));
            }
        });

        return movies;

    }
}
