package com.cs.live.MVP.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cs.live.MVP.model.LiveInfoDateSource;
import com.cs.live.MVP.presenter.LiveListImpPresenter;
import com.cs.live.R;
import com.cs.live.bean.LiveInfo;
import com.cs.live.utils.DensityUtil;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/14.
 */

public class LiveListFragment extends Fragment implements LiveListView {
    @BindView(R.id.ervLiveList)
    EasyRecyclerView ervLiveList;
    Unbinder unbinder;

    private LiveListImpPresenter mPresenter;
    private EasyLiveAdapter mAdapter;
    private String mSlug = LiveInfoDateSource.SLUG_ALL_LIVE;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_live_list, container, false);
        unbinder = ButterKnife.bind(this, view);

        initEasyRecyclerView();

        mPresenter = new LiveListImpPresenter(getContext(),this,new LiveInfoDateSource(),mSlug);
        mPresenter.start();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void setPresenter(LiveListImpPresenter presenter) {
        this.mPresenter = presenter;
    }


    @Override
    public void showList(List<LiveInfo> list) {
        mAdapter.clear();
        mAdapter.addAll(list);
    }

    @Override
    public void showLoading() {
        ervLiveList.showProgress();
    }

    @Override
    public void showLoadError() {
        ervLiveList.showError();
    }

    @Override
    public void showNoneContent() {
        ervLiveList.showEmpty();
    }


    private void initEasyRecyclerView() {
        int COLUMN_SIZE = 2;

        mAdapter = new EasyLiveAdapter(getContext(),new ArrayList<LiveInfo>());
        ervLiveList.setAdapter(mAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), COLUMN_SIZE);
        gridLayoutManager.setSpanSizeLookup(mAdapter.obtainGridSpanSizeLookUp(COLUMN_SIZE));
        ervLiveList.setLayoutManager(gridLayoutManager);

        SpaceDecoration spaceDecoration = new SpaceDecoration(DensityUtil.dp2px(getContext(),getResources().getDimension(R.dimen.live_list_padding_size)));
        ervLiveList.addItemDecoration(spaceDecoration);
    }

    /**
     * 设置该Fragment的分类slug,默认为显示全部
     * @param slug 分类标识
     */
    public void setSlug(String slug){
        this.mSlug = slug;
        if(mPresenter!=null){
            mPresenter.mSlug = slug;
        }
    }

    public String getSlug(){
        return mSlug;
    }
}
