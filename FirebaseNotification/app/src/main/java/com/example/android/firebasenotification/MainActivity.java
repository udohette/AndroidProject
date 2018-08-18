package com.example.android.firebasenotification;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;

/**Here in onResume() method we are registering the broadcast receivers. So that this activity gets the push messages and
 * registration id.

 displayFirebaseRegId() fetches the firebase registration id from shared preferences and displays it on the screen.
 This is just for your references, we don’t use the reg id any where in the app.
 Subscribing to Topic

 When you want to subscribe to any topic, subscribeToTopic() function can be used. When a client app subscribes to a
 new topic name (one that does not already exist for your Firebase project), a new topic of that name is created in FCM and
 any client can subsequently subscribe to it.
 FirebaseMessaging.getInstance().subscribeToTopic('news');
 Unsubscribing from Topic

 Similarly the client can unsubscribe from a topic by calling unsubscribeFromTopic() method.
 FirebaseMessaging.getInstance().unsubscribeFromTopic('news');*/

import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.common.ConnectionResult;
import com.google.firebase.messaging.FirebaseMessaging;

import app.Config;
import utils.NotificationUtils;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        


    }
}

