package com.clockworkant.retrofit;

import com.clockworkant.movies.lib.Movie;

import java.util.ArrayList;

/**
 * Created by alecholmes on 01/02/15.
 */
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
