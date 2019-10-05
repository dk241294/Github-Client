package com.deepak.github_client.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textclassifier.TextClassification;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.deepak.github_client.MainActivity;
import com.deepak.github_client.R;
import com.deepak.github_client.constants.Constant;
import com.deepak.github_client.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

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
    LinearLayout linearLayout;
    RequestQueue queue;


    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        ui(view);

        sendRecieveResponse("https://api.github.com/users/dk241294");
        return view;
    }

    public void ui(View view) {
        progressBar = view.findViewById(R.id.progressBar);
        userImg = view.findViewById(R.id.imgUser);
        userNameTxt = view.findViewById(R.id.txtUserName);
        loginTxt = view.findViewById(R.id.txtLogin);
        reposTxt = view.findViewById(R.id.txtRepos);
        followersTxt = view.findViewById(R.id.txtFollowers);
        followingTxt = view.findViewById(R.id.txtFollowing);
        emailTxt = view.findViewById(R.id.txtEmail);
        repoButton = view.findViewById(R.id.btnRepo);
        repoButton.setOnClickListener(this);


    }


    public void sendRecieveResponse(String url) {
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse: " + response);
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                User userResponse = gson.fromJson(response, User.class);

                progressBar.setVisibility(View.GONE);
                if (userResponse == null) {
                    linearLayout.setVisibility(View.GONE);
                    Toast.makeText(getActivity(), "please enter valid username", Toast.LENGTH_SHORT).show();

                } else {
                    Picasso.get().load(userResponse.getAvatarUrl()).into(userImg);
                    if (userResponse.getName() == null) {
                        userNameTxt.setText("No Name Provided");
                    } else {
                        userNameTxt.setText("Username: " + userResponse.getName());
                    }
                    followersTxt.setText("Followers: " + userResponse.getFollowers());
                    followingTxt.setText("Following: " + userResponse.getFollowing());
                    reposTxt.setText("Repoitories Count: " + userResponse.getPublicRepos());
                    if (userResponse.getEmail() == null) {
                        emailTxt.setText("No Email Id Provided");
                    } else {
                        emailTxt.setText("Email: "+userResponse.getEmail());
                    }
                    loginTxt.setText("Login: "+userResponse.getLogin());

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                linearLayout.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "error ocur in fetching data", Toast.LENGTH_SHORT).show();

            }
        });
        queue = Volley.newRequestQueue(getActivity());
        queue.add(request);

    }

    public void onClick(View v) {
        Log.d(TAG, "onClick: ");
        MainActivity activity = (MainActivity) getActivity();
        if (activity != null) {
            activity.loadRepositoryFragment();
        }

    }
}
