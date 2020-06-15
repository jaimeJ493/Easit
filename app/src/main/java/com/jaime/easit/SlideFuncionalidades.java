package com.jaime.easit;

import android.content.Context;
import android.content.Intent;
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

public class SlideFuncionalidades extends AppCompatActivity implements java.io.Serializable {
    public static ViewPager slideViewPager;
    static LinearLayout slideDoots;
    static SlideFuncionalidadesAdapter sliderFuncionalidadesAdapter;
    private static TextView[] mDots;
    private static int currentPage;
    static ArrayList<String> slide_Images = new ArrayList<String>();
    static ArrayList<String> slide_description = new ArrayList<String>();
    private static Button mNextBtn;
    private static Button mBackBtn;
    static Context mcontext;
    static int color;
    static int colorAcento;
    TextView coloresTxt;
    ListView listView;
    int count = 0;
    int variableNoRepetiticion;
    int variableComparacion;
    static ArrayList<String> listInfoTraducida = new ArrayList<String>();
    static ArrayList<Info> lista_info_Saliente = new ArrayList<Info>();
    static ArrayList<Integer> numerosSacarInfo = new ArrayList<Integer>();//Para saber que informacion cargar segun la funcionalidad
    static ArrayList<String> lista_info_Traducir = new ArrayList<String>();
    static String app;
    PreferencesHelper preferencesHelper;
    PreferencesModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ponerColorModo(); //Llamamos al metodo para poner el tema de la app oscuro/claro
        mcontext = getApplicationContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_funcionalidades);

        this.model = preferencesHelper.loadPreferences(mcontext);
        String lang = this.model.lang;

        // Inicializamos variables
        currentPage=0;
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
        addDootsIndicator(0);

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

        numerosSacarInfo = (ArrayList<Integer>) getIntent().getExtras().getIntegerArrayList("numerosLista");
        variableNoRepetiticion = (int) getIntent().getExtras().getInt("numeroVariable");
        lista_info_Saliente = (ArrayList<Info>) getIntent().getSerializableExtra("infoLista");
        app = (String) getIntent().getExtras().getString("app");

        if (slide_description.size() == numerosSacarInfo.size() && variableNoRepetiticion == variableComparacion) {
            cargarDirecto();
            variableComparacion = variableNoRepetiticion;
        } else {
            lista_info_Traducir.clear();
            listInfoTraducida.clear();
            slide_description.clear();
            slide_Images.clear();
            if(lang.equalsIgnoreCase("en")){
                cargarDirectoIngles();
            }else {
                cargar();
            }



            variableComparacion = variableNoRepetiticion;
        }





    }

    private void cargarDirectoIngles() {
        ArrayList<String>listaVariable= new ArrayList<>();

        for (int i = 0; i < numerosSacarInfo.size(); i++) {
            int num = numerosSacarInfo.get(i);
            slide_description.add(arreglos(lista_info_Saliente.get(num).pasos));
            slide_Images.add(lista_info_Saliente.get(num).imagen);
        }
        sliderFuncionalidadesAdapter = new SlideFuncionalidadesAdapter(mcontext, slide_Images, slide_description);
        slideViewPager.setAdapter(sliderFuncionalidadesAdapter);
        addDootsIndicator(0);

        slideViewPager.addOnPageChangeListener(viewListner);
    }


    //SEGUIR AQUI
    public static void cargar() {


        if(app.equalsIgnoreCase("Facebook")){

            ArrayList<String>listaVariable= new ArrayList<>();

            for (int i = 0; i < numerosSacarInfo.size(); i++) {
                int num = numerosSacarInfo.get(i);
                slide_description.add(arreglos(lista_info_Saliente.get(num).pasos));
                slide_Images.add(lista_info_Saliente.get(num).imagen);
            }
            sliderFuncionalidadesAdapter = new SlideFuncionalidadesAdapter(mcontext, slide_Images, slide_description);
            slideViewPager.setAdapter(sliderFuncionalidadesAdapter);
            addDootsIndicator(0);

            slideViewPager.addOnPageChangeListener(viewListner);

        }
        else{
            for (int i = 0; i < numerosSacarInfo.size(); i++) {
                int num = numerosSacarInfo.get(i);
                String textoSinArreglar = lista_info_Saliente.get(num).pasos;
                String textoArreglado = arreglos(textoSinArreglar);
                lista_info_Traducir.add(textoArreglado);

            }

            Traducir.textoTraducido(lista_info_Traducir);

        }



    }

    static public void probar() {

        ArrayList<String> listaFinal = listInfoTraducida;
        //cambiar para coger la iamgenes que necesita y las traducciones que necesita
        for (int i = 0; i < numerosSacarInfo.size(); i++) {
            int num = numerosSacarInfo.get(i);
            String arreglosTraduccion=arreglosDespuesTraducir(listaFinal.get(i));
            slide_Images.add(lista_info_Saliente.get(num).imagen);
            slide_description.add(arreglosTraduccion);
        }


        sliderFuncionalidadesAdapter = new SlideFuncionalidadesAdapter(mcontext, slide_Images, slide_description);
        slideViewPager.setAdapter(sliderFuncionalidadesAdapter);
        addDootsIndicator(0);

        slideViewPager.addOnPageChangeListener(viewListner);


    }

    public static void cargarDirecto() {

        sliderFuncionalidadesAdapter = new SlideFuncionalidadesAdapter(mcontext, slide_Images, slide_description);
        slideViewPager.setAdapter(sliderFuncionalidadesAdapter);
        addDootsIndicator(0);

        slideViewPager.addOnPageChangeListener(viewListner);
    }


    //Arreglos del texto antes de traducir
    static public String arreglos(String textoSinArreglar) {
        String textoArregladoConFinal = null;
        String textoArregladoSinFinal = null;

        //Quitar [numeros] y Quitar recusros de busqueda
        for (int i = 1; i < 25; i++) {
            String pruebaIngles = "[" + i + "] X Research source";
            String pruebaEspañol = "[" + i + "] X Fuente de investigación";
            int j = textoSinArreglar.indexOf(pruebaIngles);
            int a = textoSinArreglar.indexOf(pruebaEspañol);
            if (j != -1 || a!=-1) {
                //String textoSinFinales = textoSinArreglar.substring(0, textoSinArreglar.length() - 1).substring(0, textoSinArreglar.length() - 2).substring(0, textoSinArreglar.length() - 3).substring(0, textoSinArreglar.length() - 4).substring(0, textoSinArreglar.length() - 5);//Sirve para elimnar \n \n finales para que solga otro punto mas
                textoArregladoConFinal = textoSinArreglar.replace(pruebaEspañol, "").replace(pruebaIngles, "");//.replace("  ", " ").replace("\n \n \n", "\n \n").replace("\n \n", "\n \n" + Html.fromHtml("&#8226;")).replace(Html.fromHtml("&#8226;")+"",Html.fromHtml("&#8226;")+" ").replace(Html.fromHtml("&#8226;")+"  ",Html.fromHtml("&#8226;")+" ");

                break;
            } else {

               // String textoSinFinales = textoSinArreglar.substring(0, textoSinArreglar.length() - 1).substring(0, textoSinArreglar.length() - 2).substring(0, textoSinArreglar.length() - 3).substring(0, textoSinArreglar.length() - 3);//Sirve para elimnar \n \n finales para que solga otro punto mas

                textoArregladoConFinal = textoSinArreglar.replace(pruebaEspañol, "").replace(pruebaIngles, "");//.replace("  ", " ").replace("\n \n \n", "\n \n").replace("\n \n", "\n \n" + Html.fromHtml("&#8226;")).replace(Html.fromHtml("&#8226;")+"",Html.fromHtml("&#8226;")+" ").replace(Html.fromHtml("&#8226;")+"  ",Html.fromHtml("&#8226;")+" ");

            }



        }
        return textoArregladoConFinal;
    }

    //Arreglos del texto antes de traducir
    static public String arreglosDespuesTraducir(String textoSinArreglar) {
        String textoArreglado = null;
        if(app.equals("Telegram")){
          textoArreglado=textoSinArreglar.replace("telegram","Telegram").replace("Telegramas", "Telegram").replace("Telegrams", "Telegram").replace("de ronda", "redondo").replace("haya", "este").replace("abierto",
                  "'Abrir'").replace("Instalar","'Instalar'").replace("lanzar","iniciar").replace("Buscar","'Buscar'").replace("Tyquear Telegram","Escriba 'Telegram'").replace("Telegrame Messenger","'Telegram Messenger'").replace("útil","a mano el movil").replace("A continuación,es posible","A continuación,").replace("Escriba Telegrama","Escriba 'Telegram'").replace("Telegrama","Telegram");
        }
        else if(app.equals("Zoom")){
            textoArreglado=textoSinArreglar.replace("GAG","Pulsa").replace("intale","INSTALL").replace("Remoderesión de la CLoud Zoom","Zoom CLoud Meetings").replace("Naranja","naranja").replace("zoo Zoom","icono de Zoom").replace("clic","click").replace("interruptor de encienda","botón de comenzar").replace("interruptor de remanso","botón switch").replace("o aprovecha","en").replace("Seeen","reunión").replace("Encontrar final",
                    "Finalizar reunión").replace("tabletas","tablets").replace("corona de baja menor derecha","esquina inferior derecha").replace("hecha","hecho").replace("cronograma","horario").replace("zoom","Zoom").replace("ÚNETE A JUNTA",
                    "ÚNETE A UNA REUNIÓN").replace("TOGUE ÚNE","ÚNETE A UNA REUNIÓN").replace("Companice","Compón").replace("MOR","demás.");
        }else if (app.equals("HBO")){
            textoArreglado=textoSinArreglar.replace("And","y").replace("TAPAZAS DE ABRAMITOS DE ABRAMADO DE ANIMACIÓN","Amazon Kindle Fire tablets").replace("ahora","Now").replace("su alternativa","ábrala cuando se termine de descargar.").replace("Juego","play").replace("costo","coste").replace("Bil-Mil",
                    "factura de internet").replace("AP","app");
        }
        else if(app.equals("Ebay")){
            textoArreglado=textoSinArreglar.replace("enciende","dice").replace("le dice que se convierta","le dice se convierte").replace("OWU","oferta").replace("Amoun","importe").replace("[1] X Resource Sourc","").replace("enojo",
                    "hecho.");
        }
        else if(app.equals("Amazon")){
            textoArreglado=textoSinArreglar.replace("primos","Prime").replace("carro","Carrito").replace("órdenes","pedidos").replace("Encendido","Directamente").replace("custome","comprador").replace("mouse",
                    "ratón").replace("computadora","ordenador").replace("Inicio de aquí","Empezar aquí").replace("huesos","'Bones'").replace("[1] X Resource Sourc","").replace("ter","término").replace("al bar",
                    "a la barra").replace("Used & AMP; Nuevo ","Usado & Nuevo").replace("odenando","pidiendo").replace("CART","Carrito").replace("sus addres","su dirección");
        }
        else if(app.equals("Google Maps")){
            textoArreglado=textoSinArreglar.replace("Abra los Google Maps","Abra Google Maps").replace("GPE","App Store").replace("direcciones de turnos","indicaciones paso a paso").replace("Plus","más").replace("Tirar las publicaciones","Indicaciones").replace("Steps & Amp;Más para ver una lista de direcciones de turnos por turnos.",
                    "Pasos y demás para ver una lista de las indicaciones paso a paso.").replace("Piezas de inicio ","Pulsa en comenzar.").replace("hecha","hecho").replace("plac","lugar").replace("a Acoi","evitar.").replace("Toca hecho o","Pulsa en hecho.").replace("ma","mapa").replace("hasta que apague este apagado",
                    "Hasta que apague esto").replace("o clos",".").replace("direcciones ingenio","indicaciones.").replace("abra AHORA","abierto ahora").replace("amarillo Marke","amarillo").replace("en la calle de la calle","Street View").replace("Haga clic o toca","Pulsa");

        }
        else if(app.equals("Skype")){
            textoArreglado=textoSinArreglar.replace("una Mac","un Mac").replace("inmediatamente descenso","inmediatamente.").replace("en las aplicaciones FLUE","a la carpeta Aplicaciones.").replace("con la que se firmará su computadora i","con el que inició sesión su ordenador.").replace("Noche de mensajes","número de teléfono.").replace("Microsoft. $ 1, seleccione su nombre de texto de la búsqueda.",
                    "número de teléfono de Microsoft, escriba el nombre de una persona en el campo de texto \"Buscar Skype\", luego seleccione su contacto preferido.").replace("Tipo de mensaje","Escriba un mensaje").replace("del Skype Windo","de la ventana de Skype.").replace("Contac","contacto.").replace("i","ella.").replace("Llamar en llama","Finalizar llamada").replace("Skype para hacer",
                    "Skype para hacerlo.").replace("del pag","de la página.");
        }
        else if(app.equals("YouTube")){
            textoArreglado=textoSinArreglar.replace("para buscar a más buscador","para búsquedas más específicas").replace("el canal Pag","la página del canal.").replace("otro juego de reproducción","otra lista de reporducción.").replace("No baje por la borda","No se exceda").replace("Monette","Monetiza").replace("crucular",
                    "realizar promociones cruzadas.").replace("Desarrollar y cura su contenido", "Desarrolla y selecciona tu contenido.");
        }
        else if(app.equals("Twitch")){
            textoArreglado=textoSinArreglar.replace("Open","Abre").replace("blanco blanca","blanca cuadrada").replace("Pulso","Pulse").replace("puestos","publicaciones").replace("POS","Publicar").replace("están listados en belo",
                    "se enumeran a continuación.").replace("Scree", "pantalla.").replace("tracción","Twitch").replace("olea","pantalla.").replace("corriente","transmisión").replace("flujo en Twitc","transmisión en Twitch.").replace("rara",
                    "transmisión.").replace("el final cuando termines de correr","finalizar cuando termines de transmitir");
        }
        else{
            textoArreglado=textoSinArreglar;
        }

        return textoArreglado;
    }


    private void ponerColorModo() {

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darkTheme);
            count++;
        } else setTheme(R.style.lightTheme);
    }

    // Este metodo nos sirve para crear y resaltar el color de los puntos segun en que pagina estemos
    static public void addDootsIndicator(int position) {
        mDots = new TextView[slide_Images.size()];
        slideDoots.removeAllViews();
        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(mcontext);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(color);
            slideDoots.addView(mDots[i]);

        }
        if (mDots.length > 0) {
            mDots[position].setTextColor(colorAcento);
        }
    }

    static ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {

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
        getMenuInflater().inflate(R.menu.toolbar_home, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_Home);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_Home) {
            Intent i = new Intent(mcontext, MenuDespegable.class);
            startActivityForResult(i, 0);
        }
        return super.onOptionsItemSelected(item);
    }


    static public ArrayList<String> listaTraducida(ArrayList<String> listaEntrante) {

        listInfoTraducida = listaEntrante;
        return listInfoTraducida;
    }
}
