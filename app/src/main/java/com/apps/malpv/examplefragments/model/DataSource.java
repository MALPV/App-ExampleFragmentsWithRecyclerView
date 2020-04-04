package com.apps.malpv.examplefragments.model;

import java.util.ArrayList;
import java.util.List;

// Fuente de datos de prueba (Api, DB)
public class DataSource {

    public DataSource() {
    }

    //Devuelve una lista de Book estatica para pruebas
    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Book book = new Book();
            book.setTitulo("Titulo "+ i);
            book.setAutor("Autor " + i);
            books.add(book);
        }
        return books;
    }
}
