package com.test.alex.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.test.alex.test.model.IModel;

import static com.test.alex.test.Constant.MODEL;


/**
 * Created by alex on 14.08.17.
 */

public class TwoActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        initView();
        setTextView();
    }

    private void initView() {
        textView = (TextView)findViewById(R.id.text_view);
    }

    private void setTextView() {
        try {
            IModel model = getIntent().getParcelableExtra(MODEL);
            textView.setText(model.getInfoFromModel());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
