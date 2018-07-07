package com.fakevk.fakevk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;

public class Person extends AppCompatActivity {
    DataPerson MyPerson;
    ImageView avatar;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person);
        VKRequestHelper.setPersonalPage(this);


    }

    public void loadedImage(String photo){
        Picasso.with(this)
                .load(photo)
                .into((ImageView) findViewById(R.id.avatar));
    }
    public void setFIO(String FIO){
        TextView fioTextView=findViewById(R.id.FIO);
        fioTextView.setText(FIO);
    }
    public void setOnline(String online){
        TextView Online=findViewById(R.id.online);
        if(online=="1"){
            Online.setText("online");
        }
        
    }
    public void setStatus(String status){
        Button Status=findViewById(R.id.status);
        Status.setText(status);
    }
    public void setFriends(String friends){
        Button Friends=findViewById(R.id.friends);
        Friends.setText(friends+"  друзей");
    }
    public void setSubscriber(String subscriber){
        Button Subscriber=findViewById(R.id.subscriber);
        Subscriber.setText(subscriber+"  подписчика");
    }
    public void setCity(String city){
        TextView City=findViewById(R.id.city);
        City.setText("Город:  "+city);
    }
    public void setStudies(String studies){
        TextView Studies=findViewById(R.id.studies);
        Studies.setText(studies);
    }

}
