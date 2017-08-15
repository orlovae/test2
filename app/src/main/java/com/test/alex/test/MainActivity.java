package com.test.alex.test;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.test.alex.test.model.Event;
import com.test.alex.test.model.Holder;
import com.test.alex.test.model.Move;
import com.test.alex.test.model.Notice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

    private int size;
    private final Random sizeMassive = new Random();
    private int startRandomMassive = 10;
    private int endRandomMassive = 100;

    private List<Holder> list;

    public static final String EVENT = "event";
    public static final String MOVE = "move";
    public static final String NOTICE = "notice";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        for (int i = startRandomMassive; i < size; i++) {
            final Random typeModel = new Random();
            int type = Integer.valueOf(typeModel.nextInt(3));
//            Log.d("MainActivity", "type = " + type);
            switch (type) {
                case 0:
                    list.add(new Holder(fabriceEvent(), EVENT));
                    break;
                case  1:
                    list.add(new Holder(fabriceMove(), MOVE));
                    break;
                case 2:
                    list.add(new Holder(fabriceNotice(), NOTICE));
                    break;
            }
        }

        for (Object item:list
             ) {
            Log.d("MainActivity", "list item = " + item.toString());
        }
    }

    private Notice fabriceNotice() {
        Date flightDate = new Date((long) (Math.random()*1000000));
        String gate = "gate" + (int)(Math.random()*100);

        return new Notice(flightDate, gate);
    }

    private Event fabriceEvent() {
        Date startTime = new Date((long) (Math.random()*1000000));
        Date endTime = new Date((long) (Math.random()*1000000));
        String name = "name" + (int)(Math.random()*100);

        return new Event(startTime, endTime, name);
    }

    private Move fabriceMove() {
        String fromPlace = "fromPlace" + (int)(Math.random()*100);
        String toPlace = "toPlace" + (int)(Math.random()*100);
        Date estimaTime = new Date((long) (Math.random()*1000000));

        return new Move(fromPlace, toPlace, estimaTime);
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
