package com.example.josh.week4daily2_github.model.data.remote;
import com.example.josh.week4daily2_github.model.data.ProfileCallback;
import com.example.josh.week4daily2_github.model.profile.ProfileResults;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RemoteObserver implements Observer<ProfileResults> {
    ProfileCallback callback;

    public RemoteObserver(ProfileCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(ProfileResults profileResults) {
        callback.onSuccess(profileResults);
    }

    @Override
    public void onError(Throwable e) {
        callback.onFailure(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
