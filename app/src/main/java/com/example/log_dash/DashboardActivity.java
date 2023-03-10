package com.example.log_dash;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.modal.Employee;
import com.example.retrofit.EmployeeAPI;
import com.example.retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        RetrofitService retrofitService = new RetrofitService();
        EmployeeAPI employeeApi = retrofitService.getRetrofit().create(EmployeeAPI.class);
        employeeApi.getAllEmployees()
                .enqueue(new Callback<List<Employee>>() {
                    @Override
                    public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                        response.body();
                    }

                    @Override
                    public void onFailure(Call<List<Employee>> call, Throwable t) {
                        Toast.makeText(DashboardActivity.this, "Failed to load employees", Toast.LENGTH_SHORT).show();
                    }
                });


        android.widget.ListView listView = (android.widget.ListView) findViewById(R.id.listview);
        String[] classes = {"Deep Learning","Base de donnée","Développement Web","Computer Science","Programming Languages","Software Engineering","Operating Systems","Databases","Computer Networks","Computer Architecture","Artificial Intelligence","Human-Computer Interaction","Information Security"};
        int file = androidx.appcompat.R.layout.support_simple_spinner_dropdown_item;
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),file,classes);
        listView.setAdapter(adapter);

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
