package com.boopeo.stonecottages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Oliver on 18/11/2014.
 */
public class Photos extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_gallery);


    }
    public void openBooking(View view){
        Intent openBooking = new Intent(this, Booking.class);
        startActivity(openBooking);
    }
    public void openHome(View view){
        Intent openHome = new Intent(this, MainActivity.class);
        startActivity(openHome);
    }
    public void openCottages(View view){
        Intent openCottages = new Intent(this, CottageSelect.class);
        startActivity(openCottages);
    }
}
