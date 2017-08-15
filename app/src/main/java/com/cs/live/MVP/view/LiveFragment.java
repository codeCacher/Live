package com.cs.live.MVP.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.cs.live.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/14.
 */

public class LiveFragment extends Fragment {
    @BindView(R.id.ivSearch)
    ImageView ivSearch;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.ivMessage)
    ImageView ivMessage;
    @BindView(R.id.fragmentContent)
    FrameLayout fragmentContent;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_live, container, false);
        unbinder = ButterKnife.bind(this, view);

        initUI();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initUI(){
        tvTitle.setText(getResources().getString(R.string.live_title));
    }
}
