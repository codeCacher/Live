package com.cs.live;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/18.
 */

public class LoginActivity extends BaseActivity {
    @BindView(R.id.ivExit)
    ImageView ivExit;
    @BindView(R.id.tvRegister)
    TextView tvRegister;
    @BindView(R.id.etUsername)
    EditText etUsername;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.tvForgetPsd)
    TextView tvForgetPsd;
    @BindView(R.id.ivQQ)
    ImageView ivQQ;
    @BindView(R.id.ivSina)
    ImageView ivSina;
    @BindView(R.id.ivWeixin)
    ImageView ivWeixin;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.bind = ButterKnife.bind(this);
        Unbinder bind = this.bind;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    @Override
    public void onClick(View v) {

    }
}
