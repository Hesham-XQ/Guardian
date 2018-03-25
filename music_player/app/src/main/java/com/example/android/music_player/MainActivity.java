package com.example.android.music_player;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPlayer = MediaPlayer.create(this, R.raw.song);

        final Button media = (Button) findViewById(R.id.play_button);

        media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "wooooow", Toast.LENGTH_SHORT).show();
                mPlayer.start();

                mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(MainActivity.this, "I'm done!!", Toast.LENGTH_SHORT).show();
                        releaseMediaPlayer();
                    }
                });
            }
        });

        Button pause = (Button) findViewById(R.id.pause_button);

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "why!!!!!!!!!!!", Toast.LENGTH_SHORT).show();
                mPlayer.pause();
            }
        });


        Button mreset = (Button) findViewById(R.id.reset);

        mreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "reseeeeeeeeeeeeet", Toast.LENGTH_SHORT).show();
                mPlayer.seekTo(0);
                mPlayer.start();
            }
        });


        Button mrelease = (Button) findViewById(R.id.release);

        mrelease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "release", Toast.LENGTH_SHORT).show();
                mPlayer.reset();
                mPlayer = MediaPlayer.create(getBaseContext(), R.raw.song);


            }
        });


    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mPlayer = null;
        }
    }

}
