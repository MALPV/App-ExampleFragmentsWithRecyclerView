package com.apps.malpv.examplefragments.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.apps.malpv.examplefragments.R;
import com.apps.malpv.examplefragments.adapter.BookAdapter;
import com.apps.malpv.examplefragments.model.Book;
import com.apps.malpv.examplefragments.model.DataSource;

import java.util.List;

public class ListFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //Parametros dentro del bundle
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private List<Book> bookList;

    public ListFragment() {
        // Required empty public constructor
    }

    //Creación del fragmento
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rvListaBook);

        //Creamos el manager
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        //Para que se adapte a las dimensiones
        recyclerView.setHasFixedSize(true);

        bookList = new DataSource().getBooks(); //podemos tambien crear la lista y luego pasarla al adapter
        BookAdapter bookAdapter = new BookAdapter(bookList);

        recyclerView.setAdapter(bookAdapter);

        //ClickListener en el adapter
        bookAdapter.setOnItemClickListenerAdapter(new BookAdapter.OnItemClickListenerAdapter() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), "Position: "+position, Toast.LENGTH_SHORT).show();

                Book book = bookList.get(position);
                //Instanciamos el mismo manager de la actividad
                FragmentManager manager = getActivity().getSupportFragmentManager();

                manager.beginTransaction()
                        .replace(R.id.Container, DetailsFragment.newInstance(book.getTitulo(),book.getAutor()), "Details")
                        .addToBackStack("List")
                        .commit();
            }
        });
    }
}
