package com.cs.live;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.cs.live.utils.ToastUtils;
import com.pili.pldroid.player.AVOptions;
import com.pili.pldroid.player.PLMediaPlayer;
import com.pili.pldroid.player.widget.PLVideoTextureView;
import com.pili.pldroid.player.widget.PLVideoView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity{

    private boolean isQuit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onEventExit(Boolean isBool){
        SystemClock.sleep(1000);
        isQuit = false;
    }

    @Override
    public void onBackPressed() {
        if(isQuit){
            super.onBackPressed();
        }else {
            isQuit = true;
            ToastUtils.toastText(this,getResources().getString(R.string.quit_tip));
            EventBus.getDefault().post(isQuit);
        }
    }

    public static void openMainActivity(Context applicationContext, int flagActivityNewTask) {
        applicationContext.startActivity(new Intent(applicationContext, MainActivity.class).setFlags(flagActivityNewTask));
    }
}
