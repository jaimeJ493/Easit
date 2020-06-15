package com.jaime.easit;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class FuncionalidadesAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<String> slide_Images;

    ArrayList<String> slide_description;

    ConstraintLayout cd_app;
    int positionR;
    Button mDescBtn;
    CardView cardview;
    String mapp;
    static ArrayList<Info> mlistWeb = new ArrayList<Info>();


    public FuncionalidadesAdapter(Context context, ArrayList<Info> listWeb, String app, ArrayList<String> slide_description) {
        this.context = context;
        this.slide_description = slide_description;
        mlistWeb = listWeb;
        mapp = app;

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
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            context.setTheme(R.style.darkTheme);
        } else context.setTheme(R.style.lightTheme);
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.funcionalidades_layout, container, false);

       final TextView slideDescription = (TextView) view.findViewById(R.id.txtFuncionalidad);
        cardview = (CardView) view.findViewById(R.id.cd_total);
        cd_app = (ConstraintLayout) view.findViewById(R.id.cd_app);
        String f=slide_description.get(position);
        slideDescription.setText(slide_description.get(position));

        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> numeroLista = new ArrayList<Integer>();
                int variableNoRepetición = 0;
                String vs =slideDescription.getText().toString();

                if (mapp.equalsIgnoreCase("WhatsApp")){
                    switch (vs){
                        case "Chatear":
                            for (int i = 1; i <= 6; i++) {
                                numeroLista.add(i);
                            }
                            variableNoRepetición=207;
                            break;
                        case "Enviar archivos":
                            for (int i = 7; i <= 13; i++) {
                                numeroLista.add(i);
                            }
                            variableNoRepetición=208;
                            break;
                        case "Crear un grupo":
                            for (int i=14;i<=21;i++){
                                numeroLista.add(i);
                            }
                            variableNoRepetición=209;
                            break;
                        case "Chatear en grupo":
                            for (int i=22;i<=26;i++){
                                numeroLista.add(i);
                            }
                            variableNoRepetición=210;
                            break;
                        case "Añadir amigos":
                            for (int i=27;i<=31;i++){
                                numeroLista.add(i);
                            }
                            variableNoRepetición=211;
                            break;
                        case "Configuración":
                            for (int i=32;i<=39;i++){
                                numeroLista.add(i);
                            }
                            variableNoRepetición=212;
                            break;



                        // ingles

                        case "Chatting":
                            for (int i = 1; i <= 6; i++) {
                                numeroLista.add(i);
                            }
                            variableNoRepetición=207;
                            break;
                        case "Sending Attachments":
                            for (int i = 7; i <= 13; i++) {
                                numeroLista.add(i);
                            }
                            variableNoRepetición=208;
                            break;
                        case "Create a group":
                            for (int i=14;i<=21;i++){
                                numeroLista.add(i);
                            }
                            variableNoRepetición=209;
                            break;
                        case "Chat in group":
                            for (int i=22;i<=26;i++){
                                numeroLista.add(i);
                            }
                            variableNoRepetición=210;
                            break;
                        case "Add friends":
                            for (int i=27;i<=31;i++){
                                numeroLista.add(i);
                            }
                            variableNoRepetición=211;
                            break;
                        case "Configuration":
                            for (int i=32;i<=39;i++){
                                numeroLista.add(i);
                            }
                            variableNoRepetición=212;
                            break;



                    }
                }
                if (mapp.equalsIgnoreCase("Telegram")) {

                    switch (vs) {
                        case "Instalar Telegram":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            variableNoRepetición = 1;
                            break;
                        case "Añadir contactos":
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            variableNoRepetición = 2;
                            break;
                        case "Enviar y recibir mensajes":
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            variableNoRepetición = 3;
                            break;
                        case "Llamadas de voz":
                            numeroLista.add(17);
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            variableNoRepetición = 4;
                            break;
                        case "Canales y grupos":
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            numeroLista.add(24);
                            variableNoRepetición = 5;
                            break;



                        // ingles



                        case "Install Telegram":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            variableNoRepetición = 1;
                            break;
                        case "Add contacts":
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            variableNoRepetición = 2;
                            break;
                        case "Send and receive messages":
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            variableNoRepetición = 3;
                            break;
                        case "Voice calls":
                            numeroLista.add(17);
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            variableNoRepetición = 4;
                            break;
                        case "Channels and groups":
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            numeroLista.add(24);
                            variableNoRepetición = 5;
                            break;

                    }
                }
                if (mapp.equalsIgnoreCase("Zoom")) {


                    switch (vs) {
                        case "Instalar y registrarse" :
                            for (int i = 0; i <= 13; i++) {
                                numeroLista.add(i);
                            }
                            variableNoRepetición = 6;
                            break;
                        case "Empezar una reunión":
                            for (int i = 14; i <=19; i++) {
                                numeroLista.add(i);
                            }
                            variableNoRepetición = 7;
                            break;
                        case "Programar una reunión":
                            for (int i = 20; i <=31; i++) {
                                numeroLista.add(i);
                            }
                            variableNoRepetición = 8;

                            break;
                        case "Unirse a una reunión":

                            for (int i = 32; i <=40; i++) {
                                numeroLista.add(i);
                            }

                            variableNoRepetición = 9;
                            break;
                        case "Invitar participantes":
                            for (int i = 41; i <=49; i++) {
                                numeroLista.add(i);
                            }
                            variableNoRepetición =10;
                            break;
                        case "Compartir pantalla":
                            for (int i = 50; i <=55; i++) {
                                numeroLista.add(i);
                            }
                            variableNoRepetición =11;
                            break;


                        //Ingles

                        case "Install and register" :
                            for (int i = 0; i <= 14; i++) {
                                numeroLista.add(i);
                            }
                            variableNoRepetición = 6;
                            break;
                        case "Start a meeting":
                            for (int i = 15; i <=20; i++) {
                                numeroLista.add(i);
                            }
                            variableNoRepetición = 7;
                            break;
                        case "Program a meeting":
                            for (int i = 21; i <=31; i++) {
                                numeroLista.add(i);
                            }
                            variableNoRepetición = 8;

                            break;
                        case "Join a meeting":

                            for (int i = 32; i <=40; i++) {
                                numeroLista.add(i);
                            }

                            variableNoRepetición = 9;
                            break;
                        case "Invite participants":
                            for (int i = 41; i <=49; i++) {
                                numeroLista.add(i);
                            }
                            variableNoRepetición =10;
                            break;
                        case "Share screen":
                            for (int i = 50; i <=55; i++) {
                                numeroLista.add(i);
                            }
                            variableNoRepetición =11;
                            break;

                    }
                }
                if(mapp.equalsIgnoreCase("Skype")) {
                    switch (vs) {
                        case "Descargar e instalar":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            variableNoRepetición=12;
                            break;
                        case "Iniciar un chat":
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            variableNoRepetición=13;
                            break;
                        case "Crear un grupo":
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            variableNoRepetición=14;
                            break;
                        case "Llamar a un contacto o grupo":
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            variableNoRepetición=15;
                            break;
                        case "Agregar dinero a tu cuenta":
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            numeroLista.add(24);
                            numeroLista.add(25);
                            variableNoRepetición=16;
                            break;


                        // ingles



                        case "Download and install":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            variableNoRepetición=12;
                            break;
                        case "Start a chat":
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            variableNoRepetición=13;
                            break;
                        case "Create a group":
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            variableNoRepetición=14;
                            break;
                        case "Call a contact or group":
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            variableNoRepetición=15;
                            break;
                        case "Add money to your account":
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            numeroLista.add(24);
                            numeroLista.add(25);
                            variableNoRepetición=16;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("Google Meet")){
                    switch (vs){
                        case "Abrir Google Meet":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            variableNoRepetición=17;
                            break;
                        case "Unirse a una reunión":
                            numeroLista.add(2);
                            variableNoRepetición=18;
                            break;
                        case "Navegar por la sesión":
                            for (int i=3;i<=12;i++){
                                numeroLista.add(i);
                            }
                            variableNoRepetición=19;
                            break;


                        // ingles

                        case "Open Google Meet":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            variableNoRepetición=17;
                            break;
                        case "Join a meeting":
                            numeroLista.add(2);
                            variableNoRepetición=18;
                            break;
                        case "Browse session":
                            for (int i=3;i<=12;i++){
                                numeroLista.add(i);
                            }
                            variableNoRepetición=19;
                            break;

                    }
                }
                if(mapp.equalsIgnoreCase("HBO")) {
                    switch (vs){
                        case"Obtener HBO Now":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            variableNoRepetición=20;
                            break;

                        case "Obtener HBO por Internet":
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            variableNoRepetición=21;
                            break;

                        case "HBO Streaming":
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            variableNoRepetición=22;
                            break;


                        // ingles


                        case"Obtain HBO Now":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            variableNoRepetición=20;
                            break;

                        case "Obtain HBO by Internet":
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            variableNoRepetición=21;
                            break;





                    }
                }
                if (mapp.equalsIgnoreCase("Netflix")){
                    switch (vs){
                        case "Registrarse":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            variableNoRepetición=23;
                            break;
                        case "Agregar un plan":
                            numeroLista.add(10);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            variableNoRepetición=24;
                            break;


                        // ingles


                        case "Register":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            variableNoRepetición=23;
                            break;
                        case "Add a plan":
                            numeroLista.add(10);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            variableNoRepetición=24;
                            break;

                    }
                }
                if(mapp.equalsIgnoreCase("Youtube")){
                    switch (vs){
                        case "Ver videos":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            variableNoRepetición=25;
                            break;
                        case "Subir un video":
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            variableNoRepetición=26;
                            break;
                        case "Crear un canal":
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            variableNoRepetición=27;
                            break;


                        // ingles


                        case "Watch videos":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            variableNoRepetición=25;
                            break;
                        case "Upload a video":
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            variableNoRepetición=26;
                            break;
                        case "Create a channel":
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            variableNoRepetición=27;
                            break;

                    }
                }
                if (mapp.equalsIgnoreCase("Twitch")){
                    switch (vs){
                        case "Introduccion":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            variableNoRepetición=28;
                            break;
                        case "Streaming":
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            variableNoRepetición=29;
                            break;

                        //ingles

                        case "Introduction":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            variableNoRepetición=28;
                            break;

                    }
                }
                if (mapp.equalsIgnoreCase("Amazon Prime Video")){
                    switch (vs){
                        case "Introduccion":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            variableNoRepetición=30;
                            break;

                        case "Introduction":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            variableNoRepetición=30;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("Spotify")){
                    switch (vs){
                        case "Escuchar música":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            variableNoRepetición=31;
                            break;
                        case "Usar tu biblioteca":
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            variableNoRepetición=32;
                            break;
                        case "Crear listas":
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            numeroLista.add(24);
                            numeroLista.add(25);
                            numeroLista.add(26);
                            variableNoRepetición=33;
                            break;
                        case "Escuchar podcast":
                            numeroLista.add(27);
                            numeroLista.add(28);
                            numeroLista.add(29);
                            numeroLista.add(30);
                            numeroLista.add(31);
                            numeroLista.add(32);
                            numeroLista.add(33);
                            numeroLista.add(34);
                            variableNoRepetición=34;
                            break;
                        case "Actualizar a Premium":
                            numeroLista.add(35);
                            numeroLista.add(36);
                            numeroLista.add(37);
                            numeroLista.add(38);
                            numeroLista.add(39);
                            numeroLista.add(40);
                            variableNoRepetición=35;
                            break;
                        case "Ahorro de datos":
                            numeroLista.add(41);
                            numeroLista.add(42);
                            numeroLista.add(43);
                            variableNoRepetición=36;
                            break;
                        case "Modo sin conexión":
                            numeroLista.add(44);
                            numeroLista.add(45);
                            numeroLista.add(46);
                            numeroLista.add(47);
                            variableNoRepetición=37;
                            break;


                        // ingles



                        case "Listen to music":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            variableNoRepetición=31;
                            break;
                        case "Use your library":
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            variableNoRepetición=32;
                            break;
                        case "Create lists":
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            numeroLista.add(24);
                            numeroLista.add(25);
                            numeroLista.add(26);
                            variableNoRepetición=33;
                            break;
                        case "Listen to podcast":
                            numeroLista.add(27);
                            numeroLista.add(28);
                            numeroLista.add(29);
                            numeroLista.add(30);
                            numeroLista.add(31);
                            numeroLista.add(32);
                            numeroLista.add(33);
                            numeroLista.add(34);
                            variableNoRepetición=34;
                            break;
                        case "Upgrade to Premium":
                            numeroLista.add(35);
                            numeroLista.add(36);
                            numeroLista.add(37);
                            numeroLista.add(38);
                            numeroLista.add(39);
                            numeroLista.add(40);
                            variableNoRepetición=35;
                            break;
                        case "Data saving":
                            numeroLista.add(41);
                            numeroLista.add(42);
                            numeroLista.add(43);
                            variableNoRepetición=36;
                            break;
                        case "Offline mode":
                            numeroLista.add(44);
                            numeroLista.add(45);
                            numeroLista.add(46);
                            numeroLista.add(47);
                            variableNoRepetición=37;
                            break;

                    }
                }
                if (mapp.equalsIgnoreCase("Amazon Prime Music")){
                    switch (vs){
                        case "Escuchar en móviles":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            variableNoRepetición=38;
                            break;
                        case "Escuchar en Windows":
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            variableNoRepetición=39;
                            break;
                        case "Escuchar en Mac":
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            variableNoRepetición=40;
                            break;
                        case "Escuchar en un navegador":
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            variableNoRepetición=41;
                            break;


                        // ingles



                        case "listen on mobile":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            variableNoRepetición=38;
                            break;
                        case "listen on Windows":
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            variableNoRepetición=39;
                            break;
                        case "listen on Mac":
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            variableNoRepetición=40;
                            break;
                        case "listen in a browser":
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            variableNoRepetición=41;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("Shazam")){
                    switch (vs){
                        case "Instalar":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            variableNoRepetición=42;
                            break;
                        case "Sincronizar'":
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            variableNoRepetición=43;
                            break;


                        // ingles


                        case "Install":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            variableNoRepetición=42;
                            break;
                        case "Sync up'":
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            variableNoRepetición=43;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("YouTube Music")){
                    switch (vs){
                        case "Configurar":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            variableNoRepetición=44;
                            break;
                        case "Encontrar música":
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            variableNoRepetición=45;
                            break;
                        case "Crear una radio":
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            variableNoRepetición=46;
                            break;
                        case "Biblioteca":
                            numeroLista.add(22);
                            numeroLista.add(23);
                            numeroLista.add(24);
                            numeroLista.add(25);
                            numeroLista.add(26);
                            numeroLista.add(27);
                            numeroLista.add(28);
                            numeroLista.add(29);
                            numeroLista.add(30);
                            numeroLista.add(31);
                            variableNoRepetición=47;
                            break;


                        // ingles



                        case "Set Up":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            variableNoRepetición=44;
                            break;
                        case "Find music":
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            variableNoRepetición=45;
                            break;
                        case "Create a radio":
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            variableNoRepetición=46;
                            break;
                        case "Library":
                            numeroLista.add(22);
                            numeroLista.add(23);
                            numeroLista.add(24);
                            numeroLista.add(25);
                            numeroLista.add(26);
                            numeroLista.add(27);
                            numeroLista.add(28);
                            numeroLista.add(29);
                            numeroLista.add(30);
                            numeroLista.add(31);
                            variableNoRepetición=47;
                            break;
                    }
                }
                if(mapp.equalsIgnoreCase("Pandora")){
                    switch (vs){
                        case "Introducción":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            variableNoRepetición=48;
                            break;

                        // ingles



                        case "Introduction":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            variableNoRepetición=48;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("Waze")){
                    switch (vs){
                        case "Obtener":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            variableNoRepetición=49;
                            break;
                        case "Usar tablero":
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            variableNoRepetición=50;
                            break;


                        // ingles



                        case "Obtain":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            variableNoRepetición=49;
                            break;
                        case "Use board":
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            variableNoRepetición=50;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("Uber")){
                    switch (vs){
                        case "Instalar en iPhone":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            variableNoRepetición=51;
                            break;
                        case "Instalar en Android":
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            variableNoRepetición=52;
                            break;
                        case "Pedir un Uber":
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            numeroLista.add(24);
                            numeroLista.add(25);
                            numeroLista.add(26);
                            numeroLista.add(27);
                            variableNoRepetición=53;
                            break;


                        // ingles



                        case "Install on iPhone":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            variableNoRepetición=51;
                            break;
                        case "Install on Android":
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            variableNoRepetición=52;
                            break;
                        case "Ask for an Uber":
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            numeroLista.add(24);
                            numeroLista.add(25);
                            numeroLista.add(26);
                            numeroLista.add(27);
                            variableNoRepetición=53;
                            break;

                    }
                }
                if (mapp.equalsIgnoreCase("LinkedIn")){
                    switch (vs){
                        case "Crear perfil":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            variableNoRepetición=54;
                            break;
                        case "Redes y contactos":
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            variableNoRepetición=55;
                            break;
                        case "Buscar trabajo":
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            variableNoRepetición=56;
                            break;



                        // ingles



                        case "Create profile":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            variableNoRepetición=54;
                            break;
                        case "Network and Contacts":
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            variableNoRepetición=55;
                            break;
                        case "Search for a job":
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            variableNoRepetición=56;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("Instagram")){
                    switch (vs){
                        case "Instalar":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            variableNoRepetición=57;
                            break;
                        case "Usar pestañas":
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            variableNoRepetición=58;
                            break;
                        case "Subir fotos":
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            variableNoRepetición=58;
                            break;


                        // ingles



                        case "Install":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            variableNoRepetición=57;
                            break;
                        case "Use tabs":
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            variableNoRepetición=58;
                            break;
                        case "Upload photos":
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            variableNoRepetición=58;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("Lyft")){
                    switch (vs){
                        case "Registrar":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            variableNoRepetición=59;
                            break;
                        case "Método de pago":
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            variableNoRepetición=60;
                            break;
                        case "Solicitar un viaje":
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            variableNoRepetición=61;
                            break;
                        case "Pagar el viaje":
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            variableNoRepetición=62;
                            break;


                        // ingles



                        case "Register":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            variableNoRepetición=59;
                            break;
                        case "Payment method":
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            variableNoRepetición=60;
                            break;
                        case "Request a trip":
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            variableNoRepetición=61;
                            break;
                        case "Pay the trip":
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            variableNoRepetición=62;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("Twitter")){
                    switch (vs){
                        case "Registrar":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            variableNoRepetición=63;
                            break;
                        case "Configurar perfil":
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            variableNoRepetición=64;
                            break;
                        case "Seguir usuarios":
                            numeroLista.add(24);
                            numeroLista.add(25);
                            numeroLista.add(26);
                            numeroLista.add(27);
                            numeroLista.add(28);
                            variableNoRepetición=65;
                            break;
                        case "Twittear":
                            numeroLista.add(29);
                            numeroLista.add(30);
                            numeroLista.add(31);
                            numeroLista.add(32);
                            numeroLista.add(33);
                            numeroLista.add(34);
                            numeroLista.add(35);
                            numeroLista.add(36);
                            numeroLista.add(37);
                            variableNoRepetición=66;
                            break;
                        case "Retwittear":
                            numeroLista.add(38);
                            numeroLista.add(39);
                            numeroLista.add(40);
                            numeroLista.add(41);
                            numeroLista.add(42);
                            variableNoRepetición=67;
                            break;
                        case "Enviar mensajes":
                            numeroLista.add(43);
                            numeroLista.add(44);
                            numeroLista.add(45);
                            numeroLista.add(46);
                            numeroLista.add(47);
                            numeroLista.add(48);
                            numeroLista.add(49);
                            variableNoRepetición=68;
                            break;
                        case "Usar en móvil":
                            numeroLista.add(50);
                            numeroLista.add(51);
                            numeroLista.add(52);
                            numeroLista.add(53);
                            numeroLista.add(54);
                            numeroLista.add(55);
                            numeroLista.add(56);
                            numeroLista.add(57);
                            numeroLista.add(58);
                            variableNoRepetición=69;
                            break;


                        // ingles



                        case "Register":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            variableNoRepetición=63;
                            break;
                        case "Configure profile":
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            variableNoRepetición=64;
                            break;
                        case "Follow users":
                            numeroLista.add(24);
                            numeroLista.add(25);
                            numeroLista.add(26);
                            numeroLista.add(27);
                            numeroLista.add(28);
                            variableNoRepetición=65;
                            break;
                        case "Tweet":
                            numeroLista.add(29);
                            numeroLista.add(30);
                            numeroLista.add(31);
                            numeroLista.add(32);
                            numeroLista.add(33);
                            numeroLista.add(34);
                            numeroLista.add(35);
                            numeroLista.add(36);
                            numeroLista.add(37);
                            variableNoRepetición=66;
                            break;
                        case "Retweet":
                            numeroLista.add(38);
                            numeroLista.add(39);
                            numeroLista.add(40);
                            numeroLista.add(41);
                            numeroLista.add(42);
                            variableNoRepetición=67;
                            break;
                        case "Send messages":
                            numeroLista.add(43);
                            numeroLista.add(44);
                            numeroLista.add(45);
                            numeroLista.add(46);
                            numeroLista.add(47);
                            numeroLista.add(48);
                            numeroLista.add(49);
                            variableNoRepetición=68;
                            break;
                        case "Use on mobile":
                            numeroLista.add(50);
                            numeroLista.add(51);
                            numeroLista.add(52);
                            numeroLista.add(53);
                            numeroLista.add(54);
                            numeroLista.add(55);
                            numeroLista.add(56);
                            numeroLista.add(57);
                            numeroLista.add(58);
                            variableNoRepetición=69;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("Wish")){
                    switch (vs){
                        case "Crear una cuenta":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            variableNoRepetición=70;
                            break;
                        case "Hacer un pedido":
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            variableNoRepetición=71;
                            break;
                        case "Seguimientos":
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            variableNoRepetición=72;
                            break;
                        case "Crear listas":
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            numeroLista.add(24);
                            numeroLista.add(25);
                            variableNoRepetición=73;
                            break;
                        case "Agregar a la lista":
                            numeroLista.add(26);
                            numeroLista.add(27);
                            numeroLista.add(28);
                            numeroLista.add(29);
                            numeroLista.add(30);
                            variableNoRepetición=74;
                            break;
                        case "Administrar lista":
                            numeroLista.add(31);
                            numeroLista.add(32);
                            numeroLista.add(33);
                            numeroLista.add(34);
                            numeroLista.add(35);
                            numeroLista.add(36);
                            variableNoRepetición=75;
                            break;



                        // ingles



                        case "Create an account":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            variableNoRepetición=70;
                            break;
                        case "Make an order":
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            variableNoRepetición=71;
                            break;
                        case "Follow orders":
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            variableNoRepetición=72;
                            break;
                        case "Create lists":
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            numeroLista.add(24);
                            numeroLista.add(25);
                            variableNoRepetición=73;
                            break;
                        case "Add to the list":
                            numeroLista.add(26);
                            numeroLista.add(27);
                            numeroLista.add(28);
                            numeroLista.add(29);
                            numeroLista.add(30);
                            variableNoRepetición=74;
                            break;
                        case "Manage list":
                            numeroLista.add(31);
                            numeroLista.add(32);
                            numeroLista.add(33);
                            numeroLista.add(34);
                            numeroLista.add(35);
                            numeroLista.add(36);
                            variableNoRepetición=75;
                            break;

                    }
                }
                if (mapp.equalsIgnoreCase("Alibaba")){
                    switch (vs){
                        case "Buscar productos":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            variableNoRepetición=76;
                            break;
                        case "Proveedores":
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            variableNoRepetición=77;
                            break;
                        case "Transacción segura":
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            variableNoRepetición=78;
                            break;


                        // ingles



                        case "Search products":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            variableNoRepetición=76;
                            break;
                        case "Providers":
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            variableNoRepetición=77;
                            break;
                        case "Secure transaction":
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            variableNoRepetición=78;
                            break;

                    }
                }
                if (mapp.equalsIgnoreCase("Ebay")){
                    switch (vs){
                        case "Encontrar artículo":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            variableNoRepetición=79;
                            break;
                        case "Pujar artículo":
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            variableNoRepetición=80;
                            break;
                        case "Transacción segura":
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            variableNoRepetición=81;
                            break;




                        // ingles



                        case "Find article":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            variableNoRepetición=79;
                            break;
                        case "Bid article":
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            variableNoRepetición=80;
                            break;
                        case "Secure transaction":
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            variableNoRepetición=81;
                            break;

                    }
                }
                if (mapp.equalsIgnoreCase("Amazon")){
                    switch (vs){
                        case "Crear cuenta":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            variableNoRepetición=82;
                            break;
                        case "Hacer búsquedas":
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            variableNoRepetición=83;
                            break;
                        case "Categorías":
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            variableNoRepetición=84;
                            break;
                        case "Selecciona un artículo":
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            variableNoRepetición=85;
                            break;
                        case "Completar pedido":
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            variableNoRepetición=86;
                            break;
                        case "Configurar pedido":
                            numeroLista.add(23);
                            numeroLista.add(24);
                            numeroLista.add(25);
                            numeroLista.add(26);
                            variableNoRepetición=87;
                            break;


                        // ingles



                        case "Create account":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            variableNoRepetición=82;
                            break;
                        case "Search":
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            variableNoRepetición=83;
                            break;
                        case "Categories":
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            variableNoRepetición=84;
                            break;
                        case "Select an item":
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            variableNoRepetición=85;
                            break;
                        case "Complete order":
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            variableNoRepetición=86;
                            break;
                        case "Configure order":
                            numeroLista.add(23);
                            numeroLista.add(24);
                            numeroLista.add(25);
                            numeroLista.add(26);
                            variableNoRepetición=87;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("Facebook")){
                    switch (vs){
                        case "Introducción":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            variableNoRepetición=88;
                            break;
                        case "Añadir amigos":
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            variableNoRepetición=89;
                            break;
                        case "Subir publicaciones en PC":
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            variableNoRepetición=90;
                            break;
                        case "Subir publicaciones en móvil":
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            variableNoRepetición=91;
                            break;
                        case "Subir fotos y videos en PC":
                            numeroLista.add(24);
                            numeroLista.add(25);
                            numeroLista.add(26);
                            numeroLista.add(27);
                            numeroLista.add(28);
                            numeroLista.add(29);
                            variableNoRepetición=92;
                            break;
                        case "Subir fotos y videos en móvil":
                            numeroLista.add(30);
                            numeroLista.add(31);
                            numeroLista.add(32);
                            numeroLista.add(33);
                            numeroLista.add(34);
                            numeroLista.add(35);
                            numeroLista.add(36);
                            numeroLista.add(37);
                            variableNoRepetición=93;
                            break;



                        // ingles



                        case "Introduction":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            variableNoRepetición=88;
                            break;
                        case "Add fiends":
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            variableNoRepetición=89;
                            break;
                        case "Upload publications on pc":
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            variableNoRepetición=90;
                            break;
                        case "Upload publications on mobile":
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            variableNoRepetición=91;
                            break;
                        case "Upload photos and videos on PC":
                            numeroLista.add(24);
                            numeroLista.add(25);
                            numeroLista.add(26);
                            numeroLista.add(27);
                            numeroLista.add(28);
                            numeroLista.add(29);
                            variableNoRepetición=92;
                            break;
                        case "upload photos and videos on Mobile":
                            numeroLista.add(30);
                            numeroLista.add(31);
                            numeroLista.add(32);
                            numeroLista.add(33);
                            numeroLista.add(34);
                            numeroLista.add(35);
                            numeroLista.add(36);
                            numeroLista.add(37);
                            variableNoRepetición=93;
                            break;

                    }
                }
                if (mapp.equalsIgnoreCase("Google Maps")){
                    switch (vs){
                        case "Obtener direcciones":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            variableNoRepetición=94;
                            break;
                        case "Agregar paradas":
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            variableNoRepetición=95;
                            break;
                        case "Opciones de ruta":
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            variableNoRepetición=96;
                            break;
                        case "Compartir ubicaciones":
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            numeroLista.add(24);
                            numeroLista.add(25);
                            numeroLista.add(26);
                            variableNoRepetición=97;
                            break;
                        case "Encontrar negocios":
                            numeroLista.add(27);
                            numeroLista.add(28);
                            numeroLista.add(29);
                            numeroLista.add(30);
                            variableNoRepetición=98;
                            break;
                        case "Cambio tipo de mapa":
                            numeroLista.add(31);
                            numeroLista.add(32);
                            numeroLista.add(33);
                            numeroLista.add(34);
                            variableNoRepetición=99;
                            break;
                        case "Usar Street View":
                            numeroLista.add(35);
                            numeroLista.add(36);
                            numeroLista.add(37);
                            numeroLista.add(38);
                            numeroLista.add(39);
                            numeroLista.add(40);
                            numeroLista.add(41);
                            numeroLista.add(42);
                            variableNoRepetición=100;
                            break;


                        // ingles



                        case "Get directions":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            variableNoRepetición=94;
                            break;
                        case "Add stops":
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            variableNoRepetición=95;
                            break;
                        case "Route options":
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            variableNoRepetición=96;
                            break;
                        case "Sharing locations":
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            numeroLista.add(24);
                            numeroLista.add(25);
                            numeroLista.add(26);
                            variableNoRepetición=97;
                            break;
                        case "Find business":
                            numeroLista.add(27);
                            numeroLista.add(28);
                            numeroLista.add(29);
                            numeroLista.add(30);
                            variableNoRepetición=98;
                            break;
                        case "Change map type":
                            numeroLista.add(31);
                            numeroLista.add(32);
                            numeroLista.add(33);
                            numeroLista.add(34);
                            variableNoRepetición=99;
                            break;
                        case "Use Street View":
                            numeroLista.add(35);
                            numeroLista.add(36);
                            numeroLista.add(37);
                            numeroLista.add(38);
                            numeroLista.add(39);
                            numeroLista.add(40);
                            numeroLista.add(41);
                            numeroLista.add(42);
                            variableNoRepetición=100;
                            break;

                    }
                }
                Intent intent = new Intent(context, SlideFuncionalidades.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("numerosLista", numeroLista);
                intent.putExtra("infoLista", mlistWeb);
                intent.putExtra("numeroVariable", variableNoRepetición);
                intent.putExtra("app", mapp);
                v.getContext().startActivity(intent);
            }


        });



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

