package com.boopeo.stonecottages;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import library.DatabaseHandler;
import library.UserFunctions;


/**
 * Created by Oliver on 14/11/2014.
 * 13/01/2015// added items to spinners in the booking.java file, added function to get the selected string.
 * need to find a way to put all the information into a table
 * need to create SQLite database tables.
 * Start database to store form information (start with edit text strings)
 */
public class Booking extends Activity {

    Spinner titleSpinner;
    EditText firstName;
    EditText secondName;
    EditText phone;
    EditText address1;
    EditText address2;
    EditText cityTown;
    EditText postCode;
    EditText email;
    Spinner cottage;
    DatePicker from;
    DatePicker to;
    Button submit;
    TextView errorMessage;

    private static String KEY_SUCCESS = "success";
    private static String KEY_UID = "uid";
    private static String KEY_FIRST_NAME = "first_name";
    private static String KEY_SECOND_NAME = "second name";
    private static String KEY_PHONE = "phone";
    private static String KEY_ADDRESS_1 = "address1";
    private static String KEY_ADDRESS_2 = "address2";
    private static String KEY_CITY_TOWN = "cityTown";
    private static String KEY_POST_CODE = "post code";
    private static String KEY_EMAIL = "email";

    public final Intent openConfirmation = new Intent(this, Confirm.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_form);

        titleSpinner = (Spinner) findViewById(R.id.titleSpinner);
        firstName = (EditText) findViewById(R.id.firstName);
        secondName = (EditText) findViewById(R.id.secondName);
        phone = (EditText) findViewById(R.id.phone);
        address1 = (EditText) findViewById(R.id.address1);
        address2 = (EditText) findViewById(R.id.address2);
        cityTown = (EditText) findViewById(R.id.city_town);
        postCode = (EditText) findViewById(R.id.post_code);
        email = (EditText) findViewById(R.id.email_address);
        cottage = (Spinner) findViewById(R.id.cottageSpinner);
        from = (DatePicker) findViewById(R.id.datePicker);
        to = (DatePicker) findViewById(R.id.datePicker2);
        submit = (Button) findViewById(R.id.submitButton);
        errorMessage = (TextView) findViewById(R.id.error_message);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String fName = firstName.getText().toString();
              String sName = secondName.getText().toString();
              String a1 = address1.getText().toString();
              String a2 = address2.getText().toString();
              String ct = cityTown.getText().toString();
              String pc = postCode.getText().toString();
              String em = email.getText().toString();
              String ph = phone.getText().toString();

                UserFunctions userFunctions = new UserFunctions();
                JSONObject json = userFunctions.registerUser(fName,sName,a1,a2,ct,pc,em,ph);

                try {

                    if(json.getString(KEY_SUCCESS) != null){
                        errorMessage.setText("");
                        String res = json.getString(KEY_SUCCESS);
                        if(Integer.parseInt(res) == 1){
                          //store user details in SQLite database
                            DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                            JSONObject json_user = json.getJSONObject("user");
                            //clear all previous data in database
                            db.addUser(json_user.getString(KEY_FIRST_NAME), json_user.getString(KEY_SECOND_NAME),
                                    json_user.getString(KEY_ADDRESS_1),json_user.getString(KEY_ADDRESS_2),
                                    json_user.getString(KEY_EMAIL), json_user.getString(KEY_CITY_TOWN), json_user.getString(KEY_PHONE),
                                    json_user.getString(KEY_POST_CODE));



                                    startActivity(openConfirmation);

                        } else {
                            errorMessage.setText("error in database");
                        }
                    }
                } catch (JSONException e){
                         e.printStackTrace();
                }


            }
        });

        addItemsToTitleSpinner();
        addItemsToCottageSpinner();


        //get strings from spinner selection

        String titleSelection = titleSpinner.getSelectedItem().toString();
        String cottageSelection = cottage.getSelectedItem().toString();



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
