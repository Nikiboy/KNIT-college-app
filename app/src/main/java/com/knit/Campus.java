package com.knit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;


public class Campus extends Activity {
    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    ButtonAdapter buttonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus);

        String[] mThumbStrings = {
                "Transport", "Library", "Labs",
                "Other Facilities"
        };

        Bitmap masterBmp = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.campus);

        int wide = masterBmp.getWidth() / 4;

        for (int i = 0; i < mThumbStrings.length; i++) {
            Bitmap bitmap = Bitmap.createBitmap(masterBmp, i * wide, 0, wide, masterBmp.getHeight());
            gridArray.add(new Item(bitmap, mThumbStrings[i]));
        }

        gridView = (GridView) findViewById(R.id.campusGridview);
        buttonAdapter = new ButtonAdapter(this, R.layout.button_grid, gridArray);
        gridView.setAdapter(buttonAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position,
                                    long arg3) {

                switch (position) {
                    case 0:
                        Intent intentTansport = new Intent(Campus.this,Transportation.class);
                        startActivity(intentTansport);
                        break;
                    case 1:
                        Intent intentLibrary = new Intent(Campus.this,Library.class);
                        startActivity(intentLibrary);
                        break;
                    case 2:
                        Intent intentLaboratory = new Intent(Campus.this, Laboratory.class);
                        startActivity(intentLaboratory);
                        break;
                    case 3:
                        Intent intentOther = new Intent(Campus.this, OtherActivites.class);
                        startActivity(intentOther);
                        break;
                }


            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_campus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
