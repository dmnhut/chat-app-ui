package com.android.root.chat;

public class MessageData {
    public boolean left;
    public String message;
    public String name;
    public String img;

    public MessageData(boolean left, String message, String name, String img) {
        this.left = left;
        this.message = message;
        this.name = name;
        this.img = img;
    }
}
