package com.example.practicaltest.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.practicaltest.model.Users;
import com.example.practicaltest.repository.UsersRepository;

import java.util.List;

public class UsersViewModel extends ViewModel {
    private UsersRepository usersRepository;

    public UsersViewModel(@NonNull Application application) {
        super();
        usersRepository = new UsersRepository();
    }

    public LiveData<List<Users>> getAllDeveloper() {
        return usersRepository.getMutableLiveData();
    }
}
