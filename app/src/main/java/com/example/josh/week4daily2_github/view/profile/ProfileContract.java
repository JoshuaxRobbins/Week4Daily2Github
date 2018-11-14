package com.example.josh.week4daily2_github.view.profile;

import com.example.josh.week4daily2_github.model.profile.ProfileResults;
import com.example.josh.week4daily2_github.view.base.BasePresenter;
import com.example.josh.week4daily2_github.view.base.BaseView;

public interface ProfileContract {

    interface View extends BaseView{
        void onProfile(ProfileResults profileResults);
    }

    interface Presenter extends BasePresenter<View>{
        void getProfile(String name);
    }
}
