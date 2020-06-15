package com.jaime.easit;

public class PreferencesModel {
    String activo,lang;


    public PreferencesModel(String activo, String lang) {
        this.activo = activo;
        this.lang = lang;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
