package com.android.serverwarrior.learningfirebase;

import com.firebase.client.Firebase;

/**
 * Created by Server Warrior on 2/19/2016.
 */
public class LearningFirebase extends android.app.Application{
    @Override
    public void onCreate(){
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
