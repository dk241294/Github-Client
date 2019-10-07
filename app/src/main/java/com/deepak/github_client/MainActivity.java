package com.deepak.github_client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.deepak.github_client.fragment.LoginFragment;
import com.deepak.github_client.fragment.RepositoryFragment;
import com.deepak.github_client.fragment.UserFragment;

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
    public void loadUsersFragment(String username){
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
