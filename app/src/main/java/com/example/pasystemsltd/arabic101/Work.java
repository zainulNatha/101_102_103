package com.example.pasystemsltd.arabic101;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Work extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

        final ArrayList<WordClass> words=new ArrayList<>();

        //lessons.add(new"lesson 1")//

        words.add(new WordClass("","","", R.raw.zero));
        words.add(new WordClass("","","",R.raw.one));
        words.add(new WordClass("","","",R.raw.two));
        words.add(new WordClass("","","",R.raw.three));
        words.add(new WordClass("","","",R.raw.four));
        words.add(new WordClass("","","",R.raw.five));
        words.add(new WordClass("","","",R.raw.six));
        words.add(new WordClass("","","",R.raw.seven));
        words.add(new WordClass("","","",R.raw.eight));
        words.add(new WordClass("","","",R.raw.nine));
        words.add(new WordClass("","","",R.raw.one));
        words.add(new WordClass("","","",R.raw.one));
        words.add(new WordClass("","","",R.raw.one));
        words.add(new WordClass("","","",R.raw.one));
        words.add(new WordClass("","","",R.raw.one));
        words.add(new WordClass("","","",R.raw.one));
        words.add(new WordClass("","","",R.raw.one));
        words.add(new WordClass("","","",R.raw.one));
        words.add(new WordClass("","","",R.raw.one));



        //lessonAdaptor to link and display single lesson//
        WordAdapter adaptor=
                new WordAdapter(this, words);

        ListView listView= (ListView) findViewById(R.id.list);


        listView.setAdapter(adaptor);
// Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                //get word object at position user clicked on
                WordClass wordClass=words.get(position);

                mMediaPlayer=MediaPlayer.create(Work.this,wordClass.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}
