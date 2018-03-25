package com.example.android.musicat;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by SAMO on 3/1/2018.
 */

public class activity_fayrouz extends AppCompatActivity {


    private MediaPlayer mMediaPlayer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fayrouz);


        final ArrayList<music> musics = new ArrayList<>();
        musics.add(new music("shady" , "fayrouz" ,  R.raw.shady));
        musics.add(new music("ana L habiby" , "fayrouz" ,  R.raw.ana_l_habiby));
        musics.add(new music("alamony" , "fayrouz" ,  R.raw.alamony));
        musics.add(new music("habitaak bl saief" , "fayrouz" ,  R.raw.habitak_bl_saif));
        musics.add(new music("nsam 3alina el hawa" , "fayrouz" ,  R.raw.nsam_aalina_el_hawa));
        musics.add(new music("e7na w el qamar jeraan" , "fayrouz" ,  R.raw.e7na_w_el_qamar_jeran));


        musics.add(new music("shady" , "fayrouz" ,  R.raw.shady));

        musics.add(new music("shady" , "fayrouz" ,  R.raw.shady));
        musics.add(new music("ana L habiby" , "fayrouz" ,  R.raw.ana_l_habiby));
        musics.add(new music("alamony" , "fayrouz" ,  R.raw.alamony));
        musics.add(new music("habitaak bl saief" , "fayrouz" ,  R.raw.habitak_bl_saif));
        musics.add(new music("nsam 3alina el hawa" , "fayrouz" ,  R.raw.nsam_aalina_el_hawa));
        musics.add(new music("e7na w el qamar jeraan" , "fayrouz" ,  R.raw.e7na_w_el_qamar_jeran));

        musicAdapter adapter = new musicAdapter(this, musics);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

   /*



        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                // Request audio focus so in order to play the audio file. The app needs to play a
                // short audio file, so we will request audio focus with a short amount of time
                // with AUDIOFOCUS_GAIN_TRANSIENT.
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now.

                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current word
                    mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());

                    // Start the audio file
                    mMediaPlayer.start();

                    // Setup a listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing.
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
        */
    }
}


