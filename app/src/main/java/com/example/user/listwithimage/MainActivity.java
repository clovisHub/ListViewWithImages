package com.example.user.listwithimage;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName()+"_TAG";
    ListView myListView;

    String [] names ={"Pikkon","Baby","Bardock","Beerus","Android18","Gogeta"};

    final int [] photos ={R.drawable.pikkon, R.drawable.baby,R.drawable.bardock,
                   R.drawable.beerus,R.drawable.c18,R.drawable.gogeta };

    HashMap<Integer, String > map = new HashMap<Integer, String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i =0; i< names.length; i++){

            map.put(photos[i],names[i]);
        }


        myListView =(ListView) findViewById(R.id.listV);
        //myToolbar.(getResources().getString(R.string.app_name));

        ItemsAdapter itemsAdapter = new ItemsAdapter(MainActivity.this,R.layout.listview_item, names,photos);

        String j = itemsAdapter.adapNames.toString();

        Log.d(TAG, "onCreate: "+j);

        myListView.setAdapter(itemsAdapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
