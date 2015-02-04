package com.clockworkant.movies;

import android.app.Application;

import com.clockworkant.movies.lib.MoviesProvider;
import com.clockworkant.movies.providers.mock.MockMovieProvider;
import com.clockworkant.movies.providers.rt.RottenTomatoesMovieProvider;

public class App extends Application {

    private MoviesProvider mMoviesProvider;
    private static App mApp;
    private final static Boolean mUseMock = false;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        if (mUseMock) {
            mMoviesProvider = new MockMovieProvider();
        } else {
            mMoviesProvider = new RottenTomatoesMovieProvider();
        }
    }

    public static App getInstance(){
        return mApp;
    }

    public MoviesProvider getMoviesProvider() {
        return mMoviesProvider;
    }
}
