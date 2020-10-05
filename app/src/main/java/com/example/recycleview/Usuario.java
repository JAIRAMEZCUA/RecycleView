package com.example.recycleview;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

public class Usuario {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    public Usuario(JSONObject jsonObject, Context context) {
        try {
            this.id         = jsonObject.getInt(context.getString(R.string.id_json));
            this.name       = jsonObject.getString(context.getString(R.string.name_json));
            this.username   = jsonObject.getString(context.getString(R.string.username_json));
            this.email      = jsonObject.getString(context.getString(R.string.email_json));
            this.address    = new Address(jsonObject.getJSONObject(context.getString(R.string.address_json)),context);
            this.phone      = jsonObject.getString(context.getString(R.string.phone_json));
            this.website    = jsonObject.getString(context.getString(R.string.website_json));;
            this.company    = new Company(jsonObject.getJSONObject(context.getString(R.string.company_json)),context);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public Usuario(int id, String name, String username, String email, Address address, String phone, String website, Company company) {
        this.id         = id;
        this.name       = name;
        this.username   = username;
        this.email      = email;
        this.address    = address;
        this.phone      = phone;
        this.website    = website;
        this.company    = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
