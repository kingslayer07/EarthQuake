package com.example.android.quakereport;

public class Earthquake {
    private  String mMagnitude;
    private  String mPlace;
    private  long mTimeInMili;

    public Earthquake(String magnitude,String place,long date ){
        mMagnitude=magnitude;
        mPlace=place;
        mTimeInMili=date;
    }
    public String getMagnitude(){
        return mMagnitude;
    }

    public String getPlace(){
        return mPlace;
    }

    public long getDate(){
        return mTimeInMili;
    }
}
