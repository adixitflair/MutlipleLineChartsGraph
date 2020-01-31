package com.flair.multiplelinechart;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private Thread mThread;
    private boolean isFinish = false;
    Context appContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
        appContext=this;
        mThread = new Thread(mRunnable);
        mThread.start();
    }

    private Runnable mRunnable = new Runnable() {

        @Override
        public void run() {
            SystemClock.sleep(2000);
            mHandler.sendEmptyMessage(0);
        }
    };

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0 && (!isFinish)) {
                stopThread();
            }
            super.handleMessage(msg);
        }

    };

    @Override
    protected void onDestroy() {
        try {
            mThread.interrupt();
            mThread = null;
        } catch (Exception e) {
        }
        super.onDestroy();
    }

    private void stopThread() {
        startActivity(new Intent(appContext,MainActivity.class));
            finish();
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        isFinish=true;
        try {
            mThread.interrupt();
            mThread = null;
        } catch (Exception e) {
        }
        finish();
    }

    @Override
    public void finish() {
        super.finish();

    }
}


