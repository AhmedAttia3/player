package com.example.mytestapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import tv.danmaku.ijk.media.example.activities.VideoActivity;
import tv.danmaku.ijk.media.example.widget.media.IjkVideoView;

public class MainActivity extends AppCompatActivity {
    IjkVideoView ijkVideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        VideoActivity.intentTo(this, "http://apk2tv.zalhd.net:20002/live/ZHD13/ZHD13/224.ts", "f");
        ijkVideoView = findViewById(R.id.video_view);
        ijkVideoView.setVideoPath("http://apk2tv.zalhd.net:20002/live/ZHD13/ZHD13/224.ts");
        ijkVideoView.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if ( !ijkVideoView.isBackgroundPlayEnabled()) {
            ijkVideoView.stopPlayback();
            ijkVideoView.release(true);
            ijkVideoView.stopBackgroundPlay();
        } else {
            ijkVideoView.enterBackground();
        }
    }
}
