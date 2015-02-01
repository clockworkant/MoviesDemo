package com.clockworkant.movies;

import android.app.Application;

import com.clockworkant.RottenTomatoesMovieProvider;
import com.clockworkant.movies.lib.MoviesProvider;

public class App extends Application {

    private MoviesProvider mMoviesProvider;
    private static App mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        mMoviesProvider = new RottenTomatoesMovieProvider();
    }

    public static App getInstance(){
        return mApp;
    }

    public MoviesProvider getMoviesProvider() {
        return mMoviesProvider;
    }
}
