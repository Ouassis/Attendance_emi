package com.example.log_dash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        android.widget.ListView listView = (android.widget.ListView) findViewById(R.id.listview);
        String[] classes = {"ELGAROUATE Abdessamad","EZ-ZAROUALY Mohammed","MAKKOUDI Chihab "};
        int file = androidx.appcompat.R.layout.support_simple_spinner_dropdown_item;
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),file,classes);
        listView.setAdapter(adapter);

        ImageView btn_record = findViewById(R.id.image_record);
        btn_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentActivity.this, QRCodeActivity.class));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Create an Intent to start the second activity
                Intent intent = new Intent(StudentActivity.this, StudentDetailActivity.class);

                // Add the selected item text as an extra to the Intent
                intent.putExtra("SELECTED_ITEM", selectedItem);

                // Start the new activity
                startActivity(intent);
            }
        });

    }
}
