package com.example.android.miwok;

import android.media.MediaPlayer;

/**
 * Created by jonathanbarrera on 1/31/18.
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */

public class Word {

    /** Default translation of the word */
    private String mDefaultTranslation;

    /** Miwok translation of the word */
    private String mMiwokTranslation;

    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    /** Audio resource ID for the word*/
    private int mAudioResourceId;

    /**
     * The constructor for the english and miwork word translations *without* an image
     * @param defaultTranslation the translation in the default language (ex. english)
     * @param miwokTranslation the miwok translation
     */
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    /**
     * The constructor for the english + miwok translations and an image
     * @param defaultTranslation the translation in the default language (ex. english)
     * @param miwokTranslation the miwok translation
     * @param imageResourceId the resource for the word image
     */
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId, int imageResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the default translation of the word.
     */
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    /**
     * Get the miwok translation of the word.
     */
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    /**
     * Get the image resource id for the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns where there is an image or not
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Get the audio resource id for the word.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }

}
