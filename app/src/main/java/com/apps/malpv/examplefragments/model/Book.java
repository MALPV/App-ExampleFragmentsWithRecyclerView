package com.apps.malpv.examplefragments.model;

import androidx.annotation.NonNull;

public class Book {
    String titulo, autor;

    public Book() {
    }

    public Book(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
