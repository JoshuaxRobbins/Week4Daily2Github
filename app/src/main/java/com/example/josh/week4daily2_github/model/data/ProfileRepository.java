package com.example.josh.week4daily2_github.model.data;

import com.example.josh.week4daily2_github.CacheManager;
import com.example.josh.week4daily2_github.model.data.local.LocalDataSource;
import com.example.josh.week4daily2_github.model.data.remote.RemoteDataSource;
import com.example.josh.week4daily2_github.model.data.remote.RemoteObserver;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ProfileRepository {

    LocalDataSource localDataSource;
    RemoteDataSource remoteDataSource;

    public ProfileRepository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    public void getProfileData(String name,final ProfileCallback callback){

        if(CacheManager.isCacheDirty()){
            remoteDataSource.getProfileData(name)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new RemoteObserver(callback));
        }
    }
}
