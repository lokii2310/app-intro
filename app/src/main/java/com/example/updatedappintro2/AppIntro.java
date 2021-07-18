package com.example.updatedappintro2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import com.github.appintro.AppIntroFragment;
import com.github.appintro.AppIntroPageTransformerType;

import org.jetbrains.annotations.Nullable;

public class AppIntro extends com.github.appintro.AppIntro
{

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_app_intro);

        String title;
        int backgroundColor;
        int imageDrawable;
        Object backgroundDrawable;

        String description;


        addSlide(AppIntroFragment.newInstance(
                title = "Period Tracker",
                description = "A description that will be shown on the bottom",
                R.drawable.calender, Color.rgb(225, 108, 108), Color.rgb(102, 102, 102)));


        addSlide(AppIntroFragment.newInstance(
                title = "Counselling Booking",
                description = "A description that will be shown on the bottom",
                R.drawable.doc, Color.rgb(58, 137, 255), Color.rgb(102, 102, 102)));

        addSlide(AppIntroFragment.newInstance(
                title = "Live Video Meeting",
                description = "A description that will be shown on the bottom",
                R.drawable.meet, Color.rgb(110, 255, 100), Color.rgb(102, 102, 102)));


        addSlide(AppIntroFragment.newInstance(
                title = "Maps",
                description = "A description that will be shown on the bottom",
                R.drawable.map, Color.rgb(255, 173, 100), Color.rgb(102, 102, 102)));


        showStatusBar(true);
        setStatusBarColor(Color.rgb(102, 102, 102));

        sharedPreferences=getApplicationContext().getSharedPreferences("Mypreferences", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if(sharedPreferences!=null)
        {
            boolean checkShared=sharedPreferences.getBoolean("checkStated",false);
            if(checkShared)
            {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        }

    }

    @Override
    protected void onSkipPressed(@Nullable Fragment currentFragment) {
        super.onSkipPressed(currentFragment);

        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        editor.putBoolean("checkStated",false).commit();
        finish();
    }


    @Override
    protected void onDonePressed(@Nullable Fragment currentFragment) {
        super.onDonePressed(currentFragment);

        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        editor.putBoolean("checkStated",true).commit();
        finish();
    }
}