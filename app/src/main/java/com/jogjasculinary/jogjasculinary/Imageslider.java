package com.jogjasculinary.jogjasculinary;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Imageslider extends AppCompatActivity {
    private ViewPager viewPager;
    private SlideAdapter myadapter;
    private Button buttonChange;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_slider);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        myadapter = new SlideAdapter(this);
        viewPager.setAdapter(myadapter);

        buttonChange = findViewById(R.id.changeActivity);

        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Imageslider.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

}





