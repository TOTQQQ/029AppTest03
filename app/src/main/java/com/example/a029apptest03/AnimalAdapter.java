package com.example.a029apptest03;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {

    private final List<String> names;
    private final List<Integer> images;

    public AnimalAdapter(List<String> names, List<Integer> images) {
        this.names = names;
        this.images = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_animal_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = names.get(position);
        holder.tvName.setText(name);
        holder.ivImage.setImageResource(images.get(position));

        holder.itemView.setOnClickListener(v ->
                Toast.makeText(v.getContext(), name, Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public void addItem(String name, int imageRes) {
        names.add(name);
        images.add(imageRes);
        notifyItemInserted(names.size() - 1);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvName;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.animal_image);
            tvName = itemView.findViewById(R.id.animal_name);
        }
    }
}
