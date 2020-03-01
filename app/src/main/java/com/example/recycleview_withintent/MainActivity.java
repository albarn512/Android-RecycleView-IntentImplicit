package com.example.recycleview_withintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvKontak;
    private ArrayList<KontakModel> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvKontak = findViewById(R.id.rv_list);
        rvKontak.setHasFixedSize(true);
        list.addAll(KontakData.getKontakList());

        showRecyclerList();
    }

    private void showRecyclerList() {
        rvKontak.setLayoutManager(new LinearLayoutManager(this));
        KontakAdapter footbalAdapter = new KontakAdapter(this);
        footbalAdapter.setKontakList(list);
        rvKontak.setAdapter(footbalAdapter);
    }
}
