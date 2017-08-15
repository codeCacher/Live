package com.cs.live;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.cs.live.MVP.view.FollowFragment;
import com.cs.live.MVP.view.HomeFragment;
import com.cs.live.MVP.view.LiveFragment;
import com.cs.live.MVP.view.MeFragment;
import com.cs.live.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.fragment_content)
    LinearLayout fragmentContent;
    @BindView(R.id.rbHome)
    RadioButton rbHome;
    @BindView(R.id.rbLive)
    RadioButton rbLive;
    @BindView(R.id.rbFollow)
    RadioButton rbFollw;
    @BindView(R.id.rbMe)
    RadioButton rbMe;

    private boolean isQuit = false;
    private Unbinder mBind;
    private HomeFragment mHomeFragment;
    private LiveFragment mLiveFragment;
    private FollowFragment mFollowFragment;
    private MeFragment mMeFragment;
    private FragmentManager mFragmentManager;
    private Fragment mShowingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        mBind = ButterKnife.bind(this);

        initClickEvent();

        initFragment();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        mBind.unbind();
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onEventExit(Boolean isBool) {
        SystemClock.sleep(1000);
        isQuit = false;
    }

    @Override
    public void onBackPressed() {
        if (isQuit) {
            super.onBackPressed();
        } else {
            isQuit = true;
            ToastUtils.toastText(this, getResources().getString(R.string.quit_tip));
            EventBus.getDefault().post(isQuit);
        }
    }

    public static void openMainActivity(Context applicationContext, int flagActivityNewTask) {
        applicationContext.startActivity(new Intent(applicationContext, MainActivity.class).setFlags(flagActivityNewTask));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rbHome:
                showFragment(mHomeFragment);
                break;

            case R.id.rbLive:
                showFragment(mLiveFragment);
                break;

            case R.id.rbFollow:
                showFragment(mFollowFragment);
                break;

            case R.id.rbMe:
                showFragment(mMeFragment);
                break;
        }
    }

    private void initClickEvent() {
        rbHome.setOnClickListener(this);
        rbLive.setOnClickListener(this);
        rbFollw.setOnClickListener(this);
        rbMe.setOnClickListener(this);
    }

    private void initFragment() {
        mHomeFragment = new HomeFragment();
        mLiveFragment = new LiveFragment();
        mFollowFragment = new FollowFragment();
        mMeFragment = new MeFragment();

        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_content, mHomeFragment);
        fragmentTransaction.add(R.id.fragment_content, mLiveFragment);
        fragmentTransaction.add(R.id.fragment_content, mFollowFragment);
        fragmentTransaction.add(R.id.fragment_content, mMeFragment);
        fragmentTransaction.show(mHomeFragment);
        fragmentTransaction.commit();

        mShowingFragment = mHomeFragment;
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.hide(mShowingFragment);
        fragmentTransaction.show(fragment);
        fragmentTransaction.commit();
        mShowingFragment = fragment;
    }
}
