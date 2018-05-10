package com.android.root.chat;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FriendAdapter extends BaseAdapter {
    private int lastPosition = -1;
    private List<Friend> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    static class ViewHolder {
        CircleImageView face;
        ImageView active;
        TextView name;
    }

    public FriendAdapter(List<Friend> listData, Context context) {
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
        ViewHolder viewHolder;
        final View result;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.active_item, null);
            viewHolder = new ViewHolder();
            viewHolder.face = (CircleImageView) view.findViewById(R.id.imgActive);
            viewHolder.active = (ImageView) view.findViewById(R.id.active);
            viewHolder.name = (TextView) view.findViewById(R.id.txtActive);
            result = view;
            view.setTag(viewHolder);
        } else {
            result = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        Animation animation = AnimationUtils.loadAnimation(context, (i > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = i;
        Friend friend = this.listData.get(i);
        viewHolder.name.setText(friend.name);
        int imgID = this.getMipmapResIdByName(friend.face);
        viewHolder.face.setImageResource(imgID);
        viewHolder.active.setImageResource(R.drawable.green);
        return view;
    }

    public int getMipmapResIdByName(String resName) {
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(resName, "drawable", pkgName);
        Log.i("FriendAdapter", "Res Name: " + resName + " ==> Res ID = " + resID);
        return resID;
    }
}
