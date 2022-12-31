package com.example.log_dash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        MaterialButton login_btn = (MaterialButton) findViewById(R.id.login_btn);

        //prof access

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("prof") && password.getText().toString().equals("admin")) {
                    //correct
                    Toast.makeText(LoginActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this, DashboardActivity.class);
                    startActivity(i);
                } else
                    //incorrect
                    Toast.makeText(LoginActivity.this, "LOGIN FAILED !!!", Toast.LENGTH_SHORT).show();
            }
        });


        TextView btn = findViewById(R.id.text_view_2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });


    }
}