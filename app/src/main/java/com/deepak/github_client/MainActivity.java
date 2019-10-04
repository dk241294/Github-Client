package com.deepak.github_client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.deepak.github_client.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadLoginFragment();

    }


    public void loadLoginFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.container, new LoginFragment(), LoginFragment.TAG);
        ft.commit();

    }
    public void loadUsersFragment(){
        FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container,new UserFragment(),UserFragment.TAG);
        ft.addToBackStack(LoginFragment.TAG);
        ft.commit();

    }

    public void loadRepositoryFragment() {
        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container,new RepositoryFragment(),RepositoryFragment.TAG);
        ft.addToBackStack(UserFragment.TAG);
        ft.commit();

    }
}
