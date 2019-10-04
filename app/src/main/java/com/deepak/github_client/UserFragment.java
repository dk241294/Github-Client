package com.deepak.github_client;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class UserFragment extends Fragment implements View.OnClickListener {
    public static final String TAG = UserFragment.class.getSimpleName();
    ProgressBar progressBar;
    ImageView userImg;
    TextView userNameTxt;
    TextView loginTxt;
    TextView reposTxt;
    TextView followersTxt;
    TextView followingTxt;
    TextView emailTxt;
    Button repoButton;



    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_user, container, false);
        progressBar=view.findViewById(R.id.progressBar);
        userImg=view.findViewById(R.id.imgUser);
        userNameTxt=view.findViewById(R.id.txtUserName);
        loginTxt=view.findViewById(R.id.txtLogin);
        reposTxt=view.findViewById(R.id.txtRepos);
        followersTxt=view.findViewById(R.id.txtFollowers);
        followingTxt=view.findViewById(R.id.txtFollowing);
        emailTxt=view.findViewById(R.id.txtEmail);
        repoButton=view.findViewById(R.id.btnRepo);
        repoButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick: ");
        MainActivity activity= (MainActivity) getActivity();
        if(activity!=null){
            activity.loadRepositoryFragment();
        }

    }
}
