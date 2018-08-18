package com.example.dennis.cookies;

/**
 * Created by DENNIS on 11/3/2017.
 */

public class ReportCard {
    String MathGrade;
    String ChemistryGrade;
    String HistoryGrade;
    String PhySicsGrade;
    String EnglishGrade;
    String AgricultureGrade;
    ReportCard(String MathGrade, String ChemistryGrade, String HistoryGrade,String PhysicsGrade,String EnglishGrade, String AgricGrade){
        this.MathGrade = MathGrade;
        this.ChemistryGrade = ChemistryGrade;
        this.HistoryGrade = HistoryGrade;
        this.PhySicsGrade = PhysicsGrade;
        this.EnglishGrade = EnglishGrade;
        this.AgricultureGrade = AgricGrade;
    }

    public String getMathGrade() {
        return MathGrade;
    }

    public void setMathGrade(String mathGrade) {
        MathGrade = mathGrade;
    }

    public String getChemistryGrade() {
        return ChemistryGrade;
    }

    public void setChemistryGrade(String chemistryGrade) {
        ChemistryGrade = chemistryGrade;
    }

    public String getHistoryGrade() {
        return HistoryGrade;
    }

    public void setHistoryGrade(String historyGrade) {
        HistoryGrade = historyGrade;
    }

    public String getAgricultureGrade() {
        return AgricultureGrade;
    }

    public void setAgricultureGrade(String agricultureGrade) {
        AgricultureGrade = agricultureGrade;
    }

    public String getEnglishGrade() {
        return EnglishGrade;
    }

    public void setEnglishGrade(String englishGrade) {
        EnglishGrade = englishGrade;
    }

    public String getPhySicsGrade() {
        return PhySicsGrade;
    }

    public void setPhySicsGrade(String phySicsGrade) {
        PhySicsGrade = phySicsGrade;
    }

    @Override
    public String toString() {
        System.out.println("Name: Dennis Samuel"+" MathGrade: "+MathGrade+"EnglishGrade: "+EnglishGrade);
        return toString();
    }
}
