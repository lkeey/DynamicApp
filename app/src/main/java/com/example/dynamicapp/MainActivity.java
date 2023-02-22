package com.example.dynamicapp;

import static com.example.dynamicapp.R.id.btnAdd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layoutList;
    private Button btnAdd;
    private List<String> stringList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutList = findViewById(R.id.layoutList);
        btnAdd = findViewById(R.id.btnAdd);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addView();
            }
        });


        stringList.add("1st option");
        stringList.add("2nd option");
        stringList.add("3rd option");


    }

    private void addView() {
        View view = getLayoutInflater().inflate(R.layout.row_add, null, false);

        EditText editText = (EditText) view.findViewById(R.id.editText);
        AppCompatSpinner spinner = (AppCompatSpinner) view.findViewById(R.id.spinner);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageRemove);

        ArrayAdapter adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, stringList);
        spinner.setAdapter(adapter);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeView(view);
            }
        });

        layoutList.addView(view);
    }

    private void removeView(View view) {

        layoutList.removeView(view);


    }
}