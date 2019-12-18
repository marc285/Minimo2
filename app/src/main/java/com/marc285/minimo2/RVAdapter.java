package com.marc285.minimo2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVViewHolder> {

    //DATA

    public RVAdapter() {
        //this.data = param;
    }

    @NonNull
    @Override
    public RVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        return new RVViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RVViewHolder holder, int position) {
        //holder.viewname
    }

    @Override
    public int getItemCount() {
        return 0;
        //return data.size();
    }

    public class RVViewHolder extends RecyclerView.ViewHolder {

        //Views contained in each RecyclerView item

        public RVViewHolder(@NonNull View itemView) {
            super(itemView);

            //findViewById() of the previous views
        }
    }
}
