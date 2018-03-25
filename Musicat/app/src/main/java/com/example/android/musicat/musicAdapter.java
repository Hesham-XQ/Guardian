package com.example.android.musicat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SAMO on 3/1/2018.
 */


public class musicAdapter extends ArrayAdapter {

    public musicAdapter( Context context,ArrayList<music> pMusic) {
        super(context,0, pMusic);
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        music my_music = (music) getItem(position);
        TextView songTitle = (TextView) listItemView.findViewById(R.id.song);
        songTitle.setText(my_music.getSong());
        TextView artistTitle = (TextView) listItemView.findViewById(R.id.artist);
        artistTitle.setText(my_music.getArtist());

        return listItemView;


    }



}
