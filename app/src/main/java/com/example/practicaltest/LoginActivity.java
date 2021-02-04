package com.example.practicaltest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.example.practicaltest.databinding.ActivityLoginBinding;
import com.example.practicaltest.model.User;
import com.example.practicaltest.viewmodel.UserViewModel;
import com.example.practicaltest.viewmodel.factory.UserViewModelFactory;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_login);
        UserViewModel userViewModel = new ViewModelProvider(this, new UserViewModelFactory(this, new User())).get(UserViewModel.class);

        /**
         * Set ViewModel instance to binding class
         */
        binding.setUserViewModel(userViewModel);
    }
}