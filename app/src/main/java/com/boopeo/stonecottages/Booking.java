package com.boopeo.stonecottages;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


/**
 * Created by Oliver on 14/11/2014.
 * 13/01/2015// added items to spinners in the booking.java file, added function to get the selected string.
 * need to find a way to put all the information into a table
 * need to create SQLite database tables.
 * Start database to store form information (start with edit text strings)
 */
public class Booking extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_form);

        addItemsToTitleSpinner();
        addItemsToCottageSpinner();


        //get strings from spinner selection
        final Spinner titleSpinner = (Spinner) findViewById(R.id.titleSpinner);
        String title = titleSpinner.getSelectedItem().toString();

        final Spinner cottageSpinner = (Spinner) findViewById(R.id.cottageSpinner);
        String cottage = cottageSpinner.getSelectedItem().toString();

    }

    //method for adding items to title spinner
    public void addItemsToTitleSpinner(){


        //define what spinner to use
        Spinner titleSpinner = (Spinner) findViewById(R.id.titleSpinner);
        //set an array adapter to create and adapter that gets the string reasourse and puts the information
        //into the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.titles,
                android.R.layout.simple_spinner_item);
        //set drop down resource
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //add to adapter
        titleSpinner.setAdapter(adapter);


    }

    public void addItemsToCottageSpinner() {

        Spinner cottageSpinner = (Spinner) findViewById(R.id.cottageSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cottages,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cottageSpinner.setAdapter(adapter);
    }
}
