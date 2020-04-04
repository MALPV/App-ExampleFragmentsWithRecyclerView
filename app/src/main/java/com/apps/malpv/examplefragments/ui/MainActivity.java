package com.apps.malpv.examplefragments.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.apps.malpv.examplefragments.R;
import com.apps.malpv.examplefragments.ui.ListFragment;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.Container, ListFragment.newInstance("",""), "List")
                .commit();
    }
}
