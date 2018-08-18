package com.example.android.miwok;

/**
 * Created by DENNIS on 10/27/2016.
 */
/**
 + * {@link Word} represents a vocabulary word that the user wants to learn.
 + * It contains a default translation and a Miwok translation for that word.
 + */
public class Word {
    private int mWorkImages = NO_IMAGE_PROVIDED;
    private String mMiworkTranslation;
    private  String mDefaultTranslation;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mAudioResource;


    public Word(String defaultTraslation, String miworktranslation,int audioResourceId) {
        mDefaultTranslation = defaultTraslation;
        mMiworkTranslation = miworktranslation;
        mAudioResource = audioResourceId;
    }
    /**
     +     * Create a new Word object.
     +     *
     +     * @param defaultTranslation is the word in a language that the user is already familiar with
     +     *                           (such as English)
     +     * @param miwokTranslation is the word in the Miwok language

     +     */
    public Word(String defaultTraslation, String miworktranslation,int mImgs,int audioResourceId) {
        mDefaultTranslation = defaultTraslation;
        mMiworkTranslation = miworktranslation;
        mWorkImages = mImgs;
        mAudioResource = audioResourceId;

    }
       /*
        +     * Get the default translation of the word.*/
    public String getmMiworkTranslation(){

        return mMiworkTranslation;
    }
    public String getmDefaultTranslation()

    {
        return  mDefaultTranslation;
    }
    public int getmWorkImages()
    {
        return mWorkImages;
    }
    /** Returns weather there is an Image or not for this word**/
    public boolean hasImage(){

        return mWorkImages != NO_IMAGE_PROVIDED;
    }
    public  int getmAudioResource(){
        return mAudioResource;
    }
}

