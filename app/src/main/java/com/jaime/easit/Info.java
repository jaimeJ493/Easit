package com.jaime.easit;

public class Info implements java.io.Serializable{

    String pasos, imagen;


    public Info(String pasos, String imagen) {

        this.pasos = pasos;
        this.imagen = imagen;
    }

    public String getPasos() {
        return pasos;
    }

    public void setPasos(String pasos) {
        this.pasos = pasos;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
