package com.jaime.easit;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class WebScrapping {

    static String url_howToUse ;
    static ArrayList<Info> lista_datos = new ArrayList<Info>();
    static String pasos = null;


    public static class Llamada extends AsyncTask<Void, Void, ArrayList<Info>> {
        String words;

        private Context mContext;

        public Llamada(Context context) {
            mContext = context;
        }

        @Override
        protected ArrayList<Info> doInBackground(Void... voids) {
            String titulo = null;
            url_howToUse=getUrl_howToUse();//cogemos la url que se paso por parametro desde la clase Funcionalidades
            String imagen = null;

            ArrayList<String> lista_imagenes = new ArrayList<String>();
            ArrayList<String> lista_datos = new ArrayList<String>();

            Info info = null;
            ArrayList<Info> lista_info = new ArrayList<Info>();
            Document document;

            Elements informacion = null;
            Elements info1 = null;
            int count = 0;
            int count1 = 0;

            try {
                document = (Document) Jsoup.connect(url_howToUse).get();

                Elements todo = document.getElementsByClass("mf-section-1 collapsible-block");

                //Imagenes
                Elements imagenes = document.getElementsByClass("whcdn content-fill");

                //Descargar e instalar(f)
                Elements descargarInstalar = document.getElementsByClass("section steps  steps_first sticky");

                //funcionalidades(f)
                Elements funcionalidades = document.getElementsByClass("section steps  sticky");

                for (int i = 0; i < descargarInstalar.size(); i++) {

                    titulo = descargarInstalar.get(i).getElementsByClass("mw-headline").text().toString();
                    informacion = descargarInstalar.get(i).getElementsByClass("step");
                }
                for (int i = 0; i < imagenes.size(); i++) {


                    if (i % 2 == 0) {
                        String urlImagen = imagenes.get(i).attr("data-src").toString();
                        lista_imagenes.add(urlImagen);

                    }
                }
                for (Element element : informacion) {


                    String strWithNewLine = mantenerFormato(element.toString());

                    lista_datos.add(remove_parenthesis(strWithNewLine, "{}"));

                }

                //lo mismo pero para funcionalidades(f)
                for (int i = 0; i < funcionalidades.size(); i++) {

                    //
                    titulo = funcionalidades.get(i).getElementsByClass("mw-headline").text().toString();
                    System.out.println(titulo);


                    info1 = funcionalidades.get(i).getElementsByClass("step");

                    for (Element element : info1) {


                        String strWithNewLine = mantenerFormato(element.toString());
                        lista_datos.add(remove_parenthesis(strWithNewLine, "{}"));


                    }
                }

                //Metemos las imagenes con sus funcionalidades en un array<Info>
                for (int i = 0; i < lista_imagenes.size(); i++) {


                    imagen = lista_imagenes.get(i);
                    pasos = (lista_datos.get(i));


                    info = new Info(pasos, imagen);
                    lista_info.add(info);


                }


            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }
            return lista_info;
        }


        @Override
        protected void onPostExecute(ArrayList<Info> lista_infos) {
            super.onPostExecute(lista_infos);


            Funcion.list(lista_infos);
            myHandler.sendEmptyMessage(0);
        }


        static Handler myHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:

                        Funcion.cargar();



                        break;
                    default:
                        break;
                }
            }
        };
    }

    public static ArrayList<Info> getLista_datos() {
        return lista_datos;
    }

    public static void setLista_datos(ArrayList<Info> lista_datos) {
        WebScrapping.lista_datos = lista_datos;
    }


    // mantiene el formato con saltos de linea y parrafos
    private static String mantenerFormato(String string) {


        Document jsoupDoc = Jsoup.parse(string);

        //prettyPrint false para no eliminar \n
        jsoupDoc.outputSettings(new OutputSettings().prettyPrint(false));

        //seleccionamos todas las etiquetas <br> y agregue \ n después
        jsoupDoc.select("br").after("\\n");

        //seleccionamos todas las etiquetas <p> y anteponiendo \ n antes
        jsoupDoc.select("p").before("\\n");

        jsoupDoc.select("li").before("\\n");


        //Mantener el formato nuevo
        String str = jsoupDoc.html().replaceAll("\\\\n", "\n");

        String strNuevo =
                Jsoup.clean(str, "", Whitelist.none(), new OutputSettings().prettyPrint(false));
        return strNuevo;
    }


    // Quita todo lo que se encuentre entre (),[] and {} junto con los mismos
    public static String remove_parenthesis(String input_string, String parenthesis_symbol) {
        if (parenthesis_symbol.contains("[]")) {
            return input_string.replaceAll("\\s*\\[[^\\]]*\\]\\s*", " ");
        } else if (parenthesis_symbol.contains("{}")) {
            return input_string.replaceAll("\\s*\\{[^\\}]*\\}\\s*", " ");

        } else {
            return input_string.replaceAll("\\s*\\([^\\)]*\\)\\s*", " ");
        }
    }

    public static String getUrl_howToUse() {
        return url_howToUse;
    }

    public static void setUrl_howToUse(String url_howToUse) {
        WebScrapping.url_howToUse = url_howToUse;
    }
}
