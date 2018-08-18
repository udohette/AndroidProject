package service;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import app.Config;

/**
 * Created by DENNIS on 3/21/2017.
 * This class receives the firebase registration id which will be unique to each app.
 * This registration id is needed when you want to send message to a single device.
 * You can send this token to your server app to send notification to devices later.

 onTokenRefresh() method will be called whenever there is a change in firebase registration id.

 storeRegIdInPref() stores the registration id in shared preferences.

 LocalBroadcastManager – Broadcast manager broadcasts the reg id to all the activities those are listening.
 */
public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService{

    @Override
    public void onTokenRefresh() {
        //Get Updated InstanceID Token
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("MyFireBaseId","refreshToken" + refreshedToken);

        //TODO: Implement this to send any registration your app's server
        //sendRegistrationToServer(refreshedToken);



    }
}
