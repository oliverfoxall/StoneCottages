package com.boopeo.stonecottages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

        TextView cottageNameText = (TextView) theView.findViewById(R.id.cottageSelectTitle);
        cottageNameText.setText(cottageView);

        return theView;
    }
}
