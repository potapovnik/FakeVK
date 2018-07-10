package com.fakevk.fakevk.friends;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class Friends{
    public Counters getCounters() {
        return counters;
    }

    public void setCounters(Counters counters) {
        this.counters = counters;
    }

    Counters counters;
    public class Counters{
        int friends;
        int followers;
        int online_friends;

        public int getFriends() {
            return friends;
        }

        public void setFriends(int friends) {
            this.friends = friends;
        }

        public int getFollowers() {
            return followers;
        }

        public void setFollowers(int followers) {
            this.followers = followers;
        }

        public int getOnline_friends() {
            return online_friends;
        }

        public void setOnline_friends(int online_friends) {
            this.online_friends = online_friends;
        }
    }
}
