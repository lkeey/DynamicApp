package com.example.dynamicapp;

import android.inputmethodservice.Keyboard;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RowDataAdapter extends RecyclerView.Adapter<RowDataAdapter.RowDataView> {


    ArrayList<RowData> list = new ArrayList<>();

    public RowDataAdapter(ArrayList<RowData> list) {
        this.list = list;
    }

    public class RowDataView extends RecyclerView.ViewHolder {
        TextView textQuestion, textOption;
        public RowDataView(@NonNull View itemView) {
            super(itemView);

            textQuestion = (TextView) itemView.findViewById(R.id.textQuestion);
            textOption = (TextView) itemView.findViewById(R.id.textOption);
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
        holder.textQuestion.setText(rowData.getQuestion());
        holder.textOption.setText(rowData.getOption());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
