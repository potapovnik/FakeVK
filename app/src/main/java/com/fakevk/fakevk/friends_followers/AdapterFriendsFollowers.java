package com.fakevk.fakevk.friends_followers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fakevk.fakevk.R;
import com.fakevk.fakevk.friends_followers.FriendsFollowers;
import com.squareup.picasso.Picasso;

import java.util.List;

 public  class AdapterFriendsFollowers extends BaseAdapter  {
    Context ctx;
    LayoutInflater lInflater;
    List<FriendsFollowers> objects;

  public AdapterFriendsFollowers(Context context, List<FriendsFollowers> friendsFollowers) {
        ctx = context;
        objects = friendsFollowers;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return objects.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.friends_on_scroll, parent, false);
        }

        FriendsFollowers p = FriendsOnScroll(position);
        ((TextView) view.findViewById(R.id.FIO)).setText(p.first_name+" "+p.last_name);
        Picasso.with(ctx)
                .load(p.photo_50)
                .into(((ImageView) view.findViewById(R.id.avatarOnScroll)));

        return view;
        
    }

  public FriendsFollowers FriendsOnScroll(int position) {
        return ((FriendsFollowers) getItem(position));
    }
}

