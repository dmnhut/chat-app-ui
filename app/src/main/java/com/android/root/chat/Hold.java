package com.android.root.chat;

import java.util.ArrayList;

public class Hold {
    public static int clicked = 0;
    public static String user[] = {"ND", "1"};
    public static String message = "Tin Nhắn";
    public static String active = "Hoạt Động";
    public static String group = "Nhóm";

    public static ArrayList<DataModel> getDataModels() {
        ArrayList<DataModel> dataModels = new ArrayList<>();
        dataModels.add(new DataModel("Tien", "cartoon", "về r á", "April 30, 2018"));
        dataModels.add(new DataModel("Funny", "funny", "đói quá", "April 30, 2018"));
        dataModels.add(new DataModel("Go", "go", "hiểu ko?", "April 30, 2018"));
        dataModels.add(new DataModel("Grumpy", "grumpy", "chào", "April 30, 2018"));
        dataModels.add(new DataModel("Cat", "cat", "nói chơi hà", "April 30, 2018"));
        dataModels.add(new DataModel("Mischievous", "mischievous", "buồn ngủ quá!", "April 30, 2018"));
        dataModels.add(new DataModel("Relaxing", "relaxing", "hả", "April 30, 2018"));
        dataModels.add(new DataModel("Running", "running", "chi dị?", "April 30, 2018"));
        dataModels.add(new DataModel("Smile", "smile", "nhớ đi nha", "April 30, 2018"));
        dataModels.add(new DataModel("Transfer", "transfer", "cafe nè?", "April 30, 2018"));
        return dataModels;
    }
}
