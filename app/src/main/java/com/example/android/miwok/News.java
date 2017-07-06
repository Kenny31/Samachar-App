/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

/**
 * {@link News} represents a vocabulary word that the user wants to learn.
 * It contains resource IDs for the default translation, Miwok translation, audio file, and
 * optional image file for that word.
 */
public class News {

    private String mTitle, mDescription, mUrl, mImageUrl;
    private String mTime;

    public News(String title, String description, String url, String imageUrl, String time){
        mTitle=title;
        mDescription=description;
        mUrl=url;
        mImageUrl=imageUrl;
        mTime=time;
    }

    public String getTitle(){ return mTitle;}

    public String getDescription(){ return mDescription;}

    public String getUrl(){ return mUrl;}

    public String getImageUrl(){ return mImageUrl;}

    public String getTime(){ return mTime;}
}