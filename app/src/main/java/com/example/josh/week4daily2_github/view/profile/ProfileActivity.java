package com.example.josh.week4daily2_github.view.profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.josh.week4daily2_github.R;
import com.example.josh.week4daily2_github.model.data.ProfileRepository;
import com.example.josh.week4daily2_github.model.data.local.LocalDataSource;
import com.example.josh.week4daily2_github.model.data.remote.RemoteDataSource;
import com.example.josh.week4daily2_github.model.profile.ProfileResults;

import retrofit2.Callback;

public class ProfileActivity extends AppCompatActivity implements ProfileContract.View {
    public static final String TAG = "_TAG";
    private RemoteDataSource remoteDataSource;
    private ProfilePresenter presenter;
    TextView tvName;
    TextView tvEmail;
    TextView tvBio;
    TextView tvRepos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvBio = findViewById(R.id.tvBio);
        tvRepos = findViewById(R.id.tvRepos);


        presenter = new ProfilePresenter(new ProfileRepository(new LocalDataSource(), new RemoteDataSource()));
        presenter.getProfile("JoshuaxRobbins");

    }


    @Override
    public void onProfile(ProfileResults profileResults) {
        Log.d(TAG, "onProfile: " + profileResults.toString());
        tvName.setText(profileResults.getName());
        tvBio.setText(profileResults.getBio());
        tvEmail.setText(profileResults.getLocation());
        tvRepos.setText("Public Repos: " + profileResults.getPublicRepos());

    }

    @Override
    public void showError(String error) {
        Log.d(TAG, "showError: " + error);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onAttach(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onDetach();
    }
}
