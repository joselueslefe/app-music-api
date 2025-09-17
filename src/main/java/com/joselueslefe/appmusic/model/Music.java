package com.joselueslefe.appmusic.model;

public class Music {
    private long id;
    private String titulo;
    private String artista;

    public Music () {}

    public Music(long id,String titulo, String artista) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
    }

    public long getId () {return id;}
    public void setId (long id) {this.id=id;}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
}
