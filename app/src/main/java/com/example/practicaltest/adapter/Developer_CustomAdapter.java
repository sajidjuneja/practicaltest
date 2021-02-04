package com.example.practicaltest.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicaltest.R;
import com.example.practicaltest.databinding.SingleListItemBinding;
import com.example.practicaltest.model.Users;

import java.util.ArrayList;

public class Developer_CustomAdapter
        extends RecyclerView.Adapter<Developer_CustomAdapter.DeveloperViewHolder> {

    private ArrayList<Users> mUsers;

    @NonNull
    @Override
    public DeveloperViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        SingleListItemBinding mDeveloperListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.single_list_item, viewGroup, false);

        return new DeveloperViewHolder(mDeveloperListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DeveloperViewHolder mDeveloperViewHolder, int i) {
        Users currentStudent = mUsers.get(i);
        mDeveloperViewHolder.mDeveloperListItemBinding.setDeveloperModel(currentStudent);
    }

    @Override
    public int getItemCount() {
        if (mUsers != null) {
            return mUsers.size();
        } else {
            return 0;
        }
    }

    public void setDeveloperList(ArrayList<Users> mUsers) {
        this.mUsers = mUsers;
        notifyDataSetChanged();
    }

    class DeveloperViewHolder extends RecyclerView.ViewHolder {

        SingleListItemBinding mDeveloperListItemBinding;


        public DeveloperViewHolder(@NonNull SingleListItemBinding mDeveloperListItemBinding) {
            super(mDeveloperListItemBinding.getRoot());

            this.mDeveloperListItemBinding = mDeveloperListItemBinding;
        }
    }
}
