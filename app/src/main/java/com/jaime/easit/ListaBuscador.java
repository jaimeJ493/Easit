package com.jaime.easit;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class ListaBuscador extends AppCompatActivity {
    String[] title;
    ArrayList<Model> arrayList = new ArrayList<Model>();
    int[] icon;
    ListView listView;
    ListaBuscadorAdapter adapter;
    TextView colorTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ponerColorModo(); //Llamamos al metodo para poner el tema de la app oscuro/claro

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_buscador);

        //Inicializamos variables
        Toolbar toolbar = findViewById(R.id.toolbarReal);
        listView = findViewById(R.id.lista_apps);

        colorTxt = (TextView) findViewById(R.id.textColor);

        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(colorTxt.getCurrentTextColor(), PorterDuff.Mode.SRC_ATOP);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//abre directamente el buscador


        //Introducimos las apps y sus imagenes correspondientes y se las pasamos a un adapter personalizado
        title = new String[]{"WhatsApp", "Youtube", "Skype", "Zoom","Instagram",
                "Facebook","Netflix","Twitch","Telegram","Spotify","Amazon Prime Music","YouTube Music","Shazam","Waze","Uber","Lyft","Google Maps","HBO","Twitter","LinkedIn","Wish","Amazon","Ebay","Alibaba"};
        icon = new int[]{R.drawable.whatsapp, R.drawable.youtube, R.drawable.skype,
                 R.drawable.zoom,R.drawable.instagram,
               R.drawable.facebook,R.drawable.netflix,R.drawable.twitch,R.drawable.telegram,R.drawable.spotify,R.drawable.amazonmusic,R.drawable.youtubemusic,R.drawable.shazam,R.drawable.waze,R.drawable.uber,R.drawable.lyft,R.drawable.googlemaps,R.drawable.hbo,R.drawable.twitter,R.drawable.linkedin,R.drawable.wish,R.drawable.amazon,R.drawable.ebay,R.drawable.alibaba};

        for (int i = 0; i < title.length; i++) {
            Model model = new Model(title[i], icon[i]);
            arrayList.add(model);
        }


        adapter = new ListaBuscadorAdapter(this, arrayList);//Pasamos los resultados al adapter personalizado


        listView.setAdapter(adapter);//Enlazamos el adapter al listView
    }

    //Establecemos algunas carecteristicas del buscador y creamos el textlistner para filtrar y sacar asi los resultados de busqueda
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_valido, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();

        int id = searchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        TextView textView = (TextView) searchView.findViewById(id);
        textView.setTextColor(colorTxt.getCurrentTextColor());


        searchView.setMaxWidth(5000);
        searchView.setFocusable(true);
        searchView.setIconified(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else {

                    adapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    private void ponerColorModo() {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darkTheme);

        } else setTheme(R.style.lightTheme);
    }
}
