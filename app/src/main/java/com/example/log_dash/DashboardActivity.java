package com.example.log_dash;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.log_dash.adapter.EmployeeAdapter;
import com.example.modal.Employee;
import com.example.modal.Subject;
import com.example.retrofit.EmployeeAPI;
import com.example.retrofit.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {

    private String teacher ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        android.widget.ListView listView = (android.widget.ListView) findViewById(R.id.listview);
        setContentView(R.layout.activity_dashboard);RetrofitService retrofitService = new RetrofitService();
        EmployeeAPI employeeApi = retrofitService.getRetrofit().create(EmployeeAPI.class);
        teacher = (String) getIntent().getSerializableExtra("TEACHER");
        employeeApi.getSubjects(teacher)
                .enqueue(new Callback<List<Subject>>() {
                    @Override
                    public void onResponse(Call<List<Subject>> call, Response<List<Subject>> response) {
                        EmployeeAdapter employeeAdapter = new EmployeeAdapter(response.body());
                        listView.setAdapter((ListAdapter) employeeAdapter);
                    }

                    @Override
                    public void onFailure(Call<List<Subject>> call, Throwable t) {
                        Toast.makeText(DashboardActivity.this, "Failed to load employees", Toast.LENGTH_SHORT).show();
                    }
                });







        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Create an Intent to start the second activity
                Intent intent = new Intent(DashboardActivity.this, StudentActivity.class);

                // Add the selected item text as an extra to the Intent
                intent.putExtra("SELECTED_ITEM", selectedItem);

                // Start the new activity
                startActivity(intent);
            }
        });

    }


}
