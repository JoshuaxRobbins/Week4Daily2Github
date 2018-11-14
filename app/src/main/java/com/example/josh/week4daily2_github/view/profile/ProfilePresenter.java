package com.example.josh.week4daily2_github.view.profile;

import com.example.josh.week4daily2_github.model.data.ProfileCallback;
import com.example.josh.week4daily2_github.model.data.ProfileRepository;
import com.example.josh.week4daily2_github.model.profile.ProfileResults;

public class ProfilePresenter implements ProfileContract.Presenter {
    ProfileContract.View view;
    ProfileRepository repository;

    public ProfilePresenter(ProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getProfile(String name) {
        repository.getProfileData(name, new ProfileCallback() {
            @Override
            public void onSuccess(ProfileResults profileResults) {
                view.onProfile(profileResults);
            }

            @Override
            public void onFailure(String error) {
                view.showError(error);
            }
        });
    }

    @Override
    public void onAttach(ProfileContract.View view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }
}
