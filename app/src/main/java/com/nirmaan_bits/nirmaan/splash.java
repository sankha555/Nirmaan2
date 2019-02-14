package com.nirmaan_bits.nirmaan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splash extends AppCompatActivity {
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        iv = (ImageView) findViewById(R.id.image);
        Animation myAnim= AnimationUtils.loadAnimation(this,R.anim.anm);
    iv.startAnimation(myAnim);
    final Intent i =new Intent(this,MainActivity.class);
    Thread timer = new Thread(){
        public void run(){
            try {
                sleep(2000);
            }
            catch (InterruptedException e){
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