package com.example.android.musicat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


/*
        TextView fayrouz = (TextView) findViewById(R.id.fayrouz_text);


        fayrouz.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent fayrouzIntent = new Intent(MainActivity.this, activity_fayrouz.class);

                // Start the new activity
                startActivity(fayrouzIntent);
            }
        });

        */
    }
}
