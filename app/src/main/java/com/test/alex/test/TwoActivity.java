package com.test.alex.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.test.alex.test.model.Event;
import com.test.alex.test.model.Move;
import com.test.alex.test.model.Notice;

import static com.test.alex.test.MainActivity.EVENT;
import static com.test.alex.test.MainActivity.MOVE;
import static com.test.alex.test.MainActivity.NOTICE;

/**
 * Created by alex on 14.08.17.
 */

public class TwoActivity extends AppCompatActivity {
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        initView();
        setTextView();
    }

    private void initView() {
        textView1 = (TextView)findViewById(R.id.text_view1);
        textView2 = (TextView)findViewById(R.id.text_view2);
        textView3 = (TextView)findViewById(R.id.text_view3);
    }

    private void setTextView() {
        Bundle extras = getIntent().getExtras();

        try {
            if (extras.containsKey(EVENT)) {
                Event event = extras.getParcelable(EVENT);
                textView1.setText(event.getStartTime().toString());
                textView2.setText(event.getEndTime().toString());
                textView3.setVisibility(View.VISIBLE);
                textView3.setText(event.getName());
            }

            if (extras.containsKey(MOVE)) {
                Move move = extras.getParcelable(MOVE);
                textView1.setText(move.getFromPlace());
                textView2.setText(move.getToPlace());
                textView3.setVisibility(View.VISIBLE);
                textView3.setText(move.getEstimaTime().toString());
            }

            if (extras.containsKey(NOTICE)) {
                Notice notice = extras.getParcelable(NOTICE);
                textView1.setText(notice.getFlightDate().toString());
                textView2.setText(notice.getGate());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
