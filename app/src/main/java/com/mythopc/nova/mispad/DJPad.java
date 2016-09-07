package com.mythopc.nova.mispad;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class DJPad extends AppCompatActivity implements View.OnClickListener {

    Button song1Start, song1Stop, song2Start, song2Stop;
    TextView song1, song2;
    String r1, r2;
    SoundPool sp;
    MediaPlayer mediaPlayer1;
    MediaPlayer mediaPlayer2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_djpad);

        song1Start = (Button)findViewById(R.id.song1buttonstart);
        song1Stop  = (Button)findViewById(R.id.song1buttonstop);
        song2Start = (Button)findViewById(R.id.song2buttonstart);
        song2Stop = (Button)findViewById(R.id.song2buttonstop);

        song1 = (TextView)findViewById(R.id.song1);
        song2 = (TextView)findViewById(R.id.song2);

        Intent i = getIntent();
        r1 = i.getStringExtra("filename1");
        r2 = i.getStringExtra("filename2");

        song1.setText(r1);
        song2.setText(r2);

        song1Start.setOnClickListener(this);
        song2Start.setOnClickListener(this);
        song1Stop.setOnClickListener(this);
        song2Stop.setOnClickListener(this);







    }

    public void onClick(View view) {
        if(view == song1Start) {
            mediaPlayer1 = new MediaPlayer();
            mediaPlayer1.setAudioStreamType(AudioManager.STREAM_MUSIC);
            try {
                mediaPlayer1.setDataSource(r1);
                mediaPlayer1.prepare();
            } catch (IOException e) {

            }
            mediaPlayer1.start();
        }


        if(view == song2Start) {
            mediaPlayer2 = new MediaPlayer();
            mediaPlayer2.setAudioStreamType(AudioManager.STREAM_RING);
            try {
                mediaPlayer2.setDataSource(r2);
                mediaPlayer2.prepare();
            }
            catch (IOException e) {

            }
            mediaPlayer2.start();
        }

        if(view == song1Stop) {
            mediaPlayer1.stop();
        }

        if(view == song2Stop) {
            mediaPlayer2.stop();
        }

    }

    public void onBackPressed() {
        finish();
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}
