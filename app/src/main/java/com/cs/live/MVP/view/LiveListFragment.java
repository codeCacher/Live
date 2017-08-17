package com.cs.live.MVP.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    private final int COLUMN_SIZE = 2;
    private LiveListImpPresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_live_list, container, false);
        unbinder = ButterKnife.bind(this, view);

        initEasyRecyclerView();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.start();
    }

    private void initEasyRecyclerView() {
        EasyLiveAdapter easyLiveAdapter = new EasyLiveAdapter(getContext(),new ArrayList<LiveInfo>());
        ervLiveList.setAdapter(easyLiveAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),COLUMN_SIZE);
        gridLayoutManager.setSpanSizeLookup(easyLiveAdapter.obtainGridSpanSizeLookUp(COLUMN_SIZE));
        ervLiveList.setLayoutManager(gridLayoutManager);
        SpaceDecoration spaceDecoration = new SpaceDecoration(DensityUtil.dp2px(getContext(),getResources().getDimension(R.dimen.live_list_padding_size)));
        ervLiveList.addItemDecoration(spaceDecoration);
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
}
