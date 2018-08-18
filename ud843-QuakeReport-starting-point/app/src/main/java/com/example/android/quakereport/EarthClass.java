package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by DENNIS on 6/22/2017.
 */
public class EarthClass {
    // Name of the Android version (e.g. Gingerbread, Honeycomb, Ice Cream Sandwich)
    private double mag;

    // Android version number (e.g. 2.3-2.7, 3.0-3.2.6, 4.0-4.0.4)
    private String location;

    /** Time of the earthquake */
    private long mTimeInMilliseconds;

    //url of the website
    private String url;


    public EarthClass(double mMag,String mLocation, long timeInMilliseconds, String mUrl){
        mag = mMag;
        location = mLocation;
        mTimeInMilliseconds = timeInMilliseconds;
        url = mUrl;
    }
    public String getUrl(){
        return url;
    }

    public double getMag() {
        return mag;
    }

    public String getLocation() {
        return location;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

}
