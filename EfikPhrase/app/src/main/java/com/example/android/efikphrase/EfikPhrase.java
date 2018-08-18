package com.example.android.efikphrase;

/**
 * Created by DENNIS on 11/12/2016.
 */
public class EfikPhrase {
    private int efikImages = NO_IMAGE_PROVIDED;
    private String defaultTranslation;
    private String efikTranslation;
    private static final int NO_IMAGE_PROVIDED = -1;

    public EfikPhrase(String defaultTranslation_Eng, String efikTranslation_efik, int imgs) {
        defaultTranslation = defaultTranslation_Eng;
        efikTranslation = efikTranslation_efik;
        efikImages = imgs;

    }

    public EfikPhrase(String defaultTranslation_Eng, String efikTranslation_efik) {
        defaultTranslation = defaultTranslation_Eng;
        efikTranslation = efikTranslation_efik;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public String getEfikTranslation() {
        return efikTranslation;
    }

    public int getEfikImages() {
        return efikImages;
    }

    public boolean hasImage() {
        return efikImages != NO_IMAGE_PROVIDED;
    }
}