package com.deepak.github_client.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.deepak.github_client.MainActivity;
import com.deepak.github_client.R;


public class LoginFragment extends Fragment implements View.OnClickListener {
    public static final String TAG = LoginFragment.class.getSimpleName();
    Button loginbtn;
    EditText userNameet;
    String userName;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        loginbtn =view.findViewById(R.id.btnLogin);
        userNameet=view.findViewById(R.id.edtLogin);
        loginbtn.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
       userName =userNameet.getText().toString().trim();
        MainActivity activity = (MainActivity) getActivity();
        if(userName!=null){
            activity.loadUsersFragment();
        }

    }
}
