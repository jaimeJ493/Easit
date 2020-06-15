package com.jaime.easit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Locale;


public class MenuDespegable extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private SwitchCompat switcher;
    NavigationView navigationView;
    String[] title;
    ArrayList<Model> arrayList = new ArrayList<Model>();
    int[] icon;
    ListView listView;
    ListaBuscadorAdapter adapter;
    int count = 0;
    Context context;
    Window window;
    Button btn_share;
    int color;
    PreferencesHelper preferencesHelper;
    PreferencesModel model;
    int check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        context = getApplicationContext();
        this.model = preferencesHelper.loadPreferences(context);
        if (model.lang.equalsIgnoreCase("en")) {
            check = 0;
        } else {
            check = 1;
        }
        setLocale(this.model.lang);
        configurarApp(this.model.getActivo()); //Llamamos al metodo para ver las preferencias del usuario guardadas y configurar la app en base a estas
        ponerColorModo(); //Llamamos al metodo para poner el tema de la app oscuro/claro


        setContentView(R.layout.activity_main);


        this.window = getWindow();


        Toolbar toolbar = findViewById(R.id.toolbar);


        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);
        color = navigationView.getItemTextColor().getDefaultColor();
        Menu myMenu = navigationView.getMenu();

        navigationView.setNavigationItemSelectedListener(this);

        //menu settings
        MenuItem menuItemaAjustes = navigationView.getMenu().findItem(R.id.ajustes);
        if (check == 0) {
            menuItemaAjustes.setTitle("Settings");
        }
        SpannableString se = new SpannableString(menuItemaAjustes.getTitle());
        se.setSpan(new ForegroundColorSpan(color), 0, se.length(), 0);
        menuItemaAjustes.setTitle(se);

        //-----categorias
        MenuItem menuItemCategorias = navigationView.getMenu().findItem(R.id.nav_menu);
        if (check == 0) {
            menuItemCategorias.setTitle("Categories");
        }
        //-----Foro
        MenuItem menuItemForo = navigationView.getMenu().findItem(R.id.nav_Foro);
        if (check == 0) {
            menuItemForo.setTitle("Forum");
        }

        //-----Idioma
        MenuItem menuItemIdioma = navigationView.getMenu().findItem(R.id.nav_lang);
        if (check == 0) {
            menuItemIdioma.setTitle("English");
        }

        //-----Compartir
        MenuItem menuItemCompartir = navigationView.getMenu().findItem(R.id.nav_share);
        if (check == 0) {
            menuItemCompartir.setTitle("Share");
        }

        //-----Sobre nosotros
        MenuItem menuItemSobrenosotros = navigationView.getMenu().findItem(R.id.nav_somos);
        if (check == 0) {
            menuItemSobrenosotros.setTitle("About us");
        }


        //menu sabermas
        MenuItem menuItemSabermas = navigationView.getMenu().findItem(R.id.sabermas);
        if (check == 0) {
            menuItemSabermas.setTitle("Learn more");
        }
        SpannableString ses = new SpannableString(menuItemSabermas.getTitle());
        ses.setSpan(new ForegroundColorSpan(color), 0, ses.length(), 0);
        menuItemSabermas.setTitle(ses);

        //Switch
        MenuItem menuItem = myMenu.findItem(R.id.dark_mode_switch);

        if (check == 0) {
            menuItem.setTitle("Dark Theme");
        }
        View actionView = MenuItemCompat.getActionView(menuItem);

        switcher = (SwitchCompat) actionView.findViewById(R.id.switcher);
        if (count > 0) {
            switcher.setChecked(true);
        } else {
            switcher.setChecked(false);
        }

        /* Si el switch esta marcado el modo de la app pasa a oscuro y se guarda en la variable activo "si",
           en caso contrario el modo pasa a claro y la variable a "no" */
        switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switcher.isChecked()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    model.setActivo("si");
                    PreferencesHelper.savePreferences(context, model);
                    restartApp();

                }
                if (!switcher.isChecked()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    model.setActivo("");
                    PreferencesHelper.savePreferences(context, model);
                    restartApp();
                }
            }
        });


        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toogle.getDrawerArrowDrawable().setColor(color);
        drawer.addDrawerListener(toogle);
        toogle.syncState();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AppsCategoriasFragment()).commit();
        navigationView.setCheckedItem(R.id.nav_menu);


    }

    //cargamos la pantalla que se haya pinchado en el menu despegable
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AppsCategoriasFragment()).commit();
                break;
            case R.id.nav_Bot:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChatBotFragment()).commit();
                break;
            case R.id.nav_share:
                compartirApp();//saca un menu a eleccion del usuario para elegir por que red social comparte la url en playstore  de nuestra app
                break;
            case R.id.nav_lang:
                cambiarIdioma();
                break;
            case R.id.nav_somos:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new QuienesSomosFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void cambiarIdioma() {

        final String[] listItems = {"English", "Spanish"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mBuilder.setTitle(getResources().getString(R.string.eligeidoma));


        mBuilder.setSingleChoiceItems(listItems, check, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if (i == 0) {

                    setLocale("en");
                    restartApp();
                } else {
                    setLocale("");
                    restartApp();
                }
                dialog.dismiss();
            }
        });
        AlertDialog mDialog = mBuilder.create();
        mDialog.show();

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
            count++;

        } else {

            setTheme(R.style.lightTheme);

        }

    }


    private void compartirApp() {

        Intent compartir = new Intent(Intent.ACTION_SEND);
        compartir.setType("text/plain");
        compartir.putExtra(Intent.EXTRA_SUBJECT, "Insert Subject here");
        String app_url = "-----------------------------";//url de la app en playstore
        compartir.putExtra(Intent.EXTRA_TEXT, app_url);
        startActivity(Intent.createChooser(compartir, "Share via"));
    }


    //Abre el menu despegable
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }
        super.onBackPressed();

    }

    //Reinicia la app para poder cambiar configuraciones
    private void restartApp() {
        Intent i = new Intent(getApplicationContext(), MenuDespegable.class);
        startActivity(i);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar, menu);
        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);


        return true;
    }

    //Abrimos el buscador en otro intent(ListaBuscador)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            Intent i = new Intent(context, ListaBuscador.class);
            startActivityForResult(i, 0);
        }
        return super.onOptionsItemSelected(item);
    }


}
