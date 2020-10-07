package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity  {
    RecyclerView mRecicleView;
    WordListAdapter mAdapter;
    ArrayList<Usuario> listUsers = new ArrayList<>();

    private Toast mToast;

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
        mRecicleView.setLayoutManager(new LinearLayoutManager(this));
        /*
        mAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Selecciono la opion"+listUsers.get(mRecicleView.getChildAdapterPosition(v))
                                .getId(),Toast.LENGTH_LONG).show();
            }
        });

         */
        mRecicleView.setAdapter(mAdapter);

        mRecicleView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecicleView, new RecyclerTouchListener.ClickListener() {
            @Override // Un toque sencillo
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(),
                        "Selecciono la opcion"+listUsers.get(mRecicleView.getChildAdapterPosition(view))
                                .getId(),Toast.LENGTH_LONG).show();
            }

            @Override // Un toque largo
            public void onLongClick(View view, int position) {
                final Usuario mascotaParaEliminar = listUsers.get(position);
                AlertDialog dialog = new AlertDialog
                        .Builder(MainActivity.this)
                        .setPositiveButton("Sí, eliminar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setTitle("Confirmar")
                        .setMessage("¿Eliminar a la mascota " + mascotaParaEliminar.getName() + "?")
                        .create();
                dialog.show();

            }
        }));
    }

}
