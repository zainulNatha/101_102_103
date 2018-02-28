package com.example.pasystemsltd.arabic101;

/**
 * Created by PAsystemsltd on 07/02/2018.
 */

public class WordClass {

    private String mArabic;

    private String mTransliteration;

    private String mTranslation;

    private int mAudioResourceId;

    public WordClass(String arabicWord,String arabicTransliteration, String englishTranslation,int audioResourceId){

        mArabic=arabicWord;
        mTransliteration=arabicTransliteration;
        mTranslation=englishTranslation;
        mAudioResourceId=audioResourceId;

    }

    //get Arabic Word//

    public String getArabicWord() {

        return mArabic;
    }



    //get transliteration//

    public String getArabicTransliteration(){

        return mTransliteration;
    }

    //get translation//

    public String getTranslation(){

        return mTranslation;
    }

    public int getAudioResourceId(){
        return mAudioResourceId;
    }

}
