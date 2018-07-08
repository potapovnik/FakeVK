package com.fakevk.fakevk;

public class Person {
    int id;
    String first_name;
    String last_name;
    String photo_max;
    String online;
    String status;

    Counters counters;
    public class Counters{
        int friends;
        int followers;
        int online_friends;
    }
    Universities universities;
    public class Universities{
        String name;
    }
    City city;
    public class City{
        int id;
        String title;
    }

}
