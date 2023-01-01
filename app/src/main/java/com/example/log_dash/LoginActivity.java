package com.example.log_dash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.modal.Employee;
import com.example.retrofit.EmployeeAPI;
import com.example.retrofit.RetrofitService;
import com.google.android.material.button.MaterialButton;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                RetrofitService retrofitService = new RetrofitService();
                EmployeeAPI employeeApi = retrofitService.getRetrofit().create(EmployeeAPI.class);

                Employee employee = new Employee("Mohamed","OHYEAH","mail","pass");

                startActivity(new Intent(LoginActivity.this, StudentsListActivity.class));
                employeeApi.save(employee)
                        .enqueue(new Callback<Employee>() {
                            @Override
                            public void onResponse(Call<Employee> call, Response<Employee> response) {
                                Toast.makeText(LoginActivity.this, "Save successful!", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<Employee> call, Throwable t) {
                                Toast.makeText(LoginActivity.this, "Save failed!!!", Toast.LENGTH_SHORT).show();
                                Logger.getLogger(LoginActivity.class.getName()).log(Level.SEVERE, "Error occurred", t);
                            }
                        });
            }
        });



        TextView btn = findViewById(R.id.text_view_2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}