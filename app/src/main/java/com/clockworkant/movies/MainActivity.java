package com.clockworkant.movies;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.clockworkant.movies.lib.Movie;
import com.clockworkant.movies.lib.MoviesProvider;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textview);

        MoviesProvider moviesProvider = App.getInstance().getMoviesProvider();
        moviesProvider.getMovies(new MoviesProvider.MoviesCallback() {
            @Override
            public void onMoviesRecieved(List<Movie> movies) {
                addMovies(movies);
            }
        });
    }

    private void addMovies(final List<Movie> movies){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for(Movie movie : movies){
                    tv.append(movie.getName() + '\n');
                }
            }
        });
    }

}
