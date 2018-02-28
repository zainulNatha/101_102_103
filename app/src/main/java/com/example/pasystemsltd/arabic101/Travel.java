package com.example.pasystemsltd.arabic101;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Travel extends AppCompatActivity {
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

        words.add(new WordClass("المَطَار","Al Mataar","the airport", R.raw.zero));
        words.add(new WordClass("َمحَطَّة الْقِطَار","Mahattul Qitaar","Train Station",R.raw.one));
        words.add(new WordClass("َموْقِف الْبَاص ","Mawqif Al Baas","Bus stop",R.raw.two));
        words.add(new WordClass("َذْكِرَة، تَذَاكِر","Tathkira, Tathaakir","Ticket, Tickets",R.raw.three));
        words.add(new WordClass("صَالَةُ الْمُغَادِرَة","Saalatul Mughaadirah","Departure Hall",R.raw.four));
        words.add(new WordClass("صَالَةُ الْوُصُوْل","Saalatul Wusool ","Arrival Hall",R.raw.five));
        words.add(new WordClass("الجَمَارِك","Al Jamaarik","Customs",R.raw.six));
        words.add(new WordClass("َجوَاز السَّفَر","Jawaaz As Safar","Passport",R.raw.seven));
        words.add(new WordClass("مَوْعِد الْإقْلَاع","Maw'idul Iqlaa'","Departure time",R.raw.eight));
        words.add(new WordClass("موْعِد الْوُصُوْل","Maw'idul Wusool","Arrival time",R.raw.nine));
        words.add(new WordClass("َوَابَة، بَوَابَات","Bawaabah, Bawaabaat","Gate, Gates",R.raw.one));
        words.add(new WordClass("سَائِحَة / سَائِح ","Saa'ih/ Saaihah","Tourist (male/female)",R.raw.one));
        words.add(new WordClass("َطائِرَة","Taa'irah","Plane",R.raw.one));
        words.add(new WordClass("َباص","Baas","Bus",R.raw.one));
        words.add(new WordClass("قِطَار","Qitaar","Train",R.raw.one));
        words.add(new WordClass("سَفِيْنَة / مَرْكَب","Safeenah / Markab","Ship",R.raw.one));
        words.add(new WordClass("دَرَّاجَة","Darraajah ","Bike",R.raw.one));
        words.add(new WordClass("اسْتِلَام الأمْتَعَة","Istilaamul Amta'ah","Baggage Claim",R.raw.one));
        words.add(new WordClass("أسَافِر الَى…","Usaafir ilaa…","I am travelling to, I travel to…",R.raw.one));
        words.add(new WordClass("أرْكَب","Arkab","I am riding, I ride",R.raw.one));

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

                mMediaPlayer=MediaPlayer.create(Travel.this,wordClass.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }

    // Clean up the media player by releasing its resources.

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
