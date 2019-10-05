package com.deepak.github_client.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.deepak.github_client.R;
import com.deepak.github_client.model.Repo;

import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder> {
    List<Repo> repo;


    public RepoAdapter(List<Repo> repo) {
        this.repo = repo;
    }

    public void setRepo(List<Repo> repo) {
        this.repo = repo;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Repo currentRepo = repo.get(position);
        holder.nameTxt.setText("Repository Name:" + currentRepo.getName());
        holder.languageTxt.setText("Language:" + currentRepo.getLanguage());
        holder.watcherTxt.setText("Watcher" + currentRepo.getWatchers());
        holder.cloneTxt.setText("Clone" + currentRepo.getCloneUrl());
        holder.createdAtTxt.setText("Created At:" + currentRepo.getCreatedAt());
        if (currentRepo.getDescription() == null) {
            holder.descriptionTxt.setText("No description");
        } else {
            holder.descriptionTxt.setText("Description" + currentRepo.getDescription());
        }
    }


    @Override
    public int getItemCount() {
        return repo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTxt, languageTxt, watcherTxt, cloneTxt, createdAtTxt, descriptionTxt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTxt = itemView.findViewById(R.id.txtName);
            languageTxt = itemView.findViewById(R.id.txtLanguage);
            watcherTxt = itemView.findViewById(R.id.txtWatcher);
            cloneTxt = itemView.findViewById(R.id.txtWatcher);
            createdAtTxt = itemView.findViewById(R.id.txtCreatedAt);
            descriptionTxt = itemView.findViewById(R.id.txtDescription);


        }
    }

