package com.example.matteo.firebase_recycleview;


import org.parceler.Parcel;

/**
 * Created by Matteo on 24/08/2015.
 */
@Parcel
public class MyItem {

    String name;
    long age;

    public MyItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }
}
