package com.example.yuechu.page_yuechu;




import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.yuechu.R;

import java.io.File;


public class sc2Activity extends Activity {


    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sc2);

        //本地的视频  需要在手机SD卡根目录添加一个视频
        String videoUrl1 = Environment.getExternalStorageDirectory().getPath() + "/sdcard/ms.mp4";//不知道哪错了


        //网络视频
        String videoUrl2 = Utils.videoUrl;


        Uri uri = Uri.parse(videoUrl2);

        videoView = (VideoView) this.findViewById(R.id.videoView);

        //设置视频控制器
        videoView.setMediaController(new MediaController(this));

        //播放完成回调
        videoView.setOnCompletionListener(new MyPlayerOnCompletionListener());

        //设置视频路径
        videoView.setVideoURI(uri);

        //开始播放视频
        videoView.start();
    }

    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            Toast.makeText(sc2Activity.this, "播放完成了", Toast.LENGTH_SHORT).show();
        }
    }

    public static class Utils {

        public static final String videoUrl = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
    }

}
