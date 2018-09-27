package com.manojlovic.testproject;

public class Item {

    private int mImageResource;
    private String mText1;
    private String mText2;

    public Item(int imageResource, String text1, String text2){
        mImageResource = imageResource;
        mText1 = text1;
        mText2 = text2;
    }

    public Item(String text1){
        mText1 = text1;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getmText1() {
        return mText1;
    }

    public String getmText2() {
        return mText2;
    }
}
