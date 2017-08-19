package com.cs.live.MVP.presenter;

import android.content.Context;

import com.cs.live.MVP.model.LiveInfoDateSource;
import com.cs.live.MVP.view.LiveCategoryView;
import com.cs.live.bean.LiveCategory;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/8/20.
 */

public class LiveCategoryImpPresenter implements LiveCategoryPresenter {

    private final Context mContext;
    private final LiveCategoryView mView;
    private final LiveInfoDateSource mDateSource;

    public LiveCategoryImpPresenter(Context context, LiveCategoryView view, LiveInfoDateSource dateSource) {
        this.mContext = context;
        this.mView = view;
        this.mDateSource = dateSource;
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        mDateSource
                .getAllCategories()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<LiveCategory>>() {
                    @Override
                    public void accept(@NonNull List<LiveCategory> list) throws Exception {
                        mView.initLiveListFragment(list);
                        mView.showTabs(list);
                    }
                });
    }
}
