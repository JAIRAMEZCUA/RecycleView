package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecicleView;
    WordListAdapter mAdapter;
    ArrayList<Usuario> listUsers = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url3 = "https://jsonplaceholder.typicode.com/users";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i<response.length(); i++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        Usuario usuario = new Usuario(jsonObject,MainActivity.this);
                        listUsers.add(usuario);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonArrayRequest);

        mRecicleView = findViewById(R.id.recyclerView);
        mRecicleView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mAdapter = new WordListAdapter(this, listUsers);
        mRecicleView.setAdapter(mAdapter);
        mRecicleView.setLayoutManager(new LinearLayoutManager(this));
    }
}