package com.example.android.musicat;

/**
 * Created by SAMO on 3/1/2018.
 */

public class music {

    private String mSong ;
    private String mArtist ;
    private int mResourceId ;

public music (String Song , String Artist , int ResourceId ) {

    mSong = Song ;
    mArtist = Artist ;
    mResourceId = ResourceId ;

}

    public String getSong () { return mSong ;}
    public String getArtist () { return mArtist ;}
    public int getResourceid () { return mResourceId ;}


}
