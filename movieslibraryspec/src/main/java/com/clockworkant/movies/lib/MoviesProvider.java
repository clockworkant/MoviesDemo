package com.clockworkant.movies.lib;

import java.util.List;

import rx.Observable;

public interface MoviesProvider {
    public Observable<List<Movie>> getMovies();
}
