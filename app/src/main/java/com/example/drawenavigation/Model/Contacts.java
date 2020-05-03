package com.example.drawenavigation.Model;

public class Contacts {
    private String title;
    private String description;
    private int Image;

    public Contacts() {
    }

    public Contacts(String title, String description, int image) {
        this.title = title;
        this.description = description;
        Image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
