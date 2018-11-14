package com.example.josh.week4daily2_github.model.data.remote;

import com.example.josh.week4daily2_github.model.profile.ProfileResults;
import com.example.josh.week4daily2_github.utils.NetworkHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {

    private Retrofit createInstance(){
        return new Retrofit.Builder()
                .baseUrl(NetworkHelper.BASE_GIT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private RemoteService getRemoteService(){
        return createInstance().create(RemoteService.class);
    }

    public Observable<ProfileResults> getProfileData(String name){
        return getRemoteService().getProfileData(name);
    }


}
