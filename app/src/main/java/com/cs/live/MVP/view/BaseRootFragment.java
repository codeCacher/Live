package com.cs.live.MVP.view;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;

import com.cs.live.LoginActivity;

/**
 * Created by Administrator on 2017/8/19.
 */

public abstract class BaseRootFragment extends Fragment implements View.OnClickListener {
    void startLoginActivity(){
        Intent intent = new Intent(getContext(), LoginActivity.class);
        getContext().startActivity(intent);
    }
    void startSearchActivity(){

    }
}
