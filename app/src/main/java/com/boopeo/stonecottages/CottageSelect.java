package com.boopeo.stonecottages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Oliver on 14/11/2014.
 */
public class CottageSelect extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cottage_select);

       String[] cottages = {"Trallwyn Farmhouse","Trallwyn Bach","Converted Cowshed","Trallwyn Cottage",
                "Trallwyn Lodge","Trallwyn Yurt"
       };
     //list adapter is in CottageAdapter.class
        ListAdapter cottageSelectAdapter = new CottageAdapter(this, cottages);

        //defining the list view and getting the location
        ListView cottageSelectListView = (ListView) findViewById(R.id.cottageSelectListView);

        //tell list view what data to input e.g. cottages list adapter
        cottageSelectListView.setAdapter(cottageSelectAdapter);

        //when user clicks on the list view
        cottageSelectListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //method to run when item is clicked

                //if position refers to the list view strings. e.g. position 0 = farmhouse
                if (position == 0) {
                    Intent openFarmhouse = new Intent(CottageSelect.this, Farmhouse.class);
                    startActivity(openFarmhouse);
                } else if (position == 1) {
                    Intent openBach = new Intent(CottageSelect.this, Bach.class);
                    startActivity(openBach);
                } else if (position == 2) {
                    Intent openCowshed = new Intent(CottageSelect.this, Cowshed.class);
                    startActivity(openCowshed);
                } else if (position == 3) {
                    Intent openCottage = new Intent(CottageSelect.this, Cottage.class);
                    startActivity(openCottage);
                } else if (position == 4) {
                    Intent openLodge = new Intent(CottageSelect.this, Lodge.class);
                    startActivity(openLodge);
                } else if (position == 5) {
                    Intent openYurt = new Intent(CottageSelect.this, Yurt.class);
                    startActivity(openYurt);
                }
            }
        });
    }
}
