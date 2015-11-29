package com.zen.android.app.backup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTvContent;

    private int value;

    private int backupValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFields();
        restoreData(savedInstanceState);
        afterCreate();
    }

    private void initFields() {
        mTvContent = (TextView) findViewById(R.id.textView);
    }

    private void restoreData(Bundle data) {
        if (data == null) {
            return;
        }
        backupValue = data.getInt("value", 0);
    }

    private void afterCreate() {
        showValueText();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 1;
                backupValue = 1;
                DemoApp.setValue(1);
                SingleInstance.INSTANCE.setValue(1);
                showValueText();
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showValueText();
            }
        });
    }

    private void showValueText() {
        mTvContent.setText(getString(R.string.value_text, DemoApp.getValue(), SingleInstance.INSTANCE.getValue(), value, backupValue));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("value", backupValue);
    }
}
