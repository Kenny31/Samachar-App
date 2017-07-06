package com.example.android.miwok;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;


import java.util.List;

/**
 * Created by Karan on 10-04-2017.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private String mUrl;

    public  NewsLoader(Context context, String url){
        super (context);
        mUrl= url;
    }


    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<News> news = QueryUtils.fetchNewsData(mUrl);
        return news;
    }
}
