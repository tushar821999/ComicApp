package com.androidgits.animation.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.androidgits.animation.R;
import com.androidgits.animation.adapter.RvAdapter;
import com.androidgits.animation.model.Anime;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView myrv;
    private String URL_JSON = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
    private JsonArrayRequest ArrayRequest;
    private RequestQueue requestQueue;
    private List<Anime> lstAnime = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myrv = (RecyclerView) findViewById(R.id.rv);
        jsoncall();
    }

    public void jsoncall() {
        ArrayRequest = new JsonArrayRequest(URL_JSON, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for(int i=0;i<response.length();i++){
                    try{
                        jsonObject = response.getJSONObject(i);
                        Anime anime = new Anime();

                        anime.setDescription(jsonObject.getString("description"));
                        anime.setName(jsonObject.getString("name"));
                        anime.setRating(jsonObject.getString("Rating"));
                        anime.setStudio(jsonObject.getString("studio"));
                        anime.setImage_url(jsonObject.getString("img"));
                        anime.setCategorie(jsonObject.getString("categorie"));
                        lstAnime.add(anime);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
                setRvAdapter(lstAnime);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(ArrayRequest);

    }

    public void setRvAdapter(List<Anime> mData){
        RvAdapter myAdapter = new RvAdapter(this,mData);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(myAdapter);
    }
}
