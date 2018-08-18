package service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

import com.example.android.firebasenotification.MainActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import utils.NotificationUtils;

import static android.app.PendingIntent.FLAG_UPDATE_CURRENT;

/**
 * Created by DENNIS on 3/21/2017.
 * This class receives the firebase messages into onMessageReceived() method.
 * <p>
 * > When notification type message is sent, firebase automatically shows the notification when the app is in background.
 * If the app is in foreground, handleNotification() method handles the notification message.
 * <p>
 * > When data type message is sent, handleDataMessage() method is used to handle the
 * payload irrespective of app state (foreground / background).
 * <p>
 * > LocalBroadcastManager is used to broadcast the message to all the activities which are registered for the broadcast receiver.
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyGcmListenerService";

    @Override
    public void onMessageReceived(RemoteMessage message) {

    }

}
