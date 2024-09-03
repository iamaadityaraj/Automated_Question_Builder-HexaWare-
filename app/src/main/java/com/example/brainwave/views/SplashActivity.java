package com.example.brainwave.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.brainwave.R;
import com.example.brainwave.viewmodel.AuthViewModel;

public class SplashActivity extends AppCompatActivity {
    private AuthViewModel viewModel;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        viewModel= new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(AuthViewModel.class);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                intent= new Intent(SplashActivity.this, viewModel.getCurrentUser()!= null? ListActivity.class: WelcomeActivity.class);

                startActivity(intent);
            }
        },4000);

    }
}