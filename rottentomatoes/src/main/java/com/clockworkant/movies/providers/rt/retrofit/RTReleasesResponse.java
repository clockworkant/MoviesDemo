package com.clockworkant.movies.providers.rt.retrofit;

import com.clockworkant.movies.lib.Movie;

import java.util.ArrayList;

public class RTReleasesResponse {
    public ArrayList<RTMovie> movies;

    private class RTMovie implements Movie {
        String title;

        @Override
        public String getName() {
            return title;
        }
    }
}
