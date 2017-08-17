package com.cs.live.MVP.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cs.live.R;
import com.cs.live.bean.LiveCategory;
import com.cs.live.bean.LiveInfo;
import com.cs.live.bean.LiveListResult;
import com.cs.live.http.APIRetrofit;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/8/14.
 */

public class HomeFragment extends Fragment {
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.iv_message)
    ImageView ivMessage;
    @BindView(R.id.tlIndicator)
    TabLayout tlIndicator;
    @BindView(R.id.ivMore)
    ImageView ivMore;
    @BindView(R.id.vpFragment)
    ViewPager vpFragment;
    @BindView(R.id.ivFab)
    ImageView ivFab;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);

        final List<Fragment> fragmentList = new ArrayList<>();
        LiveListFragment liveListFragment = new LiveListFragment();
        fragmentList.add(liveListFragment);

        vpFragment.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

