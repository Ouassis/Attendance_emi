package com.example.retrofit;

import com.example.modal.Employee;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EmployeeAPI {
    @GET("/employees")
    Call<List<Employee>> getAllEmployees();

    @POST("/employee")
    Call<Employee> save(@Body Employee employee);

}
