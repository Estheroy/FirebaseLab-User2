package com.android.lab7exercise_user2;

import com.firebase.client.Firebase;

/**
 * Created by XuanpeiEstherOuyang on 5/22/16.
 */
public class FirebaseContext extends android.app.Application{

    public void onCreate(){

        super.onCreate();
        Firebase.setAndroidContext(this);
    }

}
