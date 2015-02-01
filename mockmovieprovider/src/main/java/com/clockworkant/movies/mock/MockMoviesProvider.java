package com.clockworkant.movies.mock;

import com.clockworkant.movies.lib.Movie;
import com.clockworkant.movies.lib.MoviesProvider;

import java.util.ArrayList;
import java.util.List;

public class MockMoviesProvider implements MoviesProvider {
    @Override
    public void getMovies(MoviesCallback moviesCallback) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new MockMovie("Die Hard 3"));
        movies.add(new MockMovie("Pulp Fiction"));
        movies.add(new MockMovie("Blade"));
        movies.add(new MockMovie("Up"));
        movies.add(new MockMovie("Wreck it Ralph!"));
        movies.add(new MockMovie("Mulan"));
        movies.add(new MockMovie("Super awesome movie"));
        movies.add(new MockMovie("Wizard of Oz"));
        movies.add(new MockMovie("Public speaking for dummies"));
        movies.add(new MockMovie("How to deal with failure"));
        movies.add(new MockMovie("The Lego Movie"));
        movies.add(new MockMovie("How to choose a new career"));
        moviesCallback.onMoviesRecieved(movies);
    }

    private static class MockMovie implements Movie {


        private final String name;

        private MockMovie(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
