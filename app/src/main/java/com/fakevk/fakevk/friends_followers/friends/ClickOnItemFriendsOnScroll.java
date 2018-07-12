package com.fakevk.fakevk.friends_followers.friends;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;

import com.fakevk.fakevk.friends_followers.ListFriendsFollowers;
import com.fakevk.fakevk.person.PersonActivity;

public class ClickOnItemFriendsOnScroll  implements AdapterView.OnItemClickListener {

    public ClickOnItemFriendsOnScroll( Context context,ListFriendsFollowers arrayFriends) {
        this.context = context;
        this.arrayFriends=arrayFriends;
    }

    Context context;
    ListFriendsFollowers arrayFriends;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent personActivity = new Intent(context, PersonActivity.class);
        SharedPreferences settings =context.getSharedPreferences("UserInfo", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("currentId",arrayFriends.items.get((int)id).id);
        editor.commit();
        context.startActivity(personActivity);
    }
}
