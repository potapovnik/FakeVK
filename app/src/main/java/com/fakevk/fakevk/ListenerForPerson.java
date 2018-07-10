package com.fakevk.fakevk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;

import com.fakevk.fakevk.friends.Friends;
import com.fakevk.fakevk.friends.FriendsActivity;
import com.fakevk.fakevk.person.PersonActivity;

import static android.support.v4.content.ContextCompat.startActivity;

public class ListenerForPerson  implements View.OnClickListener {

    public ListenerForPerson(int id,Context context) {
        this.id=id;
        this.context=context;
    }
       Context context;
       int id;

    @Override
    public void onClick(View v)
    {
        switch (v.getId()){
            case R.id.statusLinear:;break;
            case R.id.friendsLinear:{
                Intent friendsActivity= new Intent(context, FriendsActivity.class);
                context.startActivity(friendsActivity);
            };break;
            case R.id.friendsLinearStranger:;break;
            case R.id.followersLinear:;break;
            case R.id.followersLinearStranger:;break;

        }
    }

};
