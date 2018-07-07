package com.fakevk.fakevk;

import android.app.Activity;
import android.util.Log;

import com.squareup.picasso.Picasso;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class VKRequestHelper {
    public static void  setPersonalPage(final Person person) {
        VKRequest user = VKApi.users().get(VKParameters.from(VKApiConst.USER_IDS, "vse_vi_mghazi",VKApiConst.FIELDS, "first_name, universities , last_name, online, city, status, photo_max,status, counters"));

        user.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                JSONArray Myresponse = response.json.optJSONArray("response");
                JSONObject Iuser = Myresponse.optJSONObject(0);
                JSONObject IuserCounters=Iuser.optJSONObject("counters");
                JSONObject City=Iuser.optJSONObject("city");

                person.loadedImage(Iuser.optString("photo_max"));
                person.setFIO(Iuser.optString("first_name")+" "+Iuser.optString("last_name"));
                person.setOnline(Iuser.optString("online"));
                person.setStatus(Iuser.optString("status"));
                person.setFriends(IuserCounters.optString("friends"));
                person.setSubscriber(IuserCounters.optString("subscriptions"));
                person.setCity(City.optString("title"));
                Log.d("rrrrrrrr", ""+response.json);
               // person.setStudies((IuserCounters.optJSONObject("education").optString("university_name")));
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
