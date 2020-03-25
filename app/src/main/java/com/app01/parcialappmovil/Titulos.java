package com.app01.parcialappmovil;


import android.os.Parcel;
import android.os.Parcelable;

public class Titulos implements Parcelable {

    String nombre;
    String director;
    String idioma;
    String genero;

    public Titulos(String nombre, String director, String idioma, String genero) {
        this.nombre = nombre;
        this.director = director;
        this.idioma = idioma;
        this.genero = genero;
    }
    public Titulos (Parcel in){

        this.nombre = in.readString();
        this.director = in.readString();
        this.idioma = in.readString();
        this.genero = in.readString();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeString(this.director);
        dest.writeString(this.genero);
        dest.writeString(this.idioma);

    }
    public static final Creator<Titulos> CREATOR = new Creator<Titulos>() {
        @Override
        public Titulos createFromParcel(Parcel in) {
            return new Titulos(in);
        }

        @Override
        public Titulos[] newArray(int size) {
            return new Titulos[size];
        }
    };

    @Override
    public String toString() {
        return  "Nombre :" + nombre +"\n"+
                "Director :" + director +"\n"+
                "Genero :" + genero +"\n"+
                "Idioma :" + idioma;
    }
}
