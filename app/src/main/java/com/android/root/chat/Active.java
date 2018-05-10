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

/**
 * Created by root on 04/27/18.
 */

public class Active extends Fragment {
    private List<Friend> data;
    private FriendAdapter adapter;
    private ListView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.active, container, false);
        FloatingActionButton fab = rootView.findViewById(R.id.fabsearch);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Tìm Bạn Bè", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        data = this.getListData();
        adapter = new FriendAdapter(data, rootView.getContext());
        lv = rootView.findViewById(R.id.lstActive);
        lv.setAdapter(adapter);
        return rootView;
    }

    public List<Friend> getListData() {
        List<Friend> list = new ArrayList<Friend>();
        list.add(new Friend("Tien", "cartoon", "active"));
        list.add(new Friend("Funny", "funny", "active"));
        list.add(new Friend("Go", "go", "active"));
        list.add(new Friend("Grumpy", "grumpy", "active"));
        list.add(new Friend("Cat", "cat", "active"));
        list.add(new Friend("Mischievous", "mischievous", "active"));
        list.add(new Friend("Relaxing", "relaxing", "active"));
        list.add(new Friend("Running", "running", "active"));
        list.add(new Friend("Smile", "smile", "active"));
        list.add(new Friend("Transfer", "transfer", "active"));
        return list;
    }
}
