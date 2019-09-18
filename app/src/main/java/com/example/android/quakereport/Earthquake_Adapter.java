package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Earthquake_Adapter extends ArrayAdapter<Earthquake> {
    public Earthquake_Adapter(Context context, List<Earthquake> earthquakes){
        super(context,0,earthquakes);
    }
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
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }
        Earthquake currentEarthquake = getItem(position);
        //textView for magnitude
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitudeView.setText(currentEarthquake.getMagnitude());
        //textview for place

        TextView placeView = (TextView) listItemView.findViewById(R.id.place);
        placeView.setText(currentEarthquake.getPlace());
        //textview for date
        Date dataObject =  new Date(currentEarthquake.getDate());
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        String formattedDate=formatDate(dataObject);
        dateView.setText(formattedDate);
        TextView timeView=(TextView) listItemView.findViewById(R.id.time);
        String formattedTime=formatTime(dataObject);
        timeView.setText(formattedTime);
        return listItemView;
    }

}
