package com.example.log_dash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.log_dash.adapter.ClasseAdapter;
import com.example.log_dash.adapter.EmployeeAdapter;
import com.example.modal.Student;
import com.example.modal.Subject;
import com.example.retrofit.EmployeeAPI;
import com.example.retrofit.RetrofitService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClassListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private String classe ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);

        recyclerView = findViewById(R.id.employeeList_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        classe = (String) getIntent().getSerializableExtra("CLASSE");

    }

    private void loadEmployees() {
        RetrofitService retrofitService = new RetrofitService();
        EmployeeAPI employeeApi = retrofitService.getRetrofit().create(EmployeeAPI.class);
        classe = (String) getIntent().getSerializableExtra("CLASSE");
        employeeApi.getStudents(classe)
                .enqueue(new Callback<List<Student>>() {
                    @Override
                    public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                        populateListView(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Student>> call, Throwable t) {
                        Toast.makeText(ClassListActivity.this, "Failed to load employees", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void populateListView(List<Student> employeeList) {
        ClasseAdapter employeeAdapter = new ClasseAdapter(employeeList);
        recyclerView.setAdapter(employeeAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadEmployees();
    }
}