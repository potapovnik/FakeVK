package com.fakevk.fakevk.friends_followers.friends;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import com.fakevk.fakevk.R;
import com.fakevk.fakevk.VKRequestHelper;
import com.fakevk.fakevk.friends_followers.AdapterFriendsFollowers;
import com.fakevk.fakevk.friends_followers.FriendsFollowers;
import com.fakevk.fakevk.friends_followers.ListFriendsFollowers;

import java.util.List;

public class FriendsActivity extends AppCompatActivity  {
    public int currentId;
    int myId;
    public Context context;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences settings = getSharedPreferences("UserInfo", 0);
        currentId=settings.getInt("currentId", 0);
        myId=settings.getInt("myId", 0);
        setLayout();
        VKRequestHelper.setFriendsPage(this,currentId);
        VKRequestHelper.setFriendsOnScroolPage(this,Integer.toString(currentId));

    }
    protected void onResume(){
        super.onResume();
        context=this;


    }
    void setLayout(){
        if (currentId==myId)
            setContentView(R.layout.friends);
        else
            setContentView(R.layout.friends_stranger);
    }
    public void setFriendsPage(Friends friends){
        setOnlineFriends(friends.getCounters().getOnline_friends());
        setFriends(friends.getCounters().getFriends());

        }
    public void setOnlineFriends(int followers){
        Button Friends = findViewById(R.id.network);
        Friends.setText(followers + "  В СЕТИ");
    }
    public void setFriends(int friends){
        Button Friends = findViewById(R.id.friends);
        Friends.setText(friends + "  Друзей");
    }
    public void setFriendsOnScroll(ListFriendsFollowers listFriendsFollowers){
        List<FriendsFollowers> friendsFollowers = listFriendsFollowers.items;
        AdapterFriendsFollowers friendsAdapter= new AdapterFriendsFollowers(this, friendsFollowers);;
        ListView lvfriends = (ListView) findViewById(R.id.friendsOnScroll);
        lvfriends.setAdapter(friendsAdapter);
        ClickOnItemFriendsOnScroll listener=new ClickOnItemFriendsOnScroll(context, listFriendsFollowers);
        lvfriends.setOnItemClickListener(listener);
    }
}
