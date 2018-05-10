package com.android.root.chat;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListFriends extends BaseAdapter {
    private int lastPosition = -1;
    private List<ManyFriends> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public ListFriends(List<ManyFriends> listData, Context context) {
        this.listData = listData;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int i) {
        return listData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ManyFriendsAdapter.Holder holder;
        final View result;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.one_friend, null);
            holder = new ManyFriendsAdapter.Holder();
            holder.circleImageView = (CircleImageView) view.findViewById(R.id.imgFriends);
            holder.textView = (TextView) view.findViewById(R.id.txtFriends);
            result = view;
            view.setTag(holder);
        } else {
            result = view;
            holder = (ManyFriendsAdapter.Holder) view.getTag();
        }
        Animation animation = AnimationUtils.loadAnimation(context, (i > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = i;
        ManyFriends manyFriends = this.listData.get(i);
        holder.circleImageView.setImageResource(this.getMipmapResIdByName(manyFriends.img));
        holder.textView.setText(manyFriends.name);
        return view;
    }

    public int getMipmapResIdByName(String resName) {
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(resName, "drawable", pkgName);
        Log.i("ManyFriendsAdapter", "Res Name: " + resName + " ==> Res ID = " + resID);
        return resID;
    }

    static class Holder {
        CircleImageView circleImageView;
        TextView textView;
    }
}
