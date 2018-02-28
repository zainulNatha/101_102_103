package com.example.pasystemsltd.arabic101;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;

public class Numbers extends AppCompatActivity {

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

        final ArrayList<WordClass> words = new ArrayList<>();

        //lessons.add(new"lesson 1")//

        words.add(new WordClass("صِفْر", "Sifr", "0", R.raw.zero));
        words.add(new WordClass("وَاحِد", "Waahid", "1", R.raw.one));
        words.add(new WordClass(" اثْنَيْن", "Ithnayn", "2", R.raw.two));
        words.add(new WordClass("ثَلَاثَة", "Thalaatha", "3", R.raw.three));
        words.add(new WordClass("أرْبَعَة", "Arba'a", "4", R.raw.four));
        words.add(new WordClass("خَمْسَة", "Khamsa", "5", R.raw.five));
        words.add(new WordClass("سِتَّة", "Sitta", "6", R.raw.six));
        words.add(new WordClass("سَبْعَة", "Saba'a", "7", R.raw.seven));
        words.add(new WordClass("ثَمَانِيَة", "Thamaaniyah", "8", R.raw.eight));
        words.add(new WordClass("تِسْعَة", "Tis'aa", "9", R.raw.nine));
        words.add(new WordClass("عَشَرَة", "Ashrah", "10", R.raw.one));
        words.add(new WordClass("أحَدَ عَشَر", "Ahada Ashar", "11", R.raw.one));
        words.add(new WordClass("اثْنَى عَشَر", "Ithnaa Ashar", "12", R.raw.one));
        words.add(new WordClass("ثَلَاثَةَ عَشَر", "Thalaathata Ashar", "13", R.raw.one));
        words.add(new WordClass("أرْبَعَةَ عَشَر", "Arba'ata Ashar", "14", R.raw.one));
        words.add(new WordClass("خَمْسَةَ عَشَر", "Khamsata Ashar", "15", R.raw.one));
        words.add(new WordClass("سِتَّةَ عَشَر", "Sittata Ashar", "16", R.raw.one));
        words.add(new WordClass("سَبْعَةَ عَشَر", "Saba'ata Ashar", "17", R.raw.one));
        words.add(new WordClass("ثَمَانِيَةَ عَشَر", "Thamaaniyata Ashar", "18", R.raw.one));
        words.add(new WordClass("تِسْعَةَ عَشَر", "Tis'ata Ashar", "19", R.raw.one));
        words.add(new WordClass("عَشْرُون", "Ishroon", "20", R.raw.one));
        words.add(new WordClass("ثَلَاثونَ", "Thalaathoon", "30", R.raw.one));
        words.add(new WordClass("أرْبَعُون", "Arbaoon", "40", R.raw.one));
        words.add(new WordClass("خَمْسُون", "Khamsoon", "50", R.raw.one));
        words.add(new WordClass("مِئَة", "Mi'ah", "100", R.raw.one));
        words.add(new WordClass("ألْف", "Alf", "1000", R.raw.one));


        //lessonAdaptor to link and display single lesson//
        WordAdapter adaptor =
                new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);


        listView.setAdapter(adaptor);
// Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                //get word object at position user clicked on
                WordClass wordClass = words.get(position);

                //release media player currently exist when other sound file played//
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(Numbers.this, wordClass.getAudioResourceId());
                mMediaPlayer.start();
                // setup on completion listener so finishes resource when completed//
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }
/**
 * Clean up the media player by releasing its resources.
 */
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
