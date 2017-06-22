package com.example.android.miwok;

/**
 * Created by shailesh on 20/6/17.
 */

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId=NO_IMAGE_PROVIDED;
    private int mAudioResourceId;
    private static final int NO_IMAGE_PROVIDED=-1;

    public Word(String defTranslation,String miwokTranslation, int imgResource,int audioResource){
        mDefaultTranslation=defTranslation;
        mMiwokTranslation=miwokTranslation;;
        mImageResourceId=imgResource;
        mAudioResourceId=audioResource;
    }


    public Word(String defaultTranslation,String miwokTranslation,int audioResource){
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        mAudioResourceId=audioResource;
    }





    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }
    public int getImageResourceId(){
        return mImageResourceId;
    }
    public int getAudioResourceId(){
        return mAudioResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId!=NO_IMAGE_PROVIDED;
    }


}


