package com.example.log_dash.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.log_dash.R;
import com.example.modal.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeHolder> {

    private List<Employee> employeeList;

    public EmployeeAdapter(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_students_item, parent, false);
        return new EmployeeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {
        Employee employee = employeeList.get(position);
        holder.name.setText(employee.getFirstName());
        holder.location.setText(employee.getLastName());
        holder.branch.setText(employee.getLastName());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }
}