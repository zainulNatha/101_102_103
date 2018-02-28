package com.example.pasystemsltd.arabic101;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Directions extends AppCompatActivity {
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

        words.add(new WordClass("أيْنَ...؟ ","Ayna… ?","Where is…?", R.raw.zero));
        words.add(new WordClass("كَيْفَ أصَلَ إلَى ...؟","Kayfa Asal ilaa…?","How do you get to…?",R.raw.one));
        words.add(new WordClass("أيْنَ أقْرَب...؟ ","Ayna Aqrab…?","Where is the nearest…?",R.raw.two));
        words.add(new WordClass("هَلْ هَذَا الطَّرِيْق الَى...؟","Hal haathat Tareeq ilaa… ?","Is this the way to…?",R.raw.three));
        words.add(new WordClass("شِمَال","Shimaal","North",R.raw.four));
        words.add(new WordClass("شَرْق","Sharq","East",R.raw.five));
        words.add(new WordClass("جُنُوب","Junoob","South",R.raw.six));
        words.add(new WordClass("َغرْب","Garb","West",R.raw.seven));
        words.add(new WordClass("اذْهَب يَمِينا","Ith'hab yameenaa","Go right (male)",R.raw.eight));
        words.add(new WordClass("اذْهَب يَسَارا","Ith'hab yasaaraa","Go left (male)",R.raw.nine));
        words.add(new WordClass("اذْهَبِي يَمِينا","Ith'habee yameenaa","Go right (female)",R.raw.one));
        words.add(new WordClass("اذْهَبِي يَسَارا","Ith'habee yasaaraa","Go left (female)",R.raw.one));
        words.add(new WordClass("أوَّل شَارِع","Awwal Shaari'","The first street",R.raw.one));
        words.add(new WordClass("َثانِي شَارِع","Thaani Shaari'","The second street",R.raw.one));
        words.add(new WordClass("اذْهَبِي عَلَى الطُّوْل / اذْهَب ","Ith'hab / Ith'habee alat Tool","Go straight",R.raw.one));
        words.add(new WordClass("امْشِي / امْش ","Imsh / Imshee","Walk",R.raw.one));
        words.add(new WordClass("أعْبَر الشَّارِع","A'bar Ash Shaari'","Cross the road",R.raw.one));
        words.add(new WordClass("بَيْنَ ... وَ...","Bayna… wa…","Between… and…",R.raw.one));
        words.add(new WordClass("بِجَانِب ...","Bijaanib","Next to…",R.raw.one));
        words.add(new WordClass("اضَعْتُ طَرِيقِي","Ada'too tareeqi","I lost my way",R.raw.one));


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

                mMediaPlayer=MediaPlayer.create(Directions.this,wordClass.getAudioResourceId());
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


