package com.cs.live.MVP.presenter;

import android.content.Context;
import android.support.annotation.MainThread;

import com.cs.live.MVP.model.LiveInfoDateSource;
import com.cs.live.MVP.view.LiveListView;
import com.cs.live.bean.LiveInfo;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/8/17.
 */

public class LiveListImpPresenter implements LiveListPresenter {

    private Context mContext;
    private LiveListView mView;
    private LiveInfoDateSource mDateSource;
    public String mSlug;

    public LiveListImpPresenter(Context context, LiveListView mView, LiveInfoDateSource dateSource,String slug) {
        this.mContext = context;
        this.mView = mView;
        this.mDateSource = dateSource;
        this.mSlug = slug;
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        mView.showLoading();
        mDateSource
                .getLiveListByCategory(mSlug)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<LiveInfo>>() {
                    @Override
                    public void accept(@NonNull List<LiveInfo> list) throws Exception {
                        if (list == null || list.size() == 0) {
                            mView.showNoneContent();
                        } else {
                            mView.showList(list);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mView.showLoadError();
                    }
                });
    }

    @Override
    public void refreshList() {

    }

    @Override
    public void addMoreElement() {

    }
}
