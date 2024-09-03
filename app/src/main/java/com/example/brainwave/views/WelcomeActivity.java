package com.example.brainwave.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.brainwave.R;
import com.example.brainwave.viewmodel.AuthViewModel;

public class WelcomeActivity extends AppCompatActivity {
    private AuthViewModel viewModel;
    private Intent intent;
    TextView welcome_text,app_name1,alerady_account_text;
    Button welcome_page_signUp_btn,welcome_page_login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        welcome_text=findViewById(R.id.welcome_text);
        app_name1=findViewById(R.id.app_name1);
        alerady_account_text=findViewById(R.id.alerady_account_text);
        welcome_page_signUp_btn=findViewById(R.id.welcome_page_signUp_btn);
        welcome_page_login_btn=findViewById(R.id.welcome_page_login_btn);

        welcome_page_signUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent= new Intent(WelcomeActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        welcome_page_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent= new Intent(WelcomeActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });
        viewModel= new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(AuthViewModel.class);
    }
}