package com.boopeo.stonecottages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Oliver on 20/11/2014.
 */
public class Lodge extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lodge);
    }
    public void openBooking(View view){
        Intent openBooking = new Intent(this, Booking.class);
        startActivity(openBooking);
    }
    public void openPhotos(View view){
        Intent openPhotos = new Intent(this, Photos.class);
        startActivity(openPhotos);
    }
    public void openCottages(View view){
        Intent openCottages = new Intent(this, CottageSelect.class);
        startActivity(openCottages);
    }
}
