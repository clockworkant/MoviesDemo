package com.clockworkant.movies.lib;

import java.util.List;

public interface MoviesProvider {
    public void getMovies(MoviesCallback moviesCallback);

    interface MoviesCallback{
        void onMoviesRecieved(List<Movie> movies);
    }
}
