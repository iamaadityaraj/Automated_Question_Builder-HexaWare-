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

public class SignUpActivity extends AppCompatActivity {
    private AuthViewModel viewModel;
    private Intent intent;
    private TextView signu_page_appName,signup_text,signup_page_alerady_account_text;
    private EditText name,username,email_id,phone_number,password;
    private Button signip_page_signUp_btn,signup_page_login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // textViews widgets
        signu_page_appName=findViewById(R.id.signu_page_appName);
        signup_text=findViewById(R.id.signup_text);
        signup_page_alerady_account_text=findViewById(R.id.signup_page_alerady_account_text);

        // Edit Text Widget
        name=findViewById(R.id.name);
        username=findViewById(R.id.username);
        email_id=findViewById(R.id.email_id);
        phone_number=findViewById(R.id.phone_number);
        password=findViewById(R.id.password);

        // Button widgets
        signip_page_signUp_btn=findViewById(R.id.signip_page_signUp_btn);
        signup_page_login_btn=findViewById(R.id.signup_page_login_btn);

        signup_page_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(SignUpActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });
        signip_page_signUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=email_id.getText().toString();
                String pass= password.getText().toString();
                if(!email.isEmpty() && !pass.isEmpty()){
                    viewModel.signUp(email,pass);
                    Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                    intent = new Intent(SignUpActivity.this,ListActivity.class);
                    startActivity(intent);
                    
                }else{
                    Toast.makeText(getApplicationContext(), "please Enter Valid Details ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        viewModel= new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(AuthViewModel.class);
    }
}