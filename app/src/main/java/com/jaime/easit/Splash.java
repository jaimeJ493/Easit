package com.jaime.easit;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.util.Locale;


public class Splash extends AppCompatActivity {
    private Animation animSalto, aparecer, rebote;
    TextView tVexcla, tvE, tvA, tvS, tvT, Slogan;
    private static int SPLASH_SCREEN = 5000;
    PreferencesHelper preferencesHelper;
    PreferencesModel model;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = getApplicationContext();
        this.model = preferencesHelper.loadPreferences(context);
        setLocale(this.model.lang);//Cambiamos el idioma al que se encuntra en preferencias
        configurarApp(this.model.getActivo()); //Llamamos al metodo para ver las preferencias del usuario guardadas y configurar la app en base a estas
        ponerColorModo(); //Llamamos al metodo para poner el tema de la app oscuro/claro
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        aparecer = AnimationUtils.loadAnimation(this, R.anim.aparecer);
        animSalto = AnimationUtils.loadAnimation(this, R.anim.animacion_salto);
        rebote = AnimationUtils.loadAnimation(this, R.anim.rebote2);

        tvE = findViewById(R.id.tvE);
        tvA = findViewById(R.id.tvA);
        tvS = findViewById(R.id.tvS);
        tVexcla = findViewById(R.id.tvEx);
        tvT = findViewById(R.id.tvT);
        Slogan = findViewById(R.id.slogan);

        tvE.setAnimation(aparecer);
        tvA.setAnimation(aparecer);
        tvS.setAnimation(aparecer);
        tvT.setAnimation(aparecer);
        tVexcla.setAnimation(animSalto);
        Slogan.setAnimation(rebote);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(Splash.this, WizardEasit.class));

                finish();
            }
        }, SPLASH_SCREEN);


    }
    private void configurarApp(String activo) {


        if (activo.equalsIgnoreCase("si")) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);


        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        }

    }

    private void ponerColorModo() {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darkTheme);

        } else setTheme(R.style.lightTheme);
    }

    private void setLocale(String lang) {


        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());


        //Guardar preferencias
        model.setLang(lang);
        PreferencesHelper.savePreferences(context, model);


    }
}
