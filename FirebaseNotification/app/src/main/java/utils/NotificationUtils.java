package utils;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.NotificationCompat;
import android.text.Html;
import android.text.TextUtils;
import android.util.Patterns;

import com.example.android.firebasenotification.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import app.Config;

/**
 * Created by DENNIS on 3/21/2017.
 * This class contains necessary functions required to show the message (with title, message, image and timestamp)
 * in notification tray.
 */
public class NotificationUtils {
    private static final String TEXT = "TEXT";
    private String imageName;
    private int id;
    private String title;
    private String textMessage;
    private String sound;

    public NotificationUtils(String imageName,int id,String title,String sound, String textMessage){
        this.id = id;
        this.imageName = imageName;
        this.sound = sound;
        this.title = title;
        this.textMessage = textMessage;

    }
    public String getImageName(){
        return imageName;
    }
    public void setImageName(String imageName){
        this.imageName = imageName;
    }
    public  int getId(){
        return  id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTitle(){
        return  title;
    }
    public void setTitle(String title){
        this.title = title;
    }

}
