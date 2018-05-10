package com.android.root.chat;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 04/27/18.
 */

public class Group extends Fragment {
    private List<ManyFriends> data;
    private ManyFriendsAdapter adapter;
    private GridView gv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.group, container, false);
        FloatingActionButton fab = rootView.findViewById(R.id.fabaddgroup);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Thêm Nhóm Bạn Bè", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        data = this.getListData();
        adapter = new ManyFriendsAdapter(data, rootView.getContext());
        gv = rootView.findViewById(R.id.gridView);
        gv.setAdapter(adapter);
        return rootView;
    }

    public List<ManyFriends> getListData() {
        List<ManyFriends> list = new ArrayList<ManyFriends>();
        list.add(new ManyFriends("Tien", "cartoon"));
        list.add(new ManyFriends("Panda", "panda"));
        list.add(new ManyFriends("Seal", "seal"));
        list.add(new ManyFriends("Cap", "caps"));
        list.add(new ManyFriends("Spider", "spider"));
        list.add(new ManyFriends("Bird", "bird"));
        return list;
    }
}
