package com.fakevk.fakevk.person;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fakevk.fakevk.R;
import com.fakevk.fakevk.VKRequestHelper;
import com.squareup.picasso.Picasso;

public class PersonActivity extends AppCompatActivity{
       public int currentId;
       public Context context;
       public int myId;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        SharedPreferences settings = getSharedPreferences("UserInfo", 0);
        currentId=settings.getInt("currentId", 0);
        myId=settings.getInt("myId", 0);
       setLayout();
        //MyApplication app=(MyApplication) getApplicationContext();
        VKRequestHelper.setPersonalPage(this,currentId);


    }
    protected void onResume(){
        super.onResume();
        VKRequestHelper.setClick((View)findViewById(R.id.followersLinear),currentId,context);
        VKRequestHelper.setClick((View)findViewById(R.id.friendsLinear),currentId,context);


    }
    void setLayout(){
        if (currentId==myId)
            setContentView(R.layout.person);
        else
            setContentView(R.layout.person_stranger);
    }
    public void setPersonalPage(Person person) {
        loadedImage(person.photo_max);
        setFIO (person.first_name+"  "+person.last_name);
        setCity(person.city.title);
        setFriends(person.counters.friends);
        setOnline(person.online);
        setStatus(person.status);
//        setStudies(person.universities.name);
        setFollowers(person.counters.followers);

    }
    public void loadedImage (String photo){
        Picasso.with(this)
                .load(photo)
                .into((ImageView) findViewById(R.id.avatar));
    }
    public void setFIO (String FIO){
        TextView fioTextView = findViewById(R.id.FIO);
        fioTextView.setText(FIO);
    }
    public void setOnline (String online){
        TextView Online = findViewById(R.id.online);
        if (online == "1") {
            Online.setText("online");
        }else {Online.setText("online");}

    }
    public void setStatus (String status){
        TextView Status = findViewById(R.id.status);
        if(status!=null)
            Status.setText(status);
    }
    public void setFriends (int friends){
        TextView Friends = findViewById(R.id.friends);
        Friends.setText(friends + "  друзей");
    }
    public void setFollowers (int subscriber){
        TextView Subscriber = findViewById(R.id.subscriber);
        Subscriber.setText(subscriber + "  подписчика");
    }
    public void setCity (String city){
        TextView City = findViewById(R.id.city);
        City.setText("Город:  " + city);
    }
    public void setStudies (String name){
        TextView Studies = findViewById(R.id.studies);
        Studies.setText("Место учёбы:  "+name);
    }



}
