package com.example.pasystemsltd.arabic101;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Family extends AppCompatActivity {


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

        words.add(new WordClass("أسْرة","Usrah","(Immediate) Family", R.raw.zero));
        words.add(new WordClass("عَائِلَة","Aa’ilah","(Extended) Family",R.raw.one));
        words.add(new WordClass("أب ","Abb","Father",R.raw.two));
        words.add(new WordClass("أم","Umm","Mother",R.raw.three));
        words.add(new WordClass("أبْنَاء / ابْن ","Ibn / Abnaa’","Son/ Sons ",R.raw.four));
        words.add(new WordClass(" بَنَات / بِنْت ","Bint / Banaat","Daughter/ daughters",R.raw.five));
        words.add(new WordClass("أخَوَات / أخْت ","Ukht / Akhawaat","Sister/ sisters",R.raw.six));
        words.add(new WordClass("أخ / اخْوَة","Akh – Ikhwah","Brother / brothers",R.raw.seven));
        words.add(new WordClass("جَد","Jadd","Grandfather",R.raw.eight));
        words.add(new WordClass("جَدَّة","Jaddah","Grandmother",R.raw.nine));
        words.add(new WordClass("حَفِيد","Hafeed","Grandson",R.raw.one));
        words.add(new WordClass("حَفِيدَة","Hafeedah","Granddaughter",R.raw.one));
        words.add(new WordClass("عَمّ","Amm","(Paternal) Uncle",R.raw.one));
        words.add(new WordClass("زَوجَةُ الْعَم","Zawjatul Amm","(Paternal Uncle’s Wife) Aunt",R.raw.one));
        words.add(new WordClass("عَمَّة","Ammah","(Paternal) Aunt",R.raw.one));
        words.add(new WordClass("زَوجُ الْعَمَّة","Zawjul Ammah","(Paternal Aunt’s Husband) Uncle",R.raw.one));
        words.add(new WordClass("خَال","Khaal","(Maternal) Uncle",R.raw.one));
        words.add(new WordClass("زَوجَةُ الْخَال","Zawjatul Khaal","(Maternal Uncle’s Wife) Aunt",R.raw.one));
        words.add(new WordClass("خَالَّة","Khaalah","(Maternal) Aunt",R.raw.one));
        words.add(new WordClass("زَوجُ الخَالَّة","Zawjul Khaalah","(Maternal Aunt’s Husband) Uncle",R.raw.one));


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

                mMediaPlayer=MediaPlayer.create(Family.this,wordClass.getAudioResourceId());
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
