package com.example.listwithrecycler;

public class Building {
    private String image;
    private String title;
    private String category;
    private String description;

    public Building(String image, String title, String category, String description) {
        this.image = image;
        this.title = title;
        this.category = category;
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }
}

