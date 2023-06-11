package com.devderive.todotodo;

// MainActivity.java
import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextTask = findViewById(R.id.editTextTask);
        ListView listViewTasks = findViewById(R.id.listViewTasks);
        Button buttonAdd = findViewById(R.id.buttonAdd);

        ArrayList<String> tasks = new ArrayList<>();
        ArrayAdapter<String> tasksAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        listViewTasks.setAdapter(tasksAdapter);

        buttonAdd.setOnClickListener(view -> {
            String task = editTextTask.getText().toString().trim();
            if (!task.isEmpty()) {
                tasks.add(task);
                tasksAdapter.notifyDataSetChanged();
                editTextTask.setText("");
            }
        });

        listViewTasks.setOnItemClickListener((parent, view, position, id) -> {
            tasks.remove(position);
            tasksAdapter.notifyDataSetChanged();
        });
    }
}

