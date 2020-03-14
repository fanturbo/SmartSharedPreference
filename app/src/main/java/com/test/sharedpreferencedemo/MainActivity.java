package com.test.sharedpreferencedemo;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.xckj.palfishsp.PalfishSPUtil;
import com.xckj.palfishsp.PalfishSp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    public static Activity activity;

    @PalfishSp(key = "IsEyeProtectionOpen", name = "护眼模式是否打开")
    boolean IsEyeProtectionOpen;

    @PalfishSp(key = "AppName", name = "App名称")
    String AppName;

    @PalfishSp(key = "Index", name = "Index")
    int Index;

    @PalfishSp(key = "Time", name = "Time")
    long Time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Log.e("====IsEyeProtectionOpen", "" + PalfishSPUtil.getIsEyeProtectionOpen(false));
        PalfishSPUtil.setIsEyeProtectionOpen(true);
        Log.e("====IsEyeProtectionOpen", "" + PalfishSPUtil.getIsEyeProtectionOpen());


        Log.e("====AppName", PalfishSPUtil.getAppName("SPTest"));
        PalfishSPUtil.setAppName("SPDemo");
        Log.e("====AppName", PalfishSPUtil.getAppName());

        Log.e("====Index", "" + PalfishSPUtil.getIndex(-100));
        PalfishSPUtil.setIndex(5);
        Log.e("====Index", "" + PalfishSPUtil.getIndex());

        Log.e("====Time", "" + PalfishSPUtil.getTime(1000));
        PalfishSPUtil.setTime(System.currentTimeMillis());
        Log.e("====Time", "" + PalfishSPUtil.getTime());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
