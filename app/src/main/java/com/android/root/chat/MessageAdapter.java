package com.android.root.chat;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageAdapter extends BaseAdapter {
    private List<MessageData> messages = new ArrayList<MessageData>();
    private Context context;
    private LayoutInflater layoutInflater;

    public MessageAdapter(List<MessageData> messages, Context context) {
        this.messages = messages;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public MessageData getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        MessageData messageData = getItem(position);
        if (convertView == null) {
            if (messageData.left) {
                convertView = layoutInflater.inflate(R.layout.their_message, null);
            } else {
                convertView = layoutInflater.inflate(R.layout.my_message, null);
            }
            holder = new Holder();
            holder.img = (CircleImageView) convertView.findViewById(R.id.avatar);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.message = (TextView) convertView.findViewById(R.id.message_body);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        MessageData data = this.messages.get(position);
        holder.name.setText(data.name);
        int img = this.getImgResIdByName(data.img);
        holder.img.setImageResource(img);
        holder.message.setText(data.message);
        return convertView;
    }

    static class Holder {
        TextView message;
        TextView name;
        CircleImageView img;
    }

    public int getImgResIdByName(String name) {
        String pkgName = context.getPackageName();
        int resId = context.getResources().getIdentifier(name, "drawable", pkgName);
        Log.i("MessageAdapter", "Res Name: " + name + " ==> Res ID = " + resId);
        return resId;
    }
}
