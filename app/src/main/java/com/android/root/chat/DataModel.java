package com.android.root.chat;

public class DataModel {
    String name;
    String img;
    String text;
    String date;

    public DataModel(String name, String img, String text, String date) {
        this.name = name;
        this.img = img;
        this.text = text;
        this.date = date;

    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }
}
