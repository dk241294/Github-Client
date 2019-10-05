package com.deepak.github_client.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deepak.github_client.R;


public class RepositoryFragment extends Fragment {
    public static final String TAG = RepositoryFragment.class.getSimpleName();


    public RepositoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_repository, container, false);
        return view;
    }

}
