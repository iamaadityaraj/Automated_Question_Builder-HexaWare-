package com.example.brainwave.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.brainwave.R;
import com.example.brainwave.viewmodel.AuthViewModel;

public class LogInActivity extends AppCompatActivity {
    private AuthViewModel viewModel;
    private Intent intent;
    private TextView login_page_appName,login_text,dont_have_account;
    private EditText login_page_email_id,login_page_password;
    private Button  login_page_login_btn,login_page_signup_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        login_page_appName=findViewById(R.id.login_page_appName);
        login_text=findViewById(R.id.login_text);
        dont_have_account=findViewById(R.id.dont_have_account);
        login_page_email_id=findViewById(R.id.login_page_email_id);
        login_page_password=findViewById(R.id.login_page_password);
        login_page_login_btn=findViewById(R.id.login_page_login_btn);
        login_page_signup_btn=findViewById(R.id.login_page_signup_btn);

        login_page_signup_btn.setOnClickListener(view -> {
            intent= new Intent(LogInActivity.this, SignUpActivity.class);
            startActivity(intent);
        });
        login_page_login_btn.setOnClickListener(view -> {
            String email=login_page_email_id.getText().toString();
            String pass= login_page_password.getText().toString();
            if(!email.isEmpty() && !pass.isEmpty()){
                viewModel.logIn(email,pass);
                Toast.makeText(getApplicationContext(), "LogIn Successfully", Toast.LENGTH_SHORT).show();
                intent = new Intent(LogInActivity.this,ListActivity.class);
                startActivity(intent);

            }else{
                Toast.makeText(getApplicationContext(), "please Enter Valid Details ", Toast.LENGTH_SHORT).show();
            }
        });

        viewModel= new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(AuthViewModel.class);
    }
}