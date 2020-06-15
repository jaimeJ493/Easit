package com.jaime.easit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Funcion extends AppCompatActivity {

    private static ViewPager slideViewPager;
    LinearLayout slideDoots;
    public static final String SHARED_PREFERENCE = "";
    private TextView[] mDots;
    private int currentPage;
    int[] slide_Images;
    String[] slide_headings, slide_description, slide_urls;
    static Button mNextBtn, mBackBtn;
    static Context mcontext;
    int color, colorAcento;
    TextView coloresTxt;
    String[] title;
    ArrayList<Model> arrayList = new ArrayList<Model>();
    int[] icon;
    ListView listView;
    ListaBuscadorAdapter adapter;
    int count = 0;


    TextView text;
    static ArrayList<Info> listWeb = new ArrayList<Info>();
    static ArrayList<Info> lista_info_Saliente = new ArrayList<Info>();
    static ArrayList<String> lista_funcion = new ArrayList<String>();

     static String app;
    WebScrapping.Llamada llamada;
    String url = null;
    String url1 = null;
    ArrayList<String> urls = new ArrayList<>();
    static ArrayList<String> urlFuncionalidades = new ArrayList<>();
    ArrayList<String> lista_funcionalidades = new ArrayList<>();
    ImageView imageLogo;
   static int imageUrl;
    static int countVecesEntrada =0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ponerColorModo(); //Llamamos al metodo para poner el tema de la app oscuro/claro

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionalidades);


        if(countVecesEntrada==0) {
            app = (String) getIntent().getSerializableExtra("App");
            imageUrl = (int) getIntent().getSerializableExtra("Image");
            countVecesEntrada++;
        }else if (app==null ){
            countVecesEntrada++;
        }


        mcontext = getApplicationContext();



        // Inicializamos variables
        mcontext = getApplicationContext();
        slideViewPager = (ViewPager) findViewById(R.id.slide_ViewPager);
        slideDoots = (LinearLayout) findViewById(R.id.Doots);
        mNextBtn = (Button) findViewById(R.id.next_btn);
        mBackBtn = (Button) findViewById(R.id.previus_btn);
        coloresTxt = (TextView) findViewById(R.id.colores_txt);
        imageLogo = (ImageView) findViewById(R.id.imageLogo);
        imageLogo.setImageResource(imageUrl);
        text = (TextView) findViewById(R.id.textTituloApp);
        text.setText(app);

        //Cogemos la url segun la app y se la pasamos al webscrapping


        url = getUrl(app);


        lista_funcion = listaFuncionalidades(app);//añadimos la funcionalidades de los botones
        WebScrapping.setUrl_howToUse(url);
        //Lamada la metodo asincrono para sacar la info de la url
        llamada = new WebScrapping.Llamada(getApplicationContext());
        llamada.execute();


        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(mNextBtn.getCurrentTextColor(), PorterDuff.Mode.SRC_ATOP);

        Toolbar toolbar = findViewById(R.id.toolbarSecciones);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Estas variable nos sirve para poder cambiar el color a los puntos ya que al ser html no podemos meterles directamente el color del tema(claro/oscuro)
        colorAcento = coloresTxt.getCurrentTextColor();
        color = mNextBtn.getCurrentTextColor();


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
            Intent i = new Intent(mcontext, ListaBuscador.class);
            startActivityForResult(i, 0);
        }
        return super.onOptionsItemSelected(item);
    }


    public ArrayList<String> listaFuncionalidades(String app) {


        switch (app) {
            case "WhatsApp":
                lista_funcionalidades.add(getResources().getString(R.string.whatsapp1));
                lista_funcionalidades.add(getResources().getString(R.string.whatsapp2));
                lista_funcionalidades.add(getResources().getString(R.string.whatsapp3));
                lista_funcionalidades.add(getResources().getString(R.string.whatsapp4));
                lista_funcionalidades.add(getResources().getString(R.string.whatsapp5));
                lista_funcionalidades.add(getResources().getString(R.string.whatsapp6));

                break;
            case "Zoom":
                lista_funcionalidades.add(getResources().getString(R.string.zoom1));
                lista_funcionalidades.add(getResources().getString(R.string.zoom2));
                lista_funcionalidades.add(getResources().getString(R.string.zoom3));
                lista_funcionalidades.add(getResources().getString(R.string.zoom4));
                lista_funcionalidades.add(getResources().getString(R.string.zoom5));
                lista_funcionalidades.add(getResources().getString(R.string.zoom6));
                break;

            case "Telegram":
                lista_funcionalidades.add(getResources().getString(R.string.telegram1));
                lista_funcionalidades.add(getResources().getString(R.string.telegram2));
                lista_funcionalidades.add(getResources().getString(R.string.telegram3));
                lista_funcionalidades.add(getResources().getString(R.string.telegram4));
                lista_funcionalidades.add(getResources().getString(R.string.telegram5));
                break;

            case "Skype":
                lista_funcionalidades.add(getResources().getString(R.string.skype1));
                lista_funcionalidades.add(getResources().getString(R.string.skype2));
                lista_funcionalidades.add(getResources().getString(R.string.skype3));
                lista_funcionalidades.add(getResources().getString(R.string.skype4));
                lista_funcionalidades.add(getResources().getString(R.string.skype5));
                break;
            case "Google Meet":
                lista_funcionalidades.add(getResources().getString(R.string.meet1));
                lista_funcionalidades.add(getResources().getString(R.string.meet2));
                lista_funcionalidades.add(getResources().getString(R.string.meet3));
                break;
            case "HBO":
                lista_funcionalidades.add(getResources().getString(R.string.hbo1));
                lista_funcionalidades.add(getResources().getString(R.string.hbo2));
                lista_funcionalidades.add(getResources().getString(R.string.hbo3));
                break;
            case "Netflix":
                lista_funcionalidades.add(getResources().getString(R.string.netflix1));
                lista_funcionalidades.add(getResources().getString(R.string.netflix2));
                break;
            case "Youtube":
                lista_funcionalidades.add(getResources().getString(R.string.youtube1));
                lista_funcionalidades.add(getResources().getString(R.string.youtube2));
                lista_funcionalidades.add(getResources().getString(R.string.youtube3));

                break;
            case "Twitch":
                lista_funcionalidades.add(getResources().getString(R.string.twitch1));
                lista_funcionalidades.add(getResources().getString(R.string.twitch2));
                break;
            case "Amazon Prime Video":
                lista_funcionalidades.add(getResources().getString(R.string.twitch2));
                break;
            case "Spotify":
                lista_funcionalidades.add(getResources().getString(R.string.spotify1));
                lista_funcionalidades.add(getResources().getString(R.string.spotify2));
                lista_funcionalidades.add(getResources().getString(R.string.spotify3));
                lista_funcionalidades.add(getResources().getString(R.string.spotify4));
                lista_funcionalidades.add(getResources().getString(R.string.spotify5));
                lista_funcionalidades.add(getResources().getString(R.string.spotify6));
                lista_funcionalidades.add(getResources().getString(R.string.spotify7));
                break;
            case "Amazon Prime Music":
                lista_funcionalidades.add(getResources().getString(R.string.amazonmusic1));
                lista_funcionalidades.add(getResources().getString(R.string.amazonmusic2));
                lista_funcionalidades.add(getResources().getString(R.string.amazonmusic3));
                lista_funcionalidades.add(getResources().getString(R.string.amazonmusic4));
                break;
            case "Shazam":
                lista_funcionalidades.add(getResources().getString(R.string.shazam1));
                lista_funcionalidades.add(getResources().getString(R.string.shazam2));
                break;
            case "YouTube Music":
                lista_funcionalidades.add (getResources().getString(R.string.ytmusic1));
                lista_funcionalidades.add(getResources().getString(R.string.ytmusic2));
                lista_funcionalidades.add(getResources().getString(R.string.ytmusic3));
                lista_funcionalidades.add(getResources().getString(R.string.ytmusic4));
                break;
            case "Pandora":
                lista_funcionalidades.add(getResources().getString(R.string.pandora1));
                break;
            case "Waze":
                lista_funcionalidades.add(getResources().getString(R.string.waze1));
                lista_funcionalidades.add(getResources().getString(R.string.waze2));
                break;
            case "Uber":
                lista_funcionalidades.add(getResources().getString(R.string.uber1));
                lista_funcionalidades.add(getResources().getString(R.string.uber2));
                lista_funcionalidades.add(getResources().getString(R.string.uber3));
                break;
            case "LinkedIn":
                lista_funcionalidades.add(getResources().getString(R.string.linkedin1));
                lista_funcionalidades.add(getResources().getString(R.string.linkedin2));
                lista_funcionalidades.add(getResources().getString(R.string.linkedin3));
                break;
            case "Instagram":
                lista_funcionalidades.add(getResources().getString(R.string.insta1));
                lista_funcionalidades.add(getResources().getString(R.string.insta2));
                lista_funcionalidades.add(getResources().getString(R.string.insta3));
                break;
            case "Lyft":
                lista_funcionalidades.add(getResources().getString(R.string.lyft1));
                lista_funcionalidades.add(getResources().getString(R.string.lyft2));
                lista_funcionalidades.add(getResources().getString(R.string.lyft3));
                lista_funcionalidades.add(getResources().getString(R.string.lyft4));
                break;
            case "Twitter":
                lista_funcionalidades.add(getResources().getString(R.string.twitter1));
                lista_funcionalidades.add(getResources().getString(R.string.twitter2));
                lista_funcionalidades.add(getResources().getString(R.string.twitter3));
                lista_funcionalidades.add(getResources().getString(R.string.twitter4));
                lista_funcionalidades.add(getResources().getString(R.string.twitter5));
                lista_funcionalidades.add(getResources().getString(R.string.twitter6));
                lista_funcionalidades.add(getResources().getString(R.string.twitter7));
                break;
            case "Wish":
                lista_funcionalidades.add(getResources().getString(R.string.wish1));
                lista_funcionalidades.add(getResources().getString(R.string.wish2));
                lista_funcionalidades.add(getResources().getString(R.string.wish3));
                lista_funcionalidades.add(getResources().getString(R.string.wish4));
                lista_funcionalidades.add(getResources().getString(R.string.wish5));
                lista_funcionalidades.add(getResources().getString(R.string.wish6));
                break;
            case "Alibaba":
                lista_funcionalidades.add(getResources().getString(R.string.alibaba1));
                lista_funcionalidades.add(getResources().getString(R.string.alibaba2));
                lista_funcionalidades.add(getResources().getString(R.string.alibaba3));
                break;
            case "Ebay":
                lista_funcionalidades.add(getResources().getString(R.string.ebay1));
                lista_funcionalidades.add(getResources().getString(R.string.ebay2));
                lista_funcionalidades.add(getResources().getString(R.string.ebay3));
                break;
            case "Amazon":
                lista_funcionalidades.add(getResources().getString(R.string.amazon1));
                lista_funcionalidades.add(getResources().getString(R.string.amazon2));
                lista_funcionalidades.add(getResources().getString(R.string.amazon3));
                lista_funcionalidades.add(getResources().getString(R.string.amazon4));
                lista_funcionalidades.add(getResources().getString(R.string.amazon5));
                lista_funcionalidades.add(getResources().getString(R.string.amazon6));
                break;
            case "Facebook":
                lista_funcionalidades.add(getResources().getString(R.string.facebook1));
                lista_funcionalidades.add(getResources().getString(R.string.facebook2));
                lista_funcionalidades.add(getResources().getString(R.string.facebook3));
                lista_funcionalidades.add(getResources().getString(R.string.facebook4));
                lista_funcionalidades.add(getResources().getString(R.string.facebook5));
                lista_funcionalidades.add(getResources().getString(R.string.facebook6));
                break;
            case "Google Maps":
                lista_funcionalidades.add(getResources().getString(R.string.maps1));
                lista_funcionalidades.add(getResources().getString(R.string.maps2));
                lista_funcionalidades.add(getResources().getString(R.string.maps3));
                lista_funcionalidades.add(getResources().getString(R.string.maps4));
                lista_funcionalidades.add(getResources().getString(R.string.maps5));
                lista_funcionalidades.add(getResources().getString(R.string.maps6));
                lista_funcionalidades.add(getResources().getString(R.string.maps7));
                break;


        }
        return lista_funcionalidades;
    }

    public String getUrl(String app) {

        switch (app) {
            case "WhatsApp":
                url = "https://www.wikihow.tech/Use-WhatsApp-on-an-Android";
                break;

            case "Zoom":
                url = "https://www.wikihow.com/Use-the-Zoom-App";
                break;

            case "Telegram":
                url = "https://www.wikihow.com/Use-Telegram";
                break;

            case "Skype":
                url = "https://www.wikihow.com/Skype";
                break;

            case "Google Meet":
                url = "https://www.wikihow.com/Use-Google-Meet";
                break;

            case "HBO":
                url = "https://www.wikihow.com/Get-HBO-Now";
                break;

            case "Netflix":
                url = "https://www.wikihow.com/Get-Netflix";
                break;
            case "Youtube":
                url = "https://www.wikihow.tech/Use-YouTube";
                break;
            case "Twitch":
                url = "https://www.wikihow.com/Use-Twitch-on-Android";
                break;
            case "Amazon Prime Video":
                url = "https://www.wikihow.com/Watch-Amazon-Prime-on-Android";
                break;
            case "Amazon Prime Music":
                url = "https://www.wikihow.com/Listen-to-Amazon-Prime-Music";
                break;
            case "Shazam":
                url = "https://www.wikihow.com/Play-Beat-Shazam-on-Android";
                break;
            case "YouTube Music":
                url = "https://www.wikihow.com/Use-YouTube-Music-on-Android";
                break;
            case "Pandora":
                url = "https://www.wikihow.com/Use-Pandora-on-Android";
                break;
            case "Waze":
                url = "https://www.wikihow.com/Navigate-the-Dashboard-on-Waze";
                break;
            case "Uber":
                url = "https://www.wikihow.com/Download-and-Use-the-Uber-App";
                break;
            case "LinkedIn":
                url = "https://www.wikihow.com/Use-LinkedIn-to-Find-a-Job";
                break;
            case "Instagram":
                url = "https://www.wikihow.com/Use-Instagram";
                break;
            case "Lyft":
                url = "https://www.wikihow.com/Use-Lyft";
                break;
            case "Twitter":
                url = "https://www.wikihow.com/Use-Twitter";
                break;
            case "Wish":
                url = "https://www.wikihow.com/Use-the-Wish-Shopping-Made-Fun-App-on-Android";
                break;
            case "Alibaba":
                url = "https://www.wikihow.com/Buy-from-Alibaba";
                break;
            case "Ebay":
                url = "https://www.wikihow.com/Buy-on-eBay";
                break;
            case "Amazon":
                url = "https://www.wikihow.com/Buy-on-Amazon";
                break;
            case "Google Maps":
                url = "https://www.wikihow.com/Use-Google-Maps";
                break;
            case "Facebook":
                url = "https://es.wikihow.com/usar-Facebook";
                break;
            case "Spotify":
                url = "https://www.wikihow.com/Use-Spotify-on-an-Android";
                break;


        }


        return url;
    }

    //Recibe la lista con la info dle webscrapping
    static public ArrayList<Info> list(ArrayList<Info> listaEntrante) {

        listWeb = listaEntrante;
        return listWeb;
    }

    public static void cargar() {

        FuncionalidadesAdapter sliderFuncionalidadesAdapter;
        sliderFuncionalidadesAdapter = new FuncionalidadesAdapter(mcontext, listWeb, app, lista_funcion);
        slideViewPager.setAdapter(sliderFuncionalidadesAdapter);
        slideViewPager.setPadding(130, 0, 130, 0);


    }

    private void ponerColorModo() {

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darkTheme);
            count++;
        } else setTheme(R.style.lightTheme);
    }

    // Este metodo nos sirve para crear y resaltar el color de los puntos segun en que pagina estemos
    public void addDootsIndicator(int position) {
        mDots = new TextView[lista_funcion.size()];
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

    public static int getCountVecesEntrada() {
        return countVecesEntrada;
    }

    public static void setCountVecesEntrada(int countVecesEntrada) {
        Funcion.countVecesEntrada = countVecesEntrada;
    }
}
