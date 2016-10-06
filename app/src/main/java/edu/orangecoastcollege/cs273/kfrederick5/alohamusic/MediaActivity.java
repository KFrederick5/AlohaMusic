package edu.orangecoastcollege.cs273.kfrederick5.alohamusic;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MediaActivity extends AppCompatActivity {

    private MediaPlayer ukuleleMP;
    private MediaPlayer ipuMP;

    private Button ukuleleButton;
    private Button ipuButton;
    private Button hulaButton;

    private VideoView hulaVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        ukuleleButton = (Button) findViewById(R.id.ukuleleButton);
        ipuButton = (Button) findViewById(R.id.ipuButton);
        hulaButton = (Button) findViewById(R.id.hulaButton);

        hulaVideoView = (VideoView) findViewById(R.id.hulaVideoView);
        hulaVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName()
                + "/" + R.raw.hula));
        hulaVideoView.setMediaController(new MediaController(this));

        //Associate the media player objects with the raw files
        ukuleleMP = MediaPlayer.create(this, R.raw.ukulele);
        ipuMP = MediaPlayer.create(this, R.raw.ipu);

        //Associate the media player object with the hula video


    }

    public void playMedia (View v)
    {
        //Determine which button is clicked:

        switch(v.getId())
        {
            case R.id.ukuleleButton:
                if(ukuleleMP.isPlaying())
                {
                    ukuleleMP.pause();
                    //Show the other two buttons (ipu and hula)
                    ipuButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                    ukuleleButton.setText(R.string.ukulele_button_play_text);
                }
                else
                {
                    ukuleleMP.start();
                    ipuButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                    ukuleleButton.setText(R.string.ukulele_button_pause_text);
                }
                break;
            case R.id.ipuButton:
                if(ipuMP.isPlaying())
                {
                    ipuMP.pause();
                    //Show the other two buttons (ipu and hula)
                    ukuleleButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                    ipuButton.setText(R.string.ipu_button_play_text);
                }
                else
                {
                    ipuMP.start();
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                    ipuButton.setText(R.string.ipu_button_pause_text);
                }
                break;

            case R.id.hulaButton:
                if(hulaVideoView.isPlaying())
                {
                    hulaVideoView.pause();
                    //Show the other two buttons (ipu and hula)
                    ukuleleButton.setVisibility(View.VISIBLE);
                    ipuButton.setVisibility(View.VISIBLE);
                    hulaButton.setText(R.string.hula_button_watch_text);
                }
                else
                {
                    hulaVideoView.start();
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    ipuButton.setVisibility(View.INVISIBLE);
                    hulaButton.setText(R.string.hula_button_pause_text);
                }
        }
    }
}
