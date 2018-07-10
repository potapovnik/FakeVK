package com.fakevk.fakevk.friends;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.fakevk.fakevk.R;
import com.fakevk.fakevk.VKRequestHelper;

import java.util.ArrayList;
import java.util.List;

public class FriendsActivity extends AppCompatActivity  {
    public int currentId;
    public Context context;
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Intent friendsActivity=getIntent();
             SharedPreferences settings = getSharedPreferences("UserInfo", 0);
            currentId=settings.getInt("currentId", 0);
            setLaout();
            VKRequestHelper.setFriendsPage(this,currentId);
            VKRequestHelper.setFriendsOnScroolPage(this,Integer.toString(currentId));

    }
    protected void onResume(){
        super.onResume();
        context=this;


    }

    public void setLaout(){
        int myId;
        SharedPreferences settings = getSharedPreferences("UserInfo", 0);
        myId=settings.getInt("myId", 0);
        if(currentId==myId)
            setContentView(R.layout.friends);
        else
            setContentView(R.layout.stranger_friends);
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
    public void setFriendsOnScroll(ArrayFriendsOnScroll arrayFriendsOnScroll){
        List<FriendsOnScroll> friendsOnScrolls = arrayFriendsOnScroll.items;
        AdapterForFriends friendsAdapter= new AdapterForFriends(this, friendsOnScrolls);;
        ListView lvfriends = (ListView) findViewById(R.id.friendsOnScroll);
        lvfriends.setAdapter(friendsAdapter);
        ClickOnItemFriendsOnScroll listener=new ClickOnItemFriendsOnScroll(currentId,context,arrayFriendsOnScroll);
        lvfriends.setOnItemClickListener(listener);
    }
}
