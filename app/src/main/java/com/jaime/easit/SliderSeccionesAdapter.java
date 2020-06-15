package com.jaime.easit;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
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

import java.util.Locale;

public class SliderSeccionesAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    int[] slide_Images;
    String[] slide_headings;
    String[] slide_description;
    String[] slide_url;
    ConstraintLayout cd_app;
    int positionR;
    Button mDescBtn;
    CardView cardview;
    PreferencesHelper preferencesHelper;
    PreferencesModel model;


    public SliderSeccionesAdapter(Context context, int[] slide_Images, String[] slide_headings, String[] slide_description, String[]slide_url) {
        this.context = context;
        this.slide_Images = slide_Images;
        this.slide_headings = slide_headings;
        this.slide_description = slide_description;
        this.slide_url = slide_url;

    }


    @Override
    public int getCount() {
        return slide_headings.length;
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

        this.model = preferencesHelper.loadPreferences(context);
        String lang = this.model.lang;

        if (this.model.lang.equals("en")) {
            Locale locale = new Locale("en");
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            context.getResources().updateConfiguration(config,
                    context.getResources().getDisplayMetrics());

        }
        else  {

            Locale locale = new Locale("");
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            context.getResources().updateConfiguration(config,
                    context.getResources().getDisplayMetrics());

        }
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_secciones_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_description);
        mDescBtn = view.findViewById(R.id.descarga_btn);
        cardview = (CardView) view.findViewById(R.id.cd_total);
        cd_app = (ConstraintLayout) view.findViewById(R.id.cd_app);
        slideImageView.setImageResource(slide_Images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_description[position]);


        mDescBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String appPackageName = context.getPackageName(); // getPackageName() from Context or Activity object
                try {
                    Intent intent=(new Intent(Intent.ACTION_VIEW, Uri.parse(slide_url[position].toString())));
                    v.getContext().startActivity(intent);

                } catch (android.content.ActivityNotFoundException anfe) {
                    Intent intent=(new Intent(Intent.ACTION_VIEW, Uri.parse(slide_url[position].toString())));
                    v.getContext().startActivity(intent);
                }

            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Funcion.setCountVecesEntrada(0);
                Intent intent = new Intent(v.getContext(), Funcion.class);
                intent.putExtra("App", slide_headings[position]);
                intent.putExtra("Image", slide_Images[position]);
                v.getContext().startActivity(intent);


            }
        });


        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
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

}

