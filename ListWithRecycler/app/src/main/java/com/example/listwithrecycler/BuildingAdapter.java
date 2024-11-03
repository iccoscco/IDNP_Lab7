package com.example.listwithrecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class BuildingAdapter extends RecyclerView.Adapter<BuildingAdapter.ViewHolder> {
    private List<Building> buildingList;
    private List<Building> filteredList;

    public BuildingAdapter(List<Building> buildingList) {
        this.buildingList = buildingList;
        this.filteredList = new ArrayList<>(buildingList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_building, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Building building = filteredList.get(position);
        // Imagen, título, categoría y descripción
        holder.titleTextView.setText(building.getTitle());
        holder.categoryTextView.setText(building.getCategory());
        holder.descriptionTextView.setText(building.getDescription());
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    public void filter(String query) {
        filteredList.clear();
        if (query.isEmpty()) {
            filteredList.addAll(buildingList);
        } else {
            for (Building building : buildingList) {
                if (building.getTitle().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(building);
                }
            }
        }
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, categoryTextView, descriptionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            categoryTextView = itemView.findViewById(R.id.categoryTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        }
    }
}
