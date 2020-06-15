package com.jaime.easit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager.widget.ViewPager;

public class WizardEasit extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;
    private SliderIntroAdapter sliderIntroAdap;
    private Button prevBtn,nBtn,getstartedbtn;
    private int mCurrentPage;
    private Animation getstartedanim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if(restorePrefData()){
            startActivity(new Intent(WizardEasit.this,MenuDespegable.class));
            finish();
        }
        setContentView(R.layout.activity_wizard);
        mSlideViewPager = findViewById(R.id.slideViewPager);
        mDotLayout = findViewById(R.id.dotsLayout);
        sliderIntroAdap = new SliderIntroAdapter(this);
        prevBtn=findViewById(R.id.previousBtn);
        nBtn=findViewById(R.id.nextBtn);
        getstartedbtn=findViewById(R.id.getStartedBtn);

        mSlideViewPager.setAdapter(sliderIntroAdap);
        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);

        nBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage+1);
            }
        });

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage-1);
            }
        });

    }

    private boolean restorePrefData() {
        SharedPreferences pref= getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroOpenedBefore=pref.getBoolean("isIntroOpened",false);
        return isIntroOpenedBefore;
    }

    public void addDotsIndicator(int position) {
        mDots = new TextView[10];
        mDotLayout.removeAllViews();
        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(nBtn.getCurrentTextColor());
            mDotLayout.addView(mDots[i]);
        }

        if(mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }

    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
        addDotsIndicator(i);
        mCurrentPage=i;

        if (i==0){
            nBtn.setEnabled(true);
            prevBtn.setEnabled(false);
            prevBtn.setVisibility(View.INVISIBLE);
            getstartedbtn.setVisibility(View.INVISIBLE);
            getstartedbtn.setEnabled(false);



            nBtn.setText("Next");
            prevBtn.setText("");

        } else if(i== mDots.length-1 ){
            nBtn.setEnabled(true);
            prevBtn.setEnabled(true);
            prevBtn.setVisibility(View.VISIBLE);
            nBtn.setVisibility(View.INVISIBLE);
            getstartedbtn.setVisibility(View.VISIBLE);
            getstartedbtn.setEnabled(true);
            getstartedanim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animciongetstarted);
            getstartedbtn.setAnimation(getstartedanim);

            prevBtn.setText("Back");
            getstartedbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(WizardEasit.this,MenuDespegable.class));
                    savePrefsData();
                    finish();
                }
            });

        }else {
            nBtn.setEnabled(true);
            prevBtn.setEnabled(true);
            prevBtn.setVisibility(View.VISIBLE);
            nBtn.setVisibility(View.VISIBLE);
            getstartedbtn.setVisibility(View.INVISIBLE);
            getstartedbtn.setEnabled(false);

            nBtn.setText("Next");
            prevBtn.setText("Back");
        }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private void savePrefsData() {
        SharedPreferences pref= getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putBoolean("isIntroOpened",true);
        editor.commit();

    }

}
