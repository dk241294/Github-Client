package com.deepak.github_client.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.deepak.github_client.R;
import com.deepak.github_client.adapter.RepositoryAdapter;
import com.deepak.github_client.constants.Constant;
import com.deepak.github_client.model.Repo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;


public class RepositoryFragment extends Fragment {
    public static final String TAG = RepositoryFragment.class.getSimpleName();
    RecyclerView recyclerView;
    RepositoryAdapter adapter;
    RequestQueue queue;
    List<Repo> repo=null;
    String userName = "dk19121991";


    public RepositoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_repository, container, false);
        adapter= new RepositoryAdapter(repo);
        recyclerView=view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        sendRecieveResponse(String.format(Constant.REPOS_URL,userName));
        recyclerView.setAdapter(adapter);


        return view;
    }
    public  void sendRecieveResponse(String url){
        final StringRequest request =new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse: "+response);
                GsonBuilder builder = new GsonBuilder();
                Gson gson =builder.create();
                Repo[] repoResponse=gson.fromJson(response,Repo[].class);
                List<Repo> repoList = Arrays.asList(repoResponse);
                adapter.setRepo(repoList);



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(),"error in fetching repository",Toast.LENGTH_LONG).show();

            }
        });
        queue= Volley.newRequestQueue(getActivity());
        queue.add(request);
    }

}
