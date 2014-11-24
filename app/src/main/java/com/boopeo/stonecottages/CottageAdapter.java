package com.boopeo.stonecottages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Oliver on 19/11/2014.
 */
class CottageAdapter extends ArrayAdapter<String> {


    public CottageAdapter(Context context, String[] values) {
        super(context,R.layout.cottage_select_design,values);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater cottageSelectInflater = LayoutInflater.from(getContext());
        View theView = cottageSelectInflater.inflate(R.layout.cottage_select_design, parent, false);

        String cottageView = getItem(position);

        TextView cottageFarmhouseText = (TextView) theView.findViewById(R.id.cottageSelectFarmhouse);
        cottageFarmhouseText.setText(cottageView);

        TextView cottageBachText = (TextView) theView.findViewById(R.id.cottageSelectBach);
        cottageBachText.setText(cottageView);

        TextView cottageCowshedText = (TextView) theView.findViewById(R.id.cottageSelectCowshed);
        cottageCowshedText.setText(cottageView);

        TextView cottageCottageText = (TextView) theView.findViewById(R.id.cottageSelectCottage);
        cottageCottageText.setText(cottageView);

        TextView cottageLodgeText = (TextView) theView.findViewById(R.id.cottageSelectLodge);
        cottageLodgeText.setText(cottageView);

        TextView cottageYurtText = (TextView) theView.findViewById(R.id.cottageSelectYurt);
        cottageYurtText.setText(cottageView);


        return theView;
    }
}
