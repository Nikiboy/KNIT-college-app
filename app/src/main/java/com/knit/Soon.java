package com.knit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Soon extends Activity {

    Animation bounce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_needed);
        bounce = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce_bounce);
        bounce.setRepeatMode(Animation.INFINITE);
        ImageView iv = (ImageView) findViewById(R.id.searchGlass);
        iv.setAnimation(bounce);
    }

    public void bck_clicked(View v) {
        onBackPressed();
        this.finish();
    }

    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        this.finish();

    }
}
