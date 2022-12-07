package com.dl.twosignal.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dl.twosignal.R;
import com.dl.twosignal.models.DataModel;

import java.util.List;

public class DevicesAdapterOne extends RecyclerView.Adapter<DevicesAdapterOne.CategoryViewHolder> {
    private Context context;
    private int itensCount = 0;
    private List<DataModel> categoryModels;

    public DevicesAdapterOne(Context context, List<DataModel> categoryModels) {
        this.context = context;
        this.categoryModels = categoryModels;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        holder.itemView.setTag(categoryModels.get(position));
        DataModel cat = categoryModels.get(position);

        holder.txtName.setText(cat.getName());
        holder.txtType.setText(cat.getType());
        holder.txtVersion.setText(cat.getVersion_number());

    }

    @Override
    public int getItemCount() {
        return categoryModels.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName;
        public TextView txtType;
        public TextView txtVersion;
        public Button maisInfo;

        public CategoryViewHolder(View itemView) {
            super(itemView);

            maisInfo = (Button) itemView.findViewById(R.id.btn_info);
            txtName = (TextView) itemView.findViewById(R.id.name);
            txtType = (TextView) itemView.findViewById(R.id.type);
            txtVersion = (TextView) itemView.findViewById(R.id.version_number);

        }
    }
}
