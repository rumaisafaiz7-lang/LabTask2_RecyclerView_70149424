package com.example.uolfoodcourt;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DishDetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_CATEGORY = "extra_category";
    public static final String EXTRA_DESCRIPTION = "extra_description";
    public static final String EXTRA_PHONE = "extra_phone";
    public static final String EXTRA_PRICE = "extra_price";
    public static final String EXTRA_IMAGE = "extra_image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_detail);

        Intent intent = getIntent();
        String name = intent.getStringExtra(EXTRA_NAME);
        String category = intent.getStringExtra(EXTRA_CATEGORY);
        String description = intent.getStringExtra(EXTRA_DESCRIPTION);
        String phone = intent.getStringExtra(EXTRA_PHONE);
        int price = intent.getIntExtra(EXTRA_PRICE, 0);
        int imageResId = intent.getIntExtra(EXTRA_IMAGE, 0);

        setTitle(name);

        ImageView imgDetail = findViewById(R.id.imgDetail);
        TextView tvName = findViewById(R.id.tvDetailName);
        TextView tvCategory = findViewById(R.id.tvDetailCategory);
        TextView tvPrice = findViewById(R.id.tvDetailPrice);
        TextView tvDescription = findViewById(R.id.tvDetailDescription);
        Button btnCall = findViewById(R.id.btnCall);

        imgDetail.setImageResource(imageResId);
        tvName.setText(name);
        tvCategory.setText("Category: " + category);
        tvPrice.setText("Rs. " + price);
        tvDescription.setText(description);

        btnCall.setOnClickListener(v -> {
            try {
                Intent dial = new Intent(Intent.ACTION_DIAL);
                dial.setData(Uri.parse("tel:" + phone));
                startActivity(dial);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(this, "No dialer app found", Toast.LENGTH_SHORT).show();
            }
        });
    }
}