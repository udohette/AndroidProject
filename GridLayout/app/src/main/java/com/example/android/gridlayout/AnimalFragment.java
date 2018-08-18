package com.example.android.gridlayout;


import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.app.Activity.DEFAULT_KEYS_SEARCH_LOCAL;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalFragment extends Fragment {
    private MediaPlayer mediaPlayer;
    private AudioManager mAudioManger;
    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaplayer();
            }
        }
    };
    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaplayer();
        }
    };

    public AnimalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_greetings__etiquette, container, false);

        final ArrayList<EfikPhrase> animals = new ArrayList<EfikPhrase>();
        animals.add(new EfikPhrase("Animals", "Unam Ikɔt"));
        animals.add(new EfikPhrase("Bird", "Inuen"));
        animals.add(new EfikPhrase("Cat", "Anwa"));
        animals.add(new EfikPhrase("Cattle", "Ufene"));
        animals.add(new EfikPhrase("Chicken", "Unen"));
        animals.add(new EfikPhrase("Cow", "Enaŋ"));
        animals.add(new EfikPhrase("Dog", "Ebua"));
        animals.add(new EfikPhrase("Female", "Uman"));
        animals.add(new EfikPhrase("Fish", "Iyak"));
        animals.add(new EfikPhrase("Goat", "Ebot"));
        animals.add(new EfikPhrase("Lion", "Ekpe"));
        animals.add(new EfikPhrase("Male", "Ayara"));
        animals.add(new EfikPhrase("Python", "Asabɔ"));
        animals.add(new EfikPhrase("Sheep", "Erɔŋ"));
        animals.add(new EfikPhrase("Snake", "Urukikot"));
        animals.add(new EfikPhrase("Tortoise", "Ikut"));
        animals.add(new EfikPhrase("Meat", "Unam"));
        EfikeAdapter adapter = new EfikeAdapter(getActivity(), animals, R.color.Category_Animals);
        ListView listView = (ListView) rootView.findViewById(R.id.list_view);
        assert listView != null;
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaplayer();
                EfikPhrase word = animals.get(i);
                mediaPlayer = MediaPlayer.create(getActivity(), word.getmAudioResource());
                // Request audio focus so in order to play the audio file. The app needs to play a
                // short audio file, so we will request audio focus with a short amount of time
                // with AUDIOFOCUS_GAIN_TRANSIENT.
                int result = mAudioManger.requestAudioFocus(mAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                //Start the Audio File;
                mediaPlayer.start();
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    //We Have Audio Focus Now;

                    // Setup a listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing.
                    mediaPlayer.setOnCompletionListener(completionListener);
                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current word
                    mediaPlayer = (MediaPlayer.create(getActivity(), word.getmAudioResource()));
                    // Start the audio File
                    mediaPlayer.start();
                    // Setup a listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing.
                    mediaPlayer.setOnCompletionListener(completionListener);
                }
            }
        });
        return rootView;
    }


    private void releaseMediaplayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManger.abandonAudioFocus(mAudioFocusChangeListener);
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflate = getActivity().getMenuInflater();
//        inflate.inflate(R.menu.filter_menu, menu);
//        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView = (SearchView) menu.findItem(R.id.searchView2).getActionView();
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
//        searchView.setIconifiedByDefault(true);
//        getActivity().setDefaultKeyMode(DEFAULT_KEYS_SEARCH_LOCAL);
//        return true;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}

