package com.example.dynamicapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class RowDataAdapterList extends RecyclerView.Adapter<RowDataAdapterList.RowDataListView> {
    private static final String TAG = "AdapterList";
    ArrayList<Option> list = new ArrayList<>();
    OptionListListener listener;

    public RowDataAdapterList(ArrayList<Option> list, OptionListListener listener) {
        this.list = list;
        this.listener = listener;
    }

    public class RowDataListView extends RecyclerView.ViewHolder {

        TextView textOptionList, textOptionStatus;

        public RowDataListView(@NonNull View itemView) {
            super(itemView);

            textOptionList = (TextView) itemView.findViewById(R.id.textOptionList);
            textOptionStatus = (TextView) itemView.findViewById(R.id.textOptionStatus);

        }
    }

    @NonNull
    @Override
    public RowDataListView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_data_option, parent, false);

        return new RowDataListView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowDataListView holder, int position) {
        Option option = list.get(position);

        holder.textOptionList.setText(option.getOptionText());
        holder.textOptionStatus.setText(option.getOptionStatus());

        holder.textOptionList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onNoteClicked(option);
            }
        });
        
        Log.i(TAG, option.getOptionText());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}