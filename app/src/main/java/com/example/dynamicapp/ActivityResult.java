package com.example.dynamicapp;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivityResult extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<RowData> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        list = (ArrayList<RowData>) getIntent().getExtras().getSerializable("list");

        Toast.makeText(this, list.get(0).getOptionList().get(0).optionText.toString(), Toast.LENGTH_SHORT).show();

        recyclerView.setAdapter(new RowDataAdapter(list, ActivityResult.this));

    }
}
