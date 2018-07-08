package com.fakevk.fakevk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class FriendsActivity extends AppCompatActivity  {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends);
        Button login=findViewById(R.id.login);
//        VKRequestHelper.setFriendsPage(this);
        VKRequestHelper.setFriendsOnScroolPage(this);
    }

/*   public void setFriendsPage(Friends friends){
        setOnlineFriends(friends.counters.online_friends);
        setFriends(friends.counters.friends);
        ArrayList<FriendsOnScroll> friendsOnScrolls = new ArrayList<FriendsOnScroll>();
        AdapterForFriends friendsAdapter= new AdapterForFriends(this, products);;
        fillData();
        ListView lvfriends = (ListView) findViewById(R.id.friendsOnScroll);
            lvfriends.setAdapter(friendsAdapter);
        // выводим информацию о корзине
        public void showResult(View v) {
            String result = "Товары в корзине:";
            for (Product p : boxAdapter.getBox()) {
                if (p.box)
                    result += "\n" + p.name;
            }
            Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        }
        }

        // генерируем данные для адаптера
    void fillData(ArrayList<FriendsOnScroll> friendsOnScrolls ) {
        for (int i = 1; i <= 20; i++) {
                friendsOnScrolls.
        }
    }*/


    public void setOnlineFriends(int followers){
        Button Friends = findViewById(R.id.network);
        Friends.setText(followers + "  В СЕТИ");
    }
    public void setFriends(int friends){
        Button Friends = findViewById(R.id.friends);
        Friends.setText(friends + "  Друзей");
    }
    public void setFriendsOnScroll(FriendsOnScroll friendsOnScroll){


    }
}
