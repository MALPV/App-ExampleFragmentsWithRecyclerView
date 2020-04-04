package com.apps.malpv.examplefragments.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.malpv.examplefragments.R;
import com.apps.malpv.examplefragments.model.Book;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {

    //La clase si o si debe llevar una lista basada en el POJO
    //Tambien puede llevar una insterface y/o el Context
    private List<Book> bookList;
    private OnItemClickListenerAdapter listenerAdapter;

    public BookAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @NonNull
    @Override//Crea viewholder onDemand en base a la clase interna
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater;

        //Es una receta, siempre es lo mismo
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_book, parent, false);

        return new MyViewHolder(view);
    }

    @Override //Llena el viewholder generado por el onCreateViewHolder con los datos de cada elemento
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Book book = bookList.get(position);

        holder.tvTitulo.setText(book.getTitulo());
        holder.tvAutor.setText(book.getAutor());
    }

    @Override
    public int getItemCount() {
        //Checkea la cantidad de elementos
        //Es una receta siempre lo mismo
        return bookList.size();
    }

    // TODO: Para añadir el onClick
    // primero se crea la interfaz y se crea la variable arriba
    public interface OnItemClickListenerAdapter{
        void onItemClick(int position);
    }

    //Sirve para utilizar el listener fuera de la clase
    public void setOnItemClickListenerAdapter(OnItemClickListenerAdapter listener){
        this.listenerAdapter = listener;
    }

    //Enlaza la vista
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitulo;
        TextView tvAutor;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitulo = itemView.findViewById(R.id.textViewTitulo);
            tvAutor = itemView.findViewById(R.id.textViewAutor);

            //Implementamos el onClick en la vista
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    listenerAdapter.onItemClick(position);
                }
            });
        }
    }
}
