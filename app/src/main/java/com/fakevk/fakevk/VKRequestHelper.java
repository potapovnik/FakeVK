package com.fakevk.fakevk;

import android.util.Log;

import com.google.gson.Gson;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKUsersArray;

import org.json.JSONArray;
import org.json.JSONObject;

public class VKRequestHelper {
    public static void  setPersonalPage(final PersonActivity personActivity) {
        VKRequest user = VKApi.users().get(VKParameters.from(VKApiConst.USER_IDS, "vse_vi_mghazi",VKApiConst.FIELDS, "first_name, universities , last_name, online, city, status, photo_max,status, counters"));

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

    public static void  setFriendsPage(final FriendsActivity friendsActivity) {
        VKRequest user = VKApi.users().get(VKParameters.from(VKApiConst.USER_IDS, "vse_vi_mghazi",VKApiConst.FIELDS, "counters"));
        user.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                JSONArray myResponse=response.json.optJSONArray("response");
                JSONObject myObjResponse=myResponse.optJSONObject(0);
                Friends friends=new Gson().fromJson(String.valueOf(myObjResponse),Friends.class);
               // friendsActivity.setFriendsPage(friends);

                Log.d("rrrrrrrr", ""+friends.counters.followers);

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
    public static void  setFriendsOnScroolPage(final FriendsActivity friendsActivity) {
        VKRequest user = new VKRequest("friends.get", VKParameters.from(VKApiConst.USER_ID,495289337, VKApiConst.FIELDS, "first_name, last_name, photo_100"));
        user.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                Log.d("aaaaaaaaaaaaa", ""+response.json);
                JSONArray myResponse=response.json.optJSONArray("response");
                JSONObject myObjResponse=myResponse.optJSONObject(0);
                FriendsOnScroll friendsOnScroll=new Gson().fromJson(String.valueOf(myObjResponse),FriendsOnScroll.class);



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
}
