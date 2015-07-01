package com.knit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    ButtonAdapter buttonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] mThumbStrings = {
                "About Us", "Contacts", "Locations",
                "Campus", "Photos", "News & Events",
                "Weather", "Results", "feedback"
        };

        //RANDOM AMONG TWO
        Bitmap masterBmp = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.master_menu_white);
        int wide = masterBmp.getWidth() / 3;
        int high = masterBmp.getHeight() / 4;

        // set grid view item
        for (int i = 0; i < mThumbStrings.length; i++) {
            Bitmap bitmap = Bitmap.createBitmap(masterBmp, (i % 3) * wide, (i / 3) * high, wide, high);
            gridArray.add(new Item(bitmap, mThumbStrings[i]));
        }


        gridView = (GridView) findViewById(R.id.gridview);
        buttonAdapter = new ButtonAdapter(this, R.layout.button_grid, gridArray);
        gridView.setAdapter(buttonAdapter);

        gridView.setOnItemClickListener(new OnItemClickListener() {
            MyConnection conn = new MyConnection(getApplicationContext());

            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position,
                                    long arg3) {
                Intent intentSoon = new Intent(MainActivity.this, Soon.class);
                switch (position) {
                    case 0:
                        Intent intentAbout = new Intent(MainActivity.this, AboutUs.class);
                        startActivity(intentAbout);
                        break;
                    case 1:
                        Intent intentContact = new Intent(MainActivity.this,
                                ContactActivity.class);
                        startActivity(intentContact);
                        break;
                    case 2:
                        Intent intentMaps = new Intent(MainActivity.this, MapsActivity.class);
                        startActivity(intentMaps);
                        break;
                    case 3:
                        Intent intentTransport = new Intent(MainActivity.this, Campus.class);
                        startActivity(intentTransport);
                        break;
                    case 4:
                        if (conn.isConnectingToInternet()) {
                            Intent intentPhotos = new Intent(MainActivity.this, Photos.class);
                            startActivity(intentPhotos);
                        } else
                            startActivity(intentSoon);
                        break;
                    case 5:
                        if (conn.isConnectingToInternet()) {
                            Intent intentNews = new Intent(MainActivity.this, NewsEvents.class);
                            startActivity(intentNews);
                        } else
                            startActivity(intentSoon);
                        break;
                    case 6:
                        if (conn.isConnectingToInternet()) {
                            Intent intentWeather = new Intent(MainActivity.this, WeatherActivity.class);
                            startActivity(intentWeather);
                        } else
                            startActivity(intentSoon);
                        break;
                    case 7:
                        Intent intentResults = new Intent(MainActivity.this, ResultActivity.class);
                        startActivity(intentResults);
                        break;
                    case 8:
                        Intent intent = new Intent(MainActivity.this, FeedbackActivity.class);
                        startActivity(intent);
                        break;

                }


            }
        });
    }

}


/*
 * 
		 Integer[] mThumbIds = {
				 R.drawable.a_news,R.drawable.b_contacts,R.drawable.c_locations,
				 R.drawable.d_transport,R.drawable.e_photos,R.drawable.f_events,
				 R.drawable.g_weather,R.drawable.h_results,R.drawable.i_feedback 
		 };

		 String[] mThumbStrings = {
				 "News","Contacts","Locations",
				 "Transport","Photos","Events",
				 "Weather","Results","feedback"
		 };
 * **/
