package com.android.root.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by root on 04/27/18.
 */

public class Messages extends Fragment {
    public ArrayList<DataModel> dataModels;
    private CustomAdapter adapter;
    private ListView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.messages, container, false);
        FloatingActionButton fab = rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Viết Tin Nhắn Mới", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        dataModels = Hold.getDataModels();
        adapter = new CustomAdapter(dataModels, rootView.getContext());
        lv = rootView.findViewById(R.id.list);
        lv.setAdapter(adapter);
        if (Hold.clicked != 1) {
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    Intent intent = new Intent(rootView.getContext(), ChatActivity.class);
                    startActivity(intent);
                }
            });
        } else {
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                }
            });
        }
        return rootView;
    }
}
