package com.jaime.easit;


import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SlideFuncionalidadesAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<String> slide_Images;

    ArrayList<String> slide_description;

    ConstraintLayout cd_app;
    int positionR;
    Button mDescBtn;
    CardView cardview;


    public SlideFuncionalidadesAdapter(Context context, ArrayList<String> slide_Images, ArrayList<String>slide_description) {
        this.context = context;
        this.slide_Images = slide_Images;
        this.slide_description = slide_description;


    }


    @Override
    public int getCount() {
        return slide_description.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            context.setTheme(R.style.darkTheme);
        } else context.setTheme(R.style.lightTheme);
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_funcionalidades_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_funcionalidad);
        slideDescription.setMovementMethod(new ScrollingMovementMethod());
        cardview = (CardView) view.findViewById(R.id.cd_total);
        cd_app = (ConstraintLayout) view.findViewById(R.id.cd_app);
        Picasso.get().load(slide_Images.get(position)).into(slideImageView);
        String f=slide_description.get(position);
        slideDescription.setText(slide_description.get(position));


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
/*
    @Override
    public void onClick(View v) {
         {
          if(getPageTitle(getCount()).toString().equalsIgnoreCase("WhatsApp")){
              Intent readMore = new Intent(v.getContext(), Info.class);
              v.getContext().startActivity(readMore);
          }
        }
    }

 */

