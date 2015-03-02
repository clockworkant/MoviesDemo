package com.clockworkant.movies.providers.rt.retrofit;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface RTService {
    @GET("/api/public/v1.0/lists/dvds/new_releases.json")
    Observable<RTReleasesResponse> getNewReleases(@Query("apikey") String apiKey);
}
