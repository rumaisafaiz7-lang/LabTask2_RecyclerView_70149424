package com.example.uolfoodcourt;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DishAdapter.OnItemClickListener {

    private ArrayList<Dish> dishes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvMenu = findViewById(R.id.rvMenu);

        dishes = new ArrayList<>();
        dishes.add(new Dish("Chicken Biryani", "Rice", "Spicy chicken biryani with raita.", "03001234501", 350, R.drawable.biryani));
        dishes.add(new Dish("Zinger Burger", "Fast Food", "Crispy chicken zinger with sauce and fries.", "03001234502", 450, R.drawable.burger));
        dishes.add(new Dish("Chicken Karahi", "Desi", "Karahi with naan, cooked in tomatoes.", "03001234503", 900, R.drawable.karahi));
        dishes.add(new Dish("Club Sandwich", "Snacks", "Chicken club sandwich with egg and cheese.", "03001234504", 300, R.drawable.sandwich));
        dishes.add(new Dish("Fajita Pizza", "Fast Food", "Medium pizza with fajita chicken.", "03001234505", 1100, R.drawable.pizza));
        dishes.add(new Dish("Chicken Roll", "Snacks", "Paratha roll with chicken and chutney.", "03001234506", 200, R.drawable.roll));
        dishes.add(new Dish("French Fries", "Snacks", "Hot salted fries with ketchup.", "03001234507", 150, R.drawable.fries));
        dishes.add(new Dish("Doodh Patti Chai", "Drinks", "Hot tea made with fresh milk.", "03001234508", 80, R.drawable.chai));

        DishAdapter adapter = new DishAdapter(dishes);
        adapter.setOnItemClickListener(this);
        rvMenu.setLayoutManager(new GridLayoutManager(this, 2));
        rvMenu.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        Dish dish = dishes.get(position);

        Intent intent = new Intent(this, DishDetailActivity.class);
        intent.putExtra(DishDetailActivity.EXTRA_NAME, dish.getName());
        intent.putExtra(DishDetailActivity.EXTRA_CATEGORY, dish.getCategory());
        intent.putExtra(DishDetailActivity.EXTRA_DESCRIPTION, dish.getDescription());
        intent.putExtra(DishDetailActivity.EXTRA_PHONE, dish.getStallPhone());
        intent.putExtra(DishDetailActivity.EXTRA_PRICE, dish.getPrice());
        intent.putExtra(DishDetailActivity.EXTRA_IMAGE, dish.getImageResId());
        startActivity(intent);
    }
}