package com.example.recycleview;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

public class Company {
    private String name;
    private String catchPhrase;
    private String bs;

    public Company(JSONObject jsonObject, Context context) {
        try {
            this.name = jsonObject.getString(context.getString(R.string.name_company_json));
            this.catchPhrase = jsonObject.getString(context.getString(R.string.catchPhrase_company_json));
            this.bs = jsonObject.getString(context.getString(R.string.bs_company_json));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public Company(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }
}
