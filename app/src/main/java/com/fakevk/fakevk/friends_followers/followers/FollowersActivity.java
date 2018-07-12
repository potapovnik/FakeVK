package com.fakevk.fakevk.friends_followers.followers;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.fakevk.fakevk.R;
import com.fakevk.fakevk.VKRequestHelper;
import com.fakevk.fakevk.friends_followers.AdapterFriendsFollowers;
import com.fakevk.fakevk.friends_followers.ListFriendsFollowers;
import com.fakevk.fakevk.friends_followers.friends.ClickOnItemFriendsOnScroll;
import com.fakevk.fakevk.friends_followers.FriendsFollowers;

import java.util.List;

public class FollowersActivity extends AppCompatActivity {
    int currentId;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.followers);
        SharedPreferences settings = getSharedPreferences("UserInfo", 0);
        currentId=settings.getInt("currentId", 0);
        VKRequestHelper.setFollowersOnScroolPage(this,Integer.toString(currentId));
    }
    public void setFollowersOnScroll(ListFriendsFollowers listFriendsFollowers){
        List<FriendsFollowers> friendsFollowers = listFriendsFollowers.items;
        AdapterFriendsFollowers friendsAdapter= new AdapterFriendsFollowers(this, friendsFollowers);;
        ListView lvfriends = (ListView) findViewById(R.id.followersOnScroll);
        lvfriends.setAdapter(friendsAdapter);
        ClickOnItemFriendsOnScroll listener=new ClickOnItemFriendsOnScroll(this, listFriendsFollowers);
        lvfriends.setOnItemClickListener(listener);
    }
}
