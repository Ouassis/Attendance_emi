package com.example.log_dash;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
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

    public List<Employee> employeeList;


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
                        employeeList = response.body();
                        android.widget.ListView listView = (android.widget.ListView) findViewById(R.id.listview);




                        int file = androidx.appcompat.R.layout.support_simple_spinner_dropdown_item;
                        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),file,employeeList);
                        listView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<List<Employee>> call, Throwable t) {
                        Toast.makeText(DashboardActivity.this, "Failed to load employees", Toast.LENGTH_SHORT).show();
                    }
                });




    }


}
