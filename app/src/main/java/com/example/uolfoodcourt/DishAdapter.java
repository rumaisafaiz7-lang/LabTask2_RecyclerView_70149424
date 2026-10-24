package com.example.uolfoodcourt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private final ArrayList<Dish> dishes;
    private OnItemClickListener listener;

    public DishAdapter(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class DishViewHolder extends RecyclerView.ViewHolder {
        ImageView imgDish;
        TextView tvName;
        TextView tvPrice;

        public DishViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            imgDish = itemView.findViewById(R.id.imgDish);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);

            itemView.setOnClickListener(v -> {
                int position = getBindingAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(position);
                }
            });
        }
    }

    @NonNull
    @Override
    public DishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dish, parent, false);
        return new DishViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull DishViewHolder holder, int position) {
        Dish dish = dishes.get(position);
        holder.imgDish.setImageResource(dish.getImageResId());
        holder.tvName.setText(dish.getName());
        holder.tvPrice.setText("Rs. " + dish.getPrice());
    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }
}