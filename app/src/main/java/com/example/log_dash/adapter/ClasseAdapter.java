package com.example.log_dash.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.log_dash.ClassListActivity;
import com.example.log_dash.R;
import com.example.log_dash.StudentsListActivity;
import com.example.modal.Student;
import com.example.modal.Subject;

import java.util.List;

public class ClasseAdapter extends RecyclerView.Adapter<ClasseHolder>{

    private List<Student> employeeList;
    private Context context;
    private SelectListener listener ;

    public ClasseAdapter(List<Student> employeeList) {
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public ClasseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_students_item, parent, false);
        return new ClasseHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClasseHolder holder, int position) {
        Student employee = employeeList.get(position);
        holder.name.setText(employee.getId());
        holder.location.setText(employee.getFirstName());
        holder.branch.setText(employee.getLastName());

    }


    @Override
    public int getItemCount() {
        return employeeList.size();
    }
}
