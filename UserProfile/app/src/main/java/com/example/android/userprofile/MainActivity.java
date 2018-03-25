package com.example.android.userprofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView name = (TextView) findViewById(R.id.name) ;
        name.setText(R.string.name);

        TextView id = (TextView) findViewById(R.id.id) ;
        id.setText(R.string.id);

        TextView country = (TextView) findViewById(R.id.country) ;
        country.setText(R.string.country);

        ImageView image = (ImageView) findViewById(R.id.image);
        image.setImageResource(R.drawable.pic);

    }
}
