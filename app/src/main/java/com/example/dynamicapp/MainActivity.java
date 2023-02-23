package com.example.dynamicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout layoutList;
    private Button btnAdd, btnSubmit;
    private List<String> stringList= new ArrayList<>();
    private List<String> stringListOption = new ArrayList<>();
    private ArrayList<RowData> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutList = findViewById(R.id.layoutList);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (readData()) {
                    Intent intent = new Intent(MainActivity.this, ActivityResult.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("list", list);
                    intent.putExtras(bundle);
                    startActivity(intent);
                };
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addView();
            }
        });

        stringList.add("Choose option");
        stringList.add("1st option");
        stringList.add("2nd option");
        stringList.add("3rd option");

        stringListOption.add("False");
        stringListOption.add("True");
    }

    private boolean readData() {

        boolean result = true;
        boolean resultOption;
        boolean sameOptions = false;

        list.clear();

        for(int i=0; i < layoutList.getChildCount(); i++) {
            resultOption = false;

            View view = layoutList.getChildAt(i);

            EditText editText = (EditText) view.findViewById(R.id.editText);
            AppCompatSpinner spinner = (AppCompatSpinner) view.findViewById(R.id.spinner);
            LinearLayout listOption = (LinearLayout) view.findViewById(R.id.layoutListOptions);

            RowData rowData = new RowData();

            if (!editText.getText().toString().equals(null)) {
                rowData.setQuestion(editText.getText().toString());
            } else {
                result = false;
                break;
            }

            if (spinner.getSelectedItemPosition() != 0) {
                rowData.setOption(stringList.get(spinner.getSelectedItemPosition()));
            } else {
                result = false;
                break;
            }

            ArrayList<Option> listOfOptions= new ArrayList<>();

            for(int n=0; n < listOption.getChildCount(); n++) {

                View viewOption = listOption.getChildAt(n);

                EditText editTextOption = (EditText) viewOption.findViewById(R.id.editTextOption);
                AppCompatSpinner spinnerOption = (AppCompatSpinner) viewOption.findViewById(R.id.spinnerOptions);

                Option optionModel = new Option();

                if (!editTextOption.getText().toString().equals(null)) {
                    optionModel.setOptionText(editTextOption.getText().toString());
                } else {
                    result = false;
                    break;
                }

                if (spinnerOption.getSelectedItemPosition() == 1) {
//                    if they are at least one true answer
                    resultOption = true;
                }

                optionModel.setOptionStatus(stringListOption.get(spinnerOption.getSelectedItemPosition()));

                listOfOptions.add(optionModel);
            }

            if (!resultOption) {
                sameOptions = true;
            }

            if(!sameOptions) {
                rowData.setOptionList(listOfOptions);
            }

            list.add(rowData);
        }

        if(list.size()==0) {
            result = false;
            Toast.makeText(this, "Add at least one", Toast.LENGTH_SHORT).show();
        } else if (!result) {
            Toast.makeText(this, "Enter valid data", Toast.LENGTH_SHORT).show();
        } else if (sameOptions) {
            result = false;
            Toast.makeText(this, "There must be at least one correct answer", Toast.LENGTH_SHORT).show();
        }

        //Toast.makeText(this, "Sending", Toast.LENGTH_SHORT).show();

        return result;
    }

    private void addView() {
        View view = getLayoutInflater().inflate(R.layout.row_add, null, false);

        EditText editText = (EditText) view.findViewById(R.id.editText);
        AppCompatSpinner spinner = (AppCompatSpinner) view.findViewById(R.id.spinner);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageRemove);

//        Add option
        Button btnAddOption = (Button) view.findViewById(R.id.btnAddOption);

        ArrayAdapter adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, stringList);
        spinner.setAdapter(adapter);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeView(view);
            }
        });

        btnAddOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout layoutListOptions = (LinearLayout) view.findViewById(R.id.layoutListOptions);
                addViewOption(layoutListOptions);
            }
        });

        layoutList.addView(view);
    }

    private void removeView(View view) {

        layoutList.removeView(view);

    }

    private void addViewOption(LinearLayout layoutListOptions) {
        View viewOption = getLayoutInflater().inflate(R.layout.row_option, null, false);

        AppCompatSpinner spinner = (AppCompatSpinner) viewOption.findViewById(R.id.spinnerOptions);
        ImageView imageView = (ImageView) viewOption.findViewById(R.id.imageRemoveOption);


        ArrayAdapter adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, stringListOption);
        spinner.setAdapter(adapter);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeViewOption(layoutListOptions, viewOption);
            }
        });

        layoutListOptions.addView(viewOption);
    }

    private void removeViewOption(LinearLayout layoutList, View view) {
        layoutList.removeView(view);
    }

    @Override
    public void onClick(View v) {

    }
}