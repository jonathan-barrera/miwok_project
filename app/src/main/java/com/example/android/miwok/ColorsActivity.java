package com.example.android.miwok;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create an array list to contain all of the vocab words for numbers.
        ArrayList<Word> words = new ArrayList<Word>();

        // Add each number vocab word and its miwok translation
        words.add(new Word("red", "weṭeṭṭi", R.raw.color_red, R.drawable.color_red));
        words.add(new Word("green", "chokokki", R.raw.color_green, R.drawable.color_green));
        words.add(new Word("brown", "ṭakaakki", R.raw.color_brown, R.drawable.color_brown));
        words.add(new Word("grey", "ṭopoppi", R.raw.color_gray, R.drawable.color_gray));
        words.add(new Word("black", "kululli", R.raw.color_black, R.drawable.color_black));
        words.add(new Word("white", "kelelli", R.raw.color_white, R.drawable.color_white));
        words.add(new Word("dusty yellow", "ṭopiisә", R.raw.color_dusty_yellow, R.drawable.color_dusty_yellow));
        words.add(new Word("mustard yellow", "chiwiiṭә", R.raw.color_mustard_yellow, R.drawable.color_mustard_yellow));

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        //listView.setBackgroundColor(Color.parseColor("#8800A0"));
    }
}
