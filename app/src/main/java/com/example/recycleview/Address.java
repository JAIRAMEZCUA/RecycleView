package com.example.recycleview;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    public Address(JSONObject jsonObject, Context context){
        try {
            this.street = jsonObject.getString(context.getString(R.string.street_addr_json));
            this.suite = jsonObject.getString(context.getString(R.string.suite_addr_json));
            this.city = jsonObject.getString(context.getString(R.string.city_addr_json));
            this.zipcode = jsonObject.getString(context.getString(R.string.zipcode_addr_json));
            this.geo = new Geo(jsonObject.getJSONObject(context.getString(R.string.geo_addr_json)),context);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public Address(String street, String suite, String city, String zipcode, Geo geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}
