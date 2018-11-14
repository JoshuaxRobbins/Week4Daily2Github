package com.example.josh.week4daily2_github.model.data.remote;




import com.example.josh.week4daily2_github.model.profile.ProfileResults;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RemoteService {

    @GET("/users/{user}")
    Observable<ProfileResults> getProfileData(@Path("user") String name);

}
