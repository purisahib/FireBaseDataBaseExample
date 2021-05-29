package com.pradeep.fireapp;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

public class FireApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //FirebaseDatabase.setAndroidContext(FireApp.this);
    }
}
