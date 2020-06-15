package com.jaime.easit;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.Locale;

public class Secciones extends AppCompatActivity {

    private ViewPager slideViewPager;
    LinearLayout slideDoots;
    SliderSeccionesAdapter sliderSeccionesAdapter;
    private TextView[] mDots;
    private int currentPage;
    static int[] slide_Images;
    static String[] slide_headings, slide_description, slide_urls;
    static Button mNextBtn, mBackBtn;
    Context mcontext;
    int color, colorAcento;
    TextView coloresTxt;
    String[] title;
    ArrayList<Model> arrayList = new ArrayList<Model>();
    int[] icon;
    ListView listView;
    ListaBuscadorAdapter adapter;
    int count = 0;
    static int countVecesEntrada = 0;
    static int[] slide_imagesEntrada;
    static int[] slide_imagesSalida;
    PreferencesHelper preferencesHelper;
    PreferencesModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ponerColorModo(); //Llamamos al metodo para poner el tema de la app oscuro/claro
        mcontext = getApplicationContext();
        this.model = preferencesHelper.loadPreferences(mcontext);
        String lang = this.model.lang;




        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_secciones);

        // Inicializamos variables

        slideViewPager = (ViewPager) findViewById(R.id.slide_ViewPager);
        slideDoots = (LinearLayout) findViewById(R.id.Doots);
        mNextBtn = (Button) findViewById(R.id.next_btn);
        mBackBtn = (Button) findViewById(R.id.previus_btn);
        coloresTxt = (TextView) findViewById(R.id.colores_txt);


        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(mNextBtn.getCurrentTextColor(), PorterDuff.Mode.SRC_ATOP);

        Toolbar toolbar = findViewById(R.id.toolbarSecciones);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Estas variable nos sirve para poder cambiar el color a los puntos ya que al ser html no podemos meterles directamente el color del tema(claro/oscuro)
        colorAcento = coloresTxt.getCurrentTextColor();
        color = mNextBtn.getCurrentTextColor();


        if (countVecesEntrada == 0) {


            slide_Images = (int[]) getIntent().getSerializableExtra("listaImagenes");
            slide_headings = (String[]) getIntent().getSerializableExtra("listaHeaders");
            slide_description = (String[]) getIntent().getSerializableExtra("listaDescripciones");
            slide_urls = (String[]) getIntent().getSerializableExtra("listaUrls");
            countVecesEntrada++;

        } else if (slide_Images != null) {
            countVecesEntrada++;
        }


        sliderSeccionesAdapter = new SliderSeccionesAdapter(this, slide_Images, slide_headings, slide_description, slide_urls);
        slideViewPager.setAdapter(sliderSeccionesAdapter);

        addDootsIndicator(0);

        slideViewPager.addOnPageChangeListener(viewListner);


        //OnclickListner
        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideViewPager.setCurrentItem(currentPage + 1);
            }
        });

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideViewPager.setCurrentItem(currentPage - 1);
            }
        });


    }

    private void ponerColorModo() {

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darkTheme);
            count++;
        } else setTheme(R.style.lightTheme);
    }

    // Este metodo nos sirve para crear y resaltar el color de los puntos segun en que pagina estemos
    public void addDootsIndicator(int position) {
        mDots = new TextView[slide_Images.length];
        slideDoots.removeAllViews();
        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(color);
            slideDoots.addView(mDots[i]);

        }
        if (mDots.length > 0) {
            mDots[position].setTextColor(colorAcento);
        }
    }

    ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int i, float positionOffset, int positionOffsetPixels) {

        }

        // Ponemos y cambiamos entre Next, Back ,""
        @Override
        public void onPageSelected(int position) {
            addDootsIndicator(position);
            currentPage = position;

            if (position == 0) {
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
                mBackBtn.setVisibility(View.INVISIBLE);
                mNextBtn.setText("Next");
                mBackBtn.setText("");

            } else if (position == mDots.length - 1) {
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mNextBtn.setText("Finish");
                mBackBtn.setText("Back");
            } else {

                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mNextBtn.setText("Next");
                mBackBtn.setText("Back");

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    // Ponemos el toolbar con buscador que tienen todas la clases
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_search) {
            Funcion.setCountVecesEntrada(0);
            Intent i = new Intent(mcontext, ListaBuscador.class);
            startActivityForResult(i, 0);
        }
        return super.onOptionsItemSelected(item);
    }

    public static int getCountVecesEntrada() {
        return countVecesEntrada;
    }

    public static void setCountVecesEntrada(int countVecesEntrada) {
        Secciones.countVecesEntrada = countVecesEntrada;
    }


}
