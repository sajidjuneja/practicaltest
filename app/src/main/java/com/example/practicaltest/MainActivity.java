package com.example.practicaltest;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicaltest.adapter.Developer_CustomAdapter;
import com.example.practicaltest.databinding.ActivityMainBinding;
import com.example.practicaltest.model.Users;
import com.example.practicaltest.viewmodel.UsersViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    ProgressBar loadBar;
    private UsersViewModel mainViewModel;
    private Developer_CustomAdapter mDeveloper_CustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        // bind RecyclerView
        RecyclerView recyclerView = activityMainBinding.viewdeveloper;
        loadBar = activityMainBinding.loadBar;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ///init the View Model
        mainViewModel = new ViewModelProvider(this).get(UsersViewModel.class);

        //init the Custom adataper
        mDeveloper_CustomAdapter = new Developer_CustomAdapter();
        //set the CustomAdapter
        recyclerView.setAdapter(mDeveloper_CustomAdapter);

    }

    private void getAllDev() {
        ///get the list of dev from api response
        mainViewModel.getAllDeveloper().observe(this, new Observer<List<Users>>() {
            @Override
            public void onChanged(@Nullable List<Users> mDeveloperModel) {

                ///if any thing chnage the update the UI
                //mDeveloper_CustomAdapter.setDeveloperList((ArrayList<Users>) mDeveloperModel);
                loadBar.setVisibility(View.GONE);
            }
        });
    }
}