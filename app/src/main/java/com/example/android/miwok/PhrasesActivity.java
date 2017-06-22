package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener mCmpletionListener=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        final ArrayList<Word> phrases=new ArrayList<Word>( );
        phrases.add(new Word("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
        phrases.add(new Word("What is your name?","tinne wuksus",R.raw.phrase_what_is_your_name));
        phrases.add(new Word("My Name is..","oyaaset",R.raw.phrase_my_name_is));
        phrases.add(new Word("How are you feeling?","michekses?",R.raw.phrase_how_are_you_feeling));
        phrases.add(new Word("I'm feeling good.","kuchi achit",R.raw.phrase_im_feeling_good));
        phrases.add(new Word("Are you coming?","eenes'aa?",R.raw.phrase_are_you_coming));
        phrases.add(new Word("Yes, I'm coming","hee'eenem",R.raw.phrase_im_coming));
        phrases.add(new Word("I'm coming","eenem",R.raw.phrase_im_coming));
        phrases.add(new Word("Let's go.","yoowutis",R.raw.phrase_lets_go));
        phrases.add(new Word("Come here","enni'nem",R.raw.phrase_come_here));

        WordAdapter phraseAdapter = new WordAdapter(this, phrases,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(phraseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word=phrases.get(i);
                 mediaPlayer=MediaPlayer.create(PhrasesActivity.this,word.getAudioResourceId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCmpletionListener);
            }
        });
}
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }

}


