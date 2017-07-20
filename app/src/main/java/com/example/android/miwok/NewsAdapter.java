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

import android.content.Context;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static java.lang.System.load;

/**
 * {@link NewsAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link News} objects.
 */
public class NewsAdapter extends ArrayAdapter<News>  {

    private static final String LOCATION_SEPARATOR = "T";
    TextView dateTextView, timeTextView;

    public NewsAdapter(Context context, ArrayList<News> news) {
        super(context, 0, news);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }

        News currentNews = getItem(position);

        String imageUrl = currentNews.getImageUrl();
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        Picasso.with(getContext()).load(imageUrl).resize(180, 180).into(imageView);


        String title = currentNews.getTitle();
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_view);
        titleTextView.setText(title);

        String desc = currentNews.getDescription();
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description_view);
        descriptionTextView.setText(desc);
        Log.i("aaa",currentNews.getDescription()+"\n"+
                    currentNews.getImageUrl()+"\n"+
                    currentNews.getTime()+"\n"+
                    currentNews.getUrl()+"\n"+
                    currentNews.getTitle());

//        TextView dateText = (TextView)listItemView.findViewById(R.id.date_view);
//        dateText.setText(currentNews.getTime());

        String publishedAt = currentNews.getTime();
        if (! publishedAt.equals("null")) {
            String date, time;
            String[] parts = publishedAt.split(LOCATION_SEPARATOR);
            date = parts[0];
            time = parts[1];
            dateTextView = (TextView) listItemView.findViewById(R.id.date_view);
            timeTextView = (TextView) listItemView.findViewById(R.id.time_view);
            dateTextView.setText(date);
            timeTextView.setText(time);
        }
        else if (publishedAt.equals("null")){
            dateTextView.setVisibility(View.GONE);
            timeTextView.setVisibility(View.GONE);

        }
        return listItemView;
    }
}