package com.yundoku.info;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yundoku.info.utils.InfoUtil;
import com.yundoku.info.utils.ToolUtil;

import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                ToolUtil.toFile(InfoUtil.getAppInfoList(getApplicationContext()));
            }
        });

        String json = ToolUtil.listToJson(InfoUtil.getAccountInfoList(getApplicationContext()));
    }
}
