package com.android.root.chat;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListFriendsNav extends Fragment {
    private List<ManyFriends> data;
    private ListFriends adapter;
    private ListView lv;

    public static ListFriendsNav newInstance() {
        ListFriendsNav fragment = new ListFriendsNav();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_friends_nav, container, false);
        FloatingActionButton fab = rootView.findViewById(R.id.fabaddfriend);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Thêm Bạn Bè", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        data = this.getListData();
        adapter = new ListFriends(data, rootView.getContext());
        lv = rootView.findViewById(R.id.lvfriends);
        lv.setAdapter(adapter);
        return rootView;
    }

    public List<ManyFriends> getListData() {
        List<ManyFriends> list = new ArrayList<ManyFriends>();
        list.add(new ManyFriends("Tien", "cartoon"));
        list.add(new ManyFriends("Funny", "funny"));
        list.add(new ManyFriends("Go", "go"));
        list.add(new ManyFriends("Grumpy", "grumpy"));
        list.add(new ManyFriends("Cat", "cat"));
        list.add(new ManyFriends("Mischievous", "mischievous"));
        list.add(new ManyFriends("Relaxing", "relaxing"));
        list.add(new ManyFriends("Running", "running"));
        list.add(new ManyFriends("Smile", "smile"));
        list.add(new ManyFriends("Transfer", "transfer"));
        return list;
    }
}
