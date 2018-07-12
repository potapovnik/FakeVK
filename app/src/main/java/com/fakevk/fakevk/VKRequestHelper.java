package com.fakevk.fakevk;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.fakevk.fakevk.friends_followers.followers.FollowersActivity;
import com.fakevk.fakevk.friends_followers.ListFriendsFollowers;
import com.fakevk.fakevk.friends_followers.friends.Friends;
import com.fakevk.fakevk.friends_followers.friends.FriendsActivity;
import com.fakevk.fakevk.person.ArrayPerson;
import com.fakevk.fakevk.person.PersonActivity;
import com.google.gson.Gson;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class VKRequestHelper {
    public static void  setPersonalPage(final PersonActivity personActivity,int id) {
        int idUser=id;
        VKRequest user = VKApi.users().get(VKParameters.from(VKApiConst.USER_IDS, idUser,VKApiConst.FIELDS, "first_name , last_name, online, city, status, photo_max,status, counters"));

        user.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                ArrayPerson obj = new Gson().fromJson(response.responseString, ArrayPerson.class);
                personActivity.setPersonalPage(obj.response.get(0));
                Log.d("rrrrrrrr", ""+response.json);
            }

            @Override
            public void onError(VKError error) {
//Do error stuff
            }

            @Override
            public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {
//I don't really believe in progress
            }
        });

    }

    public static void  setFriendsPage(final FriendsActivity friendsActivity,int id) {
        int idUser=id;
        VKRequest user = VKApi.users().get(VKParameters.from(VKApiConst.USER_IDS, idUser,VKApiConst.FIELDS, "counters"));
        user.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                JSONArray myResponse=response.json.optJSONArray("response");
                JSONObject myObjResponse=myResponse.optJSONObject(0);
                Friends friends=new Gson().fromJson(String.valueOf(myObjResponse),Friends.class);
                friendsActivity.setFriendsPage(friends);

                Log.d("rrrrrrrr", ""+friends.getCounters().getFriends());

            }

            @Override
            public void onError(VKError error) {
//Do error stuff
            }

            @Override
            public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {
//I don't really believe in progress
            }
        });

    }
    public static void  setFriendsOnScroolPage(final FriendsActivity friendsActivity,String id) {
        String idUser=id;
        VKRequest user = new VKRequest("friends.get", VKParameters.from(VKApiConst.USER_ID,idUser, VKApiConst.FIELDS, "first_name, last_name, photo_50, id"));
        user.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                Log.d("aaaaaaaaaaaaa", ""+response.json);
                JSONObject myResponse=response.json.optJSONObject("response");;
                ListFriendsFollowers items=new Gson().fromJson(String.valueOf(myResponse), ListFriendsFollowers.class);
                friendsActivity.setFriendsOnScroll(items);



            }

            @Override
            public void onError(VKError error) {
//Do error stuff
            }

            @Override
            public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {
//I don't really believe in progress
            }
        });

    }
    public static void  setFollowersOnScroolPage(final FollowersActivity followersActivity,String id) {
        String idUser = id;
        VKRequest user = VKApi.users().getFollowers(VKParameters.from(VKApiConst.USER_ID, idUser, VKApiConst.FIELDS, "first_name, last_name, photo_50"));
        user.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                Log.d("bbbbbbbbbbb", "" + response.json);
                JSONObject myResponse = response.json.optJSONObject("response");
                ListFriendsFollowers items = new Gson().fromJson(String.valueOf(myResponse), ListFriendsFollowers.class);
                if (items!=null)
                followersActivity.setFollowersOnScroll(items);
            }

            @Override
            public void onError(VKError error) {
//Do error stuff
            }

            @Override
            public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {
//I don't really believe in progress
            }
        });
    }
    public static void setClick(View v, int id, final Context context){
        View.OnClickListener myListener=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.statusLinear:;break;
                    case R.id.friendsLinear:{
                        Intent friendsActivity= new Intent(context, FriendsActivity.class);
                        context.startActivity(friendsActivity);
                    };break;
                    case R.id.followersLinear:
                        Intent followersActivity= new Intent(context, FollowersActivity.class);
                        context.startActivity(followersActivity);;break;

                }

            }
        };
        v.setOnClickListener(myListener);
    }
    public static void setClickOnItem(){}
}
