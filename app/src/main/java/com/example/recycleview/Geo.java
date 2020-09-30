package com.example.recycleview;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

public class Geo {
    private String lat;
    private String lng;

    public Geo(JSONObject jsonObject, Context context) {
        try {
            this.lat = jsonObject.getString(context.getString(R.string.lat_geo_addr_json));
            this.lng = jsonObject.getString(context.getString(R.string.lng_geo_addr_json));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public Geo(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
