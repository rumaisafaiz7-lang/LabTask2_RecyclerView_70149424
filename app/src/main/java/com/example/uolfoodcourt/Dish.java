package com.example.uolfoodcourt;

public class Dish {
    private String name;
    private String category;
    private String description;
    private String stallPhone;
    private int price;
    private int imageResId;

    public Dish(String name, String category, String description,
                String stallPhone, int price, int imageResId) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.stallPhone = stallPhone;
        this.price = price;
        this.imageResId = imageResId;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public String getStallPhone() { return stallPhone; }
    public int getPrice() { return price; }
    public int getImageResId() { return imageResId; }
}