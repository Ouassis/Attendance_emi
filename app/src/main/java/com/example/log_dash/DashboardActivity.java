package com.example.log_dash;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);



        android.widget.ListView listView = (android.widget.ListView) findViewById(R.id.listview);
        String[] classes = {"Deep Learning","Base de donnée","Développement Web","Computer Science","Programming Languages","Software Engineering","Operating Systems","Databases","Computer Networks","Computer Architecture","Artificial Intelligence","Human-Computer Interaction","Information Security"};
        int file = androidx.appcompat.R.layout.support_simple_spinner_dropdown_item;
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),file,classes);
        listView.setAdapter(adapter);


    }


}
