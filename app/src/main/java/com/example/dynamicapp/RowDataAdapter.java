package com.example.dynamicapp;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import javax.sql.RowSetListener;

public class RowDataAdapter extends RecyclerView.Adapter<RowDataAdapter.RowDataView> {
    private static final String TAG = "DataAdapter";

    ArrayList<RowData> list = new ArrayList<>();
    Context context = null;
    OptionListListener listener;

    public RowDataAdapter(ArrayList<RowData> list, Context context, OptionListListener listener) {
        this.list = list;
        this.context = context;
        this.listener = listener;
    }


    public class RowDataView extends RecyclerView.ViewHolder {
        private TextView textQuestion, textOption;
        private RecyclerView listLayout;

        public RowDataView(@NonNull View itemView) {
            super(itemView);

            textQuestion = (TextView) itemView.findViewById(R.id.textQuestion);
            textOption = (TextView) itemView.findViewById(R.id.textOption);
            listLayout = (RecyclerView) itemView.findViewById(R.id.recyclerViewOption);

        }
    }


    @NonNull
    @Override
    public RowDataView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_data, parent, false);

        return new RowDataView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowDataView holder, int position) {
        RowData rowData = list.get(position);

        // List Options
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        holder.listLayout.setLayoutManager(layoutManager);

        holder.listLayout.setAdapter(new RowDataAdapterList(rowData.getOptionList(), listener));

        holder.textQuestion.setText(rowData.getQuestion());
        holder.textOption.setText(rowData.getOption());

        Log.i(TAG, rowData.getOptionList().toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}


