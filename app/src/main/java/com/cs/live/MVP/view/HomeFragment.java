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

import com.cs.live.MVP.model.LiveInfoDateSource;
import com.cs.live.MVP.presenter.LiveCategoryImpPresenter;
import com.cs.live.MVP.presenter.LiveCategoryPresenter;
import com.cs.live.R;
import com.cs.live.bean.LiveCategory;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/14.
 */

public class HomeFragment extends BaseRootFragment implements LiveCategoryView {
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
    private LiveCategoryPresenter mPresenter;
    private List<Fragment> mFragmentList = new ArrayList<>();
    private FragmentPagerAdapter mPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);

        mPresenter = new LiveCategoryImpPresenter(getContext(), this, new LiveInfoDateSource());

        tlIndicator.setupWithViewPager(vpFragment);
        mPagerAdapter = new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        };
        vpFragment.setAdapter(mPagerAdapter);
        vpFragment.setOffscreenPageLimit(2);


        mPresenter.start();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void setPresenter(LiveCategoryPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_message:
                //TODO 要判断当前有没有登录
                startLoginActivity();
                break;

            case R.id.iv_search:
                startSearchActivity();
                break;
        }
    }

    @Override
    public void showTabs(List<LiveCategory> list) {
        int i=0;
        for (LiveCategory e : list) {
            if (e.isDefault()) {
                TabLayout.Tab tab = tlIndicator.getTabAt(i++);
                if (tab==null) continue;
                tab.setText(e.getName());
            }
        }
    }

    @Override
    public void initLiveListFragment(List<LiveCategory> list) {
        for (LiveCategory e : list) {
            if (e.isDefault()) {
                LiveListFragment liveListFragment = new LiveListFragment();
                liveListFragment.setSlug(e.getSlug());
                mFragmentList.add(liveListFragment);
            }
        }
        mPagerAdapter.notifyDataSetChanged();
    }
}

