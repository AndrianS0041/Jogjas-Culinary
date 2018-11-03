package com.jogjasculinary.jogjasculinary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splasscreen extends AppCompatActivity {
    private TextView textsplash ;
        private ImageView imagesplash ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splasscreen);
        textsplash = (TextView) findViewById(R.id.textsplash) ;
        imagesplash = (ImageView) findViewById(R.id.imagesplash);
        Animation transisisplash = AnimationUtils.loadAnimation(this,R.anim.transisisplash);
        textsplash.startAnimation(transisisplash);
        imagesplash.startAnimation(transisisplash);
        final Intent i = new Intent(this,Imageslider.class);
        Thread timer = new Thread(){
            public void run (){
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
            timer.start();
    }
}
