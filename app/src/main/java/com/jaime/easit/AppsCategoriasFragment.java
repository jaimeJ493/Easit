package com.jaime.easit;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class AppsCategoriasFragment extends Fragment implements View.OnClickListener {
    CardView cardComu, cardMusica, cardNavega, cardEntre, cardSocial, cardCompras;//carviews
    Context mcontext;
    Intent intent;
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    View rootView;
    RecyclerView recyclerView;
    PreferencesHelper preferencesHelper;
    PreferencesModel model;
    String[] slide_description, slide_description_s, slide_description_m, slide_description_e, slide_description_c, slide_description_n;


    //Variable para cambiar ingles y español
    String descZoom;

    android.content.res.Resources res;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_apps, container, false);

        // Inicializamos todas las variables y las hacemos clickeables
        mcontext = getActivity().getApplicationContext();
        this.model = preferencesHelper.loadPreferences(mcontext);
        this.model = preferencesHelper.loadPreferences(mcontext);
        String lang = this.model.lang;

        if (this.model.lang.equals("en")) {
            Locale locale = new Locale("en");
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            mcontext.getResources().updateConfiguration(config,
                    mcontext.getResources().getDisplayMetrics());

        }
        else  {
            Locale locale = new Locale("");
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            mcontext.getResources().updateConfiguration(config,
                    mcontext.getResources().getDisplayMetrics());

        }


        intent = new Intent(mcontext, Secciones.class);

        //Incializamos los String[] para que puedan variar si la app esta en español o en ingles
        slide_description = getResources().getStringArray(R.array.desc_c);
        slide_description_c = getResources().getStringArray(R.array.desc_com);
        slide_description_e = getResources().getStringArray(R.array.desc_e);
        slide_description_m = getResources().getStringArray(R.array.desc_m);
        slide_description_n = getResources().getStringArray(R.array.desc_n);
        slide_description_s = getResources().getStringArray(R.array.desc_s);


        cardComu = (CardView) rootView.findViewById(R.id.cd_comu);
        cardMusica = (CardView) rootView.findViewById(R.id.cd_musica);
        cardNavega = (CardView) rootView.findViewById(R.id.cd_navegacion);
        cardEntre = (CardView) rootView.findViewById(R.id.cd_entre);
        cardSocial = (CardView) rootView.findViewById(R.id.cd_social);
        cardCompras = (CardView) rootView.findViewById(R.id.cd_compras);

        LinearLayout ly_musica = rootView.findViewById(R.id.Ly_musica);
        LinearLayout ly_compras = rootView.findViewById(R.id.Ly_compras);
        LinearLayout ly_social = rootView.findViewById(R.id.Ly_social);
        LinearLayout ly_entre = rootView.findViewById(R.id.Ly_entre);
        LinearLayout ly_nave = rootView.findViewById(R.id.Ly_navegacion);
        LinearLayout ly_comu = rootView.findViewById(R.id.Ly_comu);
        TextView maspopulares = rootView.findViewById(R.id.textViewMaspopulares);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerviewTopApps);

        if (lang.equalsIgnoreCase("en")) {
            ly_musica.setBackground(getResources().getDrawable(R.drawable.degradadomusicaingles));
            ly_compras.setBackground(getResources().getDrawable(R.drawable.degradadocomprasingles));
            ly_entre.setBackground(getResources().getDrawable(R.drawable.degradoentreingles));
            ly_nave.setBackground(getResources().getDrawable(R.drawable.degradadonavegacioningles));
            ly_comu.setBackground(getResources().getDrawable(R.drawable.degradadocomunicacioningles));
            ly_social.setBackground(getResources().getDrawable(R.drawable.degradadosocial));
            maspopulares.setText("Trending Apps:");
        } else {

            ly_musica.setBackground(getResources().getDrawable(R.drawable.musica_cardview));
            ly_compras.setBackground(getResources().getDrawable(R.drawable.degradadocompras));
            ly_entre.setBackground(getResources().getDrawable(R.drawable.degradadoentretenimiento));
            ly_nave.setBackground(getResources().getDrawable(R.drawable.degradadonavegacion));
            ly_comu.setBackground(getResources().getDrawable(R.drawable.degradadocomunicacion));
            ly_social.setBackground(getResources().getDrawable(R.drawable.degradadosocial));
        }
        cardComu.setOnClickListener(this);
        cardMusica.setOnClickListener(this);
        cardNavega.setOnClickListener(this);
        cardEntre.setOnClickListener(this);
        cardSocial.setOnClickListener(this);
        cardCompras.setOnClickListener(this);
        initImageHitmaps();
        return rootView;
    }


    /*----------------------------------------Arrays inicializadores------------------------------------------*/

    //Arrays Comunicacion

    public int[] slide_Images = {
            R.drawable.whatsapp,
            R.drawable.zoom,
            R.drawable.telegram,
            R.drawable.skype,
            R.drawable.googlemeet
    };
    public String[] slide_headings = {
            "WhatsApp",
            "Zoom",
            "Telegram",
            "Skype",
            "Google Meet",
    };

    public String[] slide_url = {
            "https://play.google.com/store/apps/details?id=com.whatsapp",
            "https://play.google.com/store/apps/details?id=us.zoom.videomeetings",
            "https://play.google.com/store/apps/details?id=org.telegram.messenger",
            "https://play.google.com/store/apps/details?id=com.skype.raider",
            "https://play.google.com/store/apps/details?id=com.google.android.apps.meetings&gl=ES"
    };

    //Arrays Entretenimiento


    public int[] slide_Images_e = {
            R.drawable.youtube,
            R.drawable.twitch,
            R.drawable.netflix,
            R.drawable.hbo,
          //  R.drawable.primevideo

    };
    public String[] slide_headings_e = {
            "Youtube",
            "Twitch",
            "Netflix",
            "HBO",
           // "Amazon Prime Video"
    };


    public String[] slide_url_e = {
            "https://play.google.com/store/apps/details?id=com.google.android.youtube&gl=ES",
            "https://play.google.com/store/apps/details?id=tv.twitch.android.app&gl=ES",
            "https://play.google.com/store/apps/details?id=com.netflix.mediaclient&gl=ES",
            "https://play.google.com/store/apps/details?id=com.hbo.android.app&gl=ES",
        //    "https://play.google.com/store/apps/details?id=com.amazon.avod.thirdpartyclient&gl=ES"
    };

    //Arrays Social

    public int[] slide_Images_s = {
            R.drawable.instagram,
            R.drawable.facebook,
          //  R.drawable.snapchat,
            R.drawable.twitter,
            R.drawable.linkedin
    };
    public String[] slide_headings_s = {
            "Instagram",
            "Facebook",
           // "Snapchat",
            "Twitter",
            "LinkedIn"
    };


    public String[] slide_url_s = {
            "https://play.google.com/store/apps/details?id=com.instagram.android&gl=ES",
            "https://play.google.com/store/search?q=facebook&c=apps&gl=ES",
          //  "https://play.google.com/store/apps/details?id=com.snapchat.android&gl=ES",
            "https://play.google.com/store/apps/details?id=com.twitter.android&gl=ES",
            "https://play.google.com/store/apps/details?id=com.linkedin.android&gl=ES"
    };

    //Arrays Musica

    public int[] slide_Images_m = {
            R.drawable.spotify,
            R.drawable.amazonmusic,
            R.drawable.youtubemusic,
            R.drawable.shazam,
           // R.drawable.pandora
    };
    public String[] slide_headings_m = {
            "Spotify",
            "Amazon Prime Music",
            "YouTube Music",
            "Shazam",
           // "Pandora"
    };


    public String[] slide_url_m = {
            "https://play.google.com/store/apps/details?id=com.spotify.music",
            "https://play.google.com/store/apps/details?id=com.amazon.mp3",
            "https://play.google.com/store/apps/details?id=com.google.android.apps.youtube.music",
            "https://play.google.com/store/apps/details?id=com.shazam.android",
           // "https://play.google.com/store/apps/details?id=com.pandora.android"
    };
    //Arrays Navegacion

    public int[] slide_Images_n = {
            R.drawable.waze,
            R.drawable.uber,
            R.drawable.lyft,
            R.drawable.googlemaps
    };
    public String[] slide_headings_n = {
            "Waze",
            "Uber",
            "Lyft",
            "Google Maps"
    };

    public String[] slide_url_n = {
            "https://play.google.com/store/apps/details?id=com.waze",
            "https://play.google.com/store/apps/details?id=com.ubercab",
            "https://play.google.com/store/apps/details?id=me.lyft.android",
            "https://play.google.com/store/apps/details?id=com.google.android.apps.maps"
    };

    //Arrays Compras

    public int[] slide_Images_c = {
            R.drawable.wish,
            R.drawable.amazon,
            R.drawable.ebay,
            R.drawable.alibaba
    };
    public String[] slide_headings_c = {
            "Wish",
            "Amazon",
            "Ebay",
            "Alibaba"
    };


    public String[] slide_url_c = {
            "https://play.google.com/store/apps/details?id=com.contextlogic.wish",
            "https://play.google.com/store/apps/details?id=com.amazon.mShop.android.shopping",
            "https://play.google.com/store/apps/details?id=com.ebay.mobile",
            "https://play.google.com/store/apps/details?id=com.alibaba.intl.android.apps.poseidon"
    };

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.cd_comu:
                Cambiar_Secciones_Comu();
                break;
            case R.id.cd_entre:
                Cambiar_Secciones_entre();
                break;
            case R.id.cd_social:
                Cambiar_Secciones_social();
                break;
            case R.id.cd_musica:
                Cambiar_Secciones_musica();
                break;
            case R.id.cd_navegacion:
                Cambiar_Secciones_navegacion();
                break;
            case R.id.cd_compras:
                Cambiar_Secciones_compras();
                break;

        }
    }

    private void Cambiar_Secciones_compras() {

        Secciones.setCountVecesEntrada(0);
        intent.putExtra("listaImagenes", slide_Images_c);
        intent.putExtra("listaHeaders", slide_headings_c);
        intent.putExtra("listaDescripciones", slide_description_c);
        intent.putExtra("listaUrls", slide_url_c);

        startActivityForResult(intent, 0);
    }

    private void Cambiar_Secciones_navegacion() {
        Secciones.setCountVecesEntrada(0);
        intent.putExtra("listaImagenes", slide_Images_n);
        intent.putExtra("listaHeaders", slide_headings_n);
        intent.putExtra("listaDescripciones", slide_description_n);
        intent.putExtra("listaUrls", slide_url_n);

        startActivityForResult(intent, 0);
    }

    private void Cambiar_Secciones_musica() {
        Secciones.setCountVecesEntrada(0);
        intent.putExtra("listaImagenes", slide_Images_m);
        intent.putExtra("listaHeaders", slide_headings_m);
        intent.putExtra("listaDescripciones", slide_description_m);
        intent.putExtra("listaUrls", slide_url_m);

        startActivityForResult(intent, 0);
    }

    private void Cambiar_Secciones_Comu() {
        Secciones.setCountVecesEntrada(0);
        intent.putExtra("listaImagenes", slide_Images);
        intent.putExtra("listaHeaders", slide_headings);
        intent.putExtra("listaDescripciones", slide_description);
        intent.putExtra("listaUrls", slide_url);

        startActivityForResult(intent, 0);
    }

    private void Cambiar_Secciones_entre() {
        Secciones.setCountVecesEntrada(0);
        intent.putExtra("listaImagenes", slide_Images_e);
        intent.putExtra("listaHeaders", slide_headings_e);
        intent.putExtra("listaDescripciones", slide_description_e);
        intent.putExtra("listaUrls", slide_url_e);

        startActivityForResult(intent, 0);
    }

    private void Cambiar_Secciones_social() {
        Secciones.setCountVecesEntrada(0);
        intent.putExtra("listaImagenes", slide_Images_s);
        intent.putExtra("listaHeaders", slide_headings_s);
        intent.putExtra("listaDescripciones", slide_description_s);
        intent.putExtra("listaUrls", slide_url_s);

        startActivityForResult(intent, 0);
    }

    private void initImageHitmaps() {
        mImageUrls.add(R.drawable.netflix);
        mNames.add("Netflix");
        mImageUrls.add(R.drawable.whatsapp);
        mNames.add("WhatsApp");
        mImageUrls.add(R.drawable.instagram);
        mNames.add("Instagram");
        mImageUrls.add(R.drawable.googlemaps);
        mNames.add("Google Maps");
        mImageUrls.add(R.drawable.twitter);
        mNames.add("Twitter");
        initRecyclerView();
    }

    private void initRecyclerView() {

   /*   String orientacion = getRotation(mcontext);
        if (orientacion.equalsIgnoreCase("vertical")) {
            layoutManager = new LinearLayoutManager(mcontext, LinearLayoutManager.HORIZONTAL, false);

        } else if (orientacion.equalsIgnoreCase("horizontal")) {
            layoutManager = new LinearLayoutManager(mcontext, LinearLayoutManager.VERTICAL, false);

        }
*/
        LinearLayoutManager layoutManager = new LinearLayoutManager(mcontext, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapterTopApps adapterTopApps = new RecyclerViewAdapterTopApps(mNames, mImageUrls, mcontext);
        recyclerView.setAdapter(adapterTopApps);
        recyclerView.setHasFixedSize(true);
    }

    private void setLocale(String lang) {


        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        mcontext.getResources().updateConfiguration(config,
                mcontext.getResources().getDisplayMetrics());


        //Guardar preferencias
        model.setLang(lang);
        PreferencesHelper.savePreferences(mcontext, model);


    }

    /*
    public String getRotation(Context context) {
        final int rotation = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getOrientation();
        switch (rotation) {
            case Surface.ROTATION_0:
            case Surface.ROTATION_180:
                return "vertical";
            case Surface.ROTATION_90:
            default:
                return "horizontal";
        }
    }

     */
}
