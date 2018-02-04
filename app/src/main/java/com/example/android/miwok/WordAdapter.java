package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jonathanbarrera on 1/31/18.
 * This custom WordAdapter class can adapt instances from the Word class to
 * and array for TextView inflation.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    // Resource ID for the background color for the list of words.
    private int mColorResourceId;
    private MediaPlayer mediaPlayer;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        final Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_translation);
        // Get the version name from the current Word object and
        // set this text on the TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView englishTextView = (TextView) listItemView.findViewById(R.id.english_translation);
        // Get the version number from the current Word object and
        // set this text on the TextView
        englishTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID version_name
        ImageView wordImageView = (ImageView) listItemView.findViewById(R.id.word_image);
        // Get the version number from the current Word object and
        // set this text on the ImageView
        if (currentWord.hasImage()){
            wordImageView.setImageResource(currentWord.getImageResourceId());
        } else {
            wordImageView.setVisibility(View.GONE);
        }

        // Set the ColorResourceId as the background color for the text_container view
        // which contains both of the text views.
        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        listItemView.setBackgroundColor(mColorResourceId);

        // Set a click listener on that View
        textContainer.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the colors View is clicked on.
            @Override
            public void onClick(View view) {
                // Set the audio file
                mediaPlayer = MediaPlayer.create(view.getContext(), currentWord.getAudioResourceId());
                mediaPlayer.start();
            }
        });

        // Return the whole list item layout (containing 2 TextViews and an ImageView and a media player)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
