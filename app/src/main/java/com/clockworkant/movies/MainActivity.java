package com.clockworkant.movies;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.clockworkant.movies.lib.Movie;
import com.clockworkant.movies.lib.MoviesProvider;

import java.util.List;

import rx.Subscription;
import rx.android.app.AppObservable;
import rx.functions.Action1;


public class MainActivity extends ActionBarActivity {

    private TextView tv;
    private Subscription subscription;
    private MoviesProvider moviesProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textview);

        moviesProvider = App.getInstance().getMoviesProvider();



    }

    @Override
    protected void onResume() {
        super.onResume();
        subscription = AppObservable.bindActivity(this, moviesProvider.getMovies())
                .subscribe(new Action1<List<Movie>>() {
                    @Override
                    public void call(List<Movie> movies) {
                        for (Movie movie : movies) {
                            tv.append(movie.getName() + '\n');
                        }
                    }
                });
    }

    @Override
    protected void onPause() {
        super.onPause();
        subscription.unsubscribe();
    }
}
