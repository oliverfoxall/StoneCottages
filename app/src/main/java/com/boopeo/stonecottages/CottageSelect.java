package com.boopeo.stonecottages;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;

/**
 * Created by Oliver on 14/11/2014.
 */
public class CottageSelect extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cottage_select);

       String[] cottages = {"Trallwyn Farmhouse","Trallwyn Bach","Converted Cowshed","Trallwyn Cottage","Trallwyn Lodge","Trallwyn Yurt"
       };
     //list adapter is in CottageAdapter.class
        ListAdapter cottageSelectAdapter = new CottageAdapter(this, cottages);
    }
}
