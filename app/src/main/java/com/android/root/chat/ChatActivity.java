package com.android.root.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    private List<MessageData> data;
    private MessageAdapter adapter;
    private ListView lv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        data = this.getListData();
        adapter = new MessageAdapter(data, getApplicationContext());
        lv = (ListView) findViewById(R.id.messages_view);
        lv.setAdapter(adapter);
    }

    public List<MessageData> getListData() {
        List<MessageData> list = new ArrayList<MessageData>();
        list.add(new MessageData(true, "ê", "Tien", "cartoon"));
        list.add(new MessageData(false, "nghe nè :)", "", ""));
        list.add(new MessageData(true, "bấm máy tính mod casio sao dạ?", "Tien", "cartoon"));
        list.add(new MessageData(false, "ko biết", "", ""));
        list.add(new MessageData(false, "để kiếm cho", "", ""));
        list.add(new MessageData(true, "ờ", "Tien", "cartoon"));
        list.add(new MessageData(true, "mà thôi khỏi", "Tien", "cartoon"));
        list.add(new MessageData(false, "nè", "", ""));
        list.add(new MessageData(false, "https://www.youtube.com/watch?v=pzCOUQMSr8E", "", ""));
        list.add(new MessageData(true, ":)", "Tien", "cartoon"));
//        list.add(new MessageData(true, "ê", "Funny", "funny"));
//        list.add(new MessageData(false, "hả", "", ""));
        return list;
    }
}
