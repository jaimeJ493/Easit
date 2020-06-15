package com.jaime.easit;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.common.modeldownload.FirebaseModelDownloadConditions;
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateLanguage;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslator;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslatorOptions;

import java.util.ArrayList;

public class Traducir {
    static String textoSaliente;
    static ArrayList<String> lista_Saliente = new ArrayList<String>();
    static String g;
    static ArrayList<String> lista_Traducida = new ArrayList<String>();

    public static ArrayList<String> textoTraducido(final ArrayList<String> lista_traducir) {

        for (int i = 0; i < lista_traducir.size(); i++) {
            FirebaseTranslatorOptions options =
                    new FirebaseTranslatorOptions.Builder()
                            .setSourceLanguage(FirebaseTranslateLanguage.EN)
                            .setTargetLanguage(FirebaseTranslateLanguage.ES)
                            .build();
            final FirebaseTranslator englishSpanishTranslator =
                    FirebaseNaturalLanguage.getInstance().getTranslator(options);


            FirebaseModelDownloadConditions conditions = new FirebaseModelDownloadConditions.Builder()
                    .requireWifi()
                    .build();


            englishSpanishTranslator.downloadModelIfNeeded(conditions).addOnSuccessListener(
                    new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void v) {
                            System.out.println("SIIIIIII");
                        }
                    })
                    .addOnFailureListener(
                            new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    System.out.println("noooo");
                                }
                            });


            String textoEntrante = lista_traducir.get(i);
            englishSpanishTranslator.translate(textoEntrante.replace("\n", "*")).addOnSuccessListener(new OnSuccessListener<String>() {
                @Override
                public void onSuccess(@NonNull String translatedText) {


                    StringBuilder builder = new StringBuilder(translatedText);
                    textoSaliente = builder.toString().replace("*", "\n");

                    lista_Traducida.add(textoSaliente);

                    if (lista_traducir.size() == lista_Traducida.size()) {
                        SlideFuncionalidades.listaTraducida(lista_Traducida);
                        SlideFuncionalidades.probar();
                        lista_Traducida.clear();
                    }

                }
            })
                    .addOnFailureListener(
                            new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    System.out.println("EROOR");
                                }
                            });


        }


        return lista_Traducida;
    }


    public static ArrayList<String> getLista_Saliente() {
        return lista_Saliente;
    }

    public static void setLista_Saliente(ArrayList<String> lista_Saliente) {
        Traducir.lista_Saliente = lista_Saliente;

    }
}


