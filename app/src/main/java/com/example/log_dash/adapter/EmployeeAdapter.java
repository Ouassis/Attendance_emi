package com.example.log_dash.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.log_dash.R;
import com.example.modal.Subject;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeHolder> {

    private List<Subject> employeeList;

    public EmployeeAdapter(List<Subject> employeeList) {

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
        Subject employee = employeeList.get(position);
        holder.name.setText(employee.getId());
        holder.location.setText(employee.getName());
        holder.branch.setText(employee.getClasses().getName());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }
}