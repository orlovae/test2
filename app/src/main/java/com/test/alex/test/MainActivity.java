package com.test.alex.test;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.alex.test.fabrice.Fabrice;
import com.test.alex.test.model.Holder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;


    private int size;
    private final Random sizeMassive = new Random();
    private int startRandomMassive = 10;
    private int endRandomMassive = 100;

    private Fabrice fabrice;
    private List<Holder> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabrice = new Fabrice();

        initView();
        generateContent();
        initRecyclerView();
    }

    private void initView() {
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
    }

    private void generateContent() {
        size = Integer.valueOf(sizeMassive.nextInt(endRandomMassive) + 1);

        while (size < startRandomMassive) {//проверка минимального значения
            size = Integer.valueOf(sizeMassive.nextInt(endRandomMassive) + 1);
        }

        list = new ArrayList<Holder>();

        for (int i = 0; i < size; i++) {
            final Random typeModel = new Random();
            int type = Integer.valueOf(typeModel.nextInt(3));
//            Log.d("MainActivity", "type = " + type);
            switch (type) {
                case 0:
                    list.add(new Holder<>(fabrice.createEvent()));
                    break;
                case  1:
                    list.add(new Holder<>(fabrice.createMove()));
                    break;
                case 2:
                    list.add(new Holder<>(fabrice.createNotice()));
                    break;
            }
        }
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new RecyclerViewAdapter(this, list);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
