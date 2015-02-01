package com.clockworkant.movies.providers.retrofit;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface RTService {
    @GET("/api/public/v1.0/lists/dvds/new_releases.json")
    void getNewReleases(@Query("apikey") String apiKey, Callback<RTReleasesResponse> callback);
}
