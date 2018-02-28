package com.example.pasystemsltd.arabic101;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Days extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);


        final ArrayList<WordClass> words=new ArrayList<>();

        //lessons.add(new"lesson 1")//

        words.add(new WordClass("الإثْنَيْن","Al-ithnayn","Monday", R.raw.zero));
        words.add(new WordClass("الثلاثاء","Ath-thulaathaa","Tuesday",R.raw.one));
        words.add(new WordClass(" الأرْبَعَاء","Ar-rubaa’aa","Wednesday",R.raw.two));
        words.add(new WordClass("الْخَمِيْس","Al-khamees","Thursday",R.raw.three));
        words.add(new WordClass("الْجُمْعَة","Al-jumah","Friday",R.raw.four));
        words.add(new WordClass("السَّبْت","As-sabt","Saturday",R.raw.five));
        words.add(new WordClass("الأحَد","Al-ahad","Sunday",R.raw.six));
        words.add(new WordClass("يَنَايِر","Yanaayir","January",R.raw.seven));
        words.add(new WordClass("فبرار","Fabraar","February",R.raw.eight));
        words.add(new WordClass("مَارس","Maars","March",R.raw.nine));
        words.add(new WordClass("أبْرِيل","Abreel","April",R.raw.one));
        words.add(new WordClass("مَايُو","Maayoo","May",R.raw.one));
        words.add(new WordClass("يُونْيُو","Yoonyoo","June",R.raw.one));
        words.add(new WordClass("يُولْيُو","Yoolyoo","July",R.raw.one));
        words.add(new WordClass("اغَسْطَس","Agustus","August",R.raw.one));
        words.add(new WordClass("سَبْتَمْبَر","Sabtambar","September",R.raw.one));
        words.add(new WordClass("اكْتُوبَر","Aktoobar","October",R.raw.one));
        words.add(new WordClass("نَوفَمْبَر","Nofambar","November",R.raw.one));
        words.add(new WordClass("دِيسَمْبَر","Deesambar","December",R.raw.one));

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

                //release media player currently exist when other sound file played//
                releaseMediaPlayer();

                mMediaPlayer=MediaPlayer.create(Days.this,wordClass.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }


           // * Clean up the media player by releasing its resources.//

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}

