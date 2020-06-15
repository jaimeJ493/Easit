package com.jaime.easit;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHelper {
    private static final String SETTINGS = "settings";
    private static final String MODO = "modo";
    private static final String LENGUAJE = "lenguaje";
    private static final String DEF_ACTIVO = "";
    private static final String DEF_IDIOMA = "";


    public static void savePreferences(Context context, PreferencesModel model) {
        SharedPreferences preferences = context.getSharedPreferences(SETTINGS, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();


        editor.putString(MODO, model.getActivo());
        editor.putString(LENGUAJE, model.getLang());
        editor.apply();
    }


    public static PreferencesModel loadPreferences(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(SETTINGS, context.MODE_PRIVATE);

        String fmodo = preferences.getString(MODO, DEF_ACTIVO);
        String fidioma = preferences.getString(LENGUAJE, DEF_IDIOMA);


        return new PreferencesModel(fmodo,fidioma);
    }

    public static void deletePreferences(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(SETTINGS, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }
}
