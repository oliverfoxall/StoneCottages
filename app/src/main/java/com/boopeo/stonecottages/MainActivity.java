package com.boopeo.stonecottages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    //todo make sure that all of this stuff is working, might need to add class to 'this'
}
