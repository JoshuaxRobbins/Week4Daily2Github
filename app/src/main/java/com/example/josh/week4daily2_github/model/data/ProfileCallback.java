package com.example.josh.week4daily2_github.model.data;


import com.example.josh.week4daily2_github.model.profile.ProfileResults;

import java.util.List;

public interface ProfileCallback {

    void onSuccess(ProfileResults profileResults);

    void onFailure(String error);
}
