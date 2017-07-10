package com.samples.res.frameanimationImageview;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FrameAnimationActivity extends AppCompatActivity
        implements View.OnClickListener{

    private final static int DURATION = 300;
    private AnimationDrawable animation;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);

        imageView = (ImageView)findViewById(R.id.image);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_start:
                start();
                break;
            case R.id.btn_stop:
                stop();
                break;
        }
    }

    private void stop() {
        BitmapDrawable frame1 =
                (BitmapDrawable)getResources().getDrawable(R.drawable.android1);
        BitmapDrawable frame2 =
                (BitmapDrawable)getResources().getDrawable(R.drawable.android2);
        BitmapDrawable frame3 =
                (BitmapDrawable)getResources().getDrawable(R.drawable.android3);
        animation = new AnimationDrawable();
        animation.setOneShot(false);
        animation.addFrame(frame1, DURATION);
        animation.addFrame(frame2, DURATION);
        animation.addFrame(frame3, DURATION);
        imageView.setBackgroundDrawable(animation);
        animation.setVisible(true,true);
        animation.start();
    }

    private void start() {
        animation.stop();
        animation.setVisible(false,false);
    }
}
