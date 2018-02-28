package com.example.pasystemsltd.arabic101;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class House extends AppCompatActivity {
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

        words.add(new WordClass("منزل / بَيْت","Bayt / Manzil ","House", R.raw.zero));
        words.add(new WordClass("شِقَق / شَقَّة","Shiqqah / Shiqaq","Apartment, Apartments",R.raw.one));
        words.add(new WordClass("غُرْفَةُ الْمَعِيْشَة","Gurfatul Ma’eesha","Living room",R.raw.two));
        words.add(new WordClass("غُرْفَةُ الْجُلُوْس","Gurfatul Juloos","Sitting Room",R.raw.three));
        words.add(new WordClass("مَطْبَخ"," Mat’bakh","Kitchen",R.raw.four));
        words.add(new WordClass("غُرْفَةُ الطَّعَام","Gurfatut Ta’aam","Dining Room",R.raw.five));
        words.add(new WordClass("حَمَّام / مِرْحَاض ","Mirhaadh/Hammaam","Bathroom",R.raw.six));
        words.add(new WordClass("غُرْفَةُ النَّوْم","Gurfatun Nowm","Bedroom",R.raw.seven));
        words.add(new WordClass("أثَاث","Athaath","Furniture",R.raw.eight));
        words.add(new WordClass("مَمَرَّات / مَمَرّ ","Mamarr, Mamarraat","Hallway",R.raw.nine));
        words.add(new WordClass("سَلَالِم","Salaalim","Stairs",R.raw.one));
        words.add(new WordClass("أرَائِك / أرِيْكَة ","Areekah, Araa’ik","Sofa",R.raw.one));
        words.add(new WordClass("شَبَابِيْك / شُبَّاك ","Shubbaak, Shabaabeek","Window, Windows",R.raw.one));
        words.add(new WordClass("كَرَاسِي / كُرْسِي ","Kursee, Karaasee","Chair, Chairs",R.raw.one));
        words.add(new WordClass("سَرَائِر / سَرِيْر ","Sareer, Saraa’ir","Bed, Beds",R.raw.one));
        words.add(new WordClass("غَسَّالَات / غَسَّالَة ","Gassaalha, Gassaalaat   ","Washing Machine, Washing machines",R.raw.one));
        words.add(new WordClass("غَسَّالَة صُحُون","Gassaalat Suhoon","Dishwasher",R.raw.one));
        words.add(new WordClass("ثَلَاجَات / ثَلَاجَة ","Thalaajah, Thalaajaat","Fridge, Fridges",R.raw.one));
        words.add(new WordClass("فَرن","Farn","Oven",R.raw.one));
        words.add(new WordClass("سَجَّاد / سَجَّادَة ","Sajjaadah, Sajjaad ","Carpet, Carpets",R.raw.one));

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

                mMediaPlayer=MediaPlayer.create(House.this,wordClass.getAudioResourceId());
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
