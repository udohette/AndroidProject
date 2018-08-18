package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by DENNIS on 6/22/2017.
 */
public class EarthquakeAdapter extends ArrayAdapter<EarthClass> {
    private static final String LOG_TAG = EarthquakeAdapter.class.getSimpleName();
    private static final  String LOCATION_SEPARATOR = "of";

    public EarthquakeAdapter(Context context, ArrayList<EarthClass> earthClasses) {
        super(context, 0, earthClasses);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
            EarthClass currentEarthClass = getItem(position);

            // Find the TextView in the list_item.xml layout with the ID mMag
            TextView textView = (TextView)listItemView.findViewById(R.id.magnitude);
            //format the magnitude to show one decimal place
            String formattedmagnitude = formatMagnitude(currentEarthClass.getMag());
            //Display the magnitude of the current earthquake in that TextView
            textView.setText(formattedmagnitude);

            // Set the proper background color on the magnitude circle.
            //Fetch the background from the textView, which is a GradientDrawable
            GradientDrawable magnitudeCircle = (GradientDrawable)textView.getBackground();
            //get the Appropriate background color based on the current earthquake magnitude
            int magnitudeColor = getMagnitudeColor(currentEarthClass.getMag());
            //set the color of the earthQuake circle
            magnitudeCircle.setColor(magnitudeColor);

            //Get the orignal location string from Eartclass object
            //which can be in format of "5km  N of Cairo, Egypt", or Pacific-Antarctic Ridge
            String originalLocation = currentEarthClass.getLocation();

            String primaryLocation;
            String locationOffset;

            if (originalLocation.contains(LOCATION_SEPARATOR)){
                //Split the string into different parts (as an array of Strings)
                //base on the "of" text. we expect an array of 2 strings, where
                //the first string will be "5km N" and the second string will be "Cairo, Egypt".
                String[] parts = originalLocation.split(LOCATION_SEPARATOR);
                //location offset should be "5km N" + "of" -->"5km N of"
                locationOffset = parts[0]+LOCATION_SEPARATOR;
                //primary location should be "Cairo, Egypt"
                primaryLocation = parts[1];
            }else {
                //otherwise there is no "of text in the originalLocation string
                //hence set the default location offset to say "Near the"
                locationOffset = getContext().getString(R.string.Near_the);
                primaryLocation = originalLocation;
            }
            //find textView with id Split_text
            TextView splitText = (TextView)listItemView.findViewById(R.id.primary_location);
            splitText.setText(primaryLocation);


            // Find the TextView in the list_item.xml layout with the ID offset
            TextView offset = (TextView)listItemView.findViewById(R.id.location_offset);
            offset.setText(locationOffset);


            // Create a new Date object from the time in milliseconds of the earthquake
            Date dateObject = new Date(currentEarthClass.getTimeInMilliseconds());
            // Find the TextView with view ID date
            TextView dateView = (TextView) listItemView.findViewById(R.id.date);
            // Format the date string (i.e. "Mar 3, 1984")
            String formattedDate = formatDate(dateObject);
            // Display the date of the current earthquake in that TextView
            dateView.setText(formattedDate);

            // Find the TextView with view ID time
            TextView timeView = (TextView) listItemView.findViewById(R.id.time);
            // Format the time string (i.e. "4:30PM")
            String formattedTime = formatTime(dateObject);
            // Display the time of the current earthquake in that TextView
            timeView.setText(formattedTime);

        }
        return listItemView;
    }
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor((magnitude));
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;

                break;

            case 2:

                magnitudeColorResourceId = R.color.magnitude2;

                break;

            case 3:

                magnitudeColorResourceId = R.color.magnitude3;

                break;

            case 4:

                magnitudeColorResourceId = R.color.magnitude4;

                break;

            case 5:

                magnitudeColorResourceId = R.color.magnitude5;

                break;

            case 6:

                magnitudeColorResourceId = R.color.magnitude6;

                break;

            case 7:

                magnitudeColorResourceId = R.color.magnitude7;

                break;

            case 8:

                magnitudeColorResourceId = R.color.magnitude8;

                break;

            case 9:

                magnitudeColorResourceId = R.color.magnitude9;

                break;

            default:

                magnitudeColorResourceId = R.color.magnitude10plus;

                break;

        }


        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
        /**

         * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")

         * from a decimal magnitude value.

         */

    private String formatMagnitude(double magnitude) {

        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");

        return magnitudeFormat.format(magnitude);

    }
    /**

     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.

     */
    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
