package com.example.resepify;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ListViewHolder> {
    public static Object setOnClick;
    private ArrayList<ListData> listData;
    public DataAdapter(ArrayList<ListData> list){
        this.listData = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(view);
    }
    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onBindViewHolder(@NonNull final DataAdapter.ListViewHolder holder, int position) {
        ListData data = listData.get(position);
        holder.recepiName.setText(data.getRecipe_name());
        holder.recepiTime.setText(data.getRecipe_time());
        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(listData.get(holder.getAdapterPosition())));
    }
    public interface OnItemClickCallback{
        void onItemClicked(ListData data);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

   class ListViewHolder extends RecyclerView.ViewHolder {
        TextView recepiName, recepiTime;
        ListViewHolder(View itemView) {
            super(itemView);
            recepiName = itemView.findViewById(R.id.recipe_name);
            recepiTime = itemView.findViewById(R.id.recipe_time);
        }
    }
}
