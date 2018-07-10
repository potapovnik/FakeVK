package com.fakevk.fakevk.friends;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.fakevk.fakevk.R;
import com.fakevk.fakevk.person.PersonActivity;

public class ClickOnItemFriendsOnScroll  implements AdapterView.OnItemClickListener {

    public ClickOnItemFriendsOnScroll(int id, Context context,ArrayFriendsOnScroll arrayFriends) {
        this.id = id;
        this.context = context;
        this.arrayFriends=arrayFriends;
    }

    Context context;
    int id;
    ArrayFriendsOnScroll arrayFriends;

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
