package com.example.android.gridlayout;

/**
 * Created by DENNIS on 11/13/2016.
 */
public class EfikPhrases {
   public String EfikeWords;

    public String getEfikeWords() {
        return EfikeWords;
    }

    public void setEfikeWords(String efikeWords) {
        EfikeWords = efikeWords;
    }

    public int getImages() {
        return Images;
    }

    public void setImages(int images) {
        Images = images;
    }

    int Images;

    EfikPhrases(String EfikWords, int Images){
        this.Images = Images;
       this.EfikeWords = EfikWords;
    }
}
