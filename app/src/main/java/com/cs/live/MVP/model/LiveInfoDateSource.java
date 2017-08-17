package com.cs.live.MVP.model;

import com.cs.live.bean.LiveCategory;
import com.cs.live.bean.LiveInfo;
import com.cs.live.bean.LiveListResult;
import com.cs.live.http.APIRetrofit;
import com.cs.live.http.APIService;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/8/17.
 */

public class LiveInfoDateSource implements LiveInfoModel {

    private APIService getAPIService() {
        return APIRetrofit.getAPIService();
    }

    @Override
    public Observable<List<LiveInfo>> getAllLiveList() {

        return getAPIService()
                .getLiveList()
                .map(new Func1<LiveListResult, List<LiveInfo>>() {
                    @Override
                    public List<LiveInfo> call(LiveListResult liveListResult) {
                        return liveListResult.getData();
                    }
                })
                .subscribeOn(Schedulers.newThread());
    }

    @Override
    public Observable<List<LiveInfo>> getLiveListByCategory(String slug) {
        return getAPIService()
                .getLiveListByCategories(slug)
                .map(new Func1<LiveListResult, List<LiveInfo>>() {
                    @Override
                    public List<LiveInfo> call(LiveListResult liveListResult) {
                        return liveListResult.getData();
                    }
                }).subscribeOn(Schedulers.newThread());
    }

    @Override
    public Observable<List<LiveCategory>> getAllCategories() {
        return getAPIService()
                .getAllCategories()
                .subscribeOn(Schedulers.newThread());
    }
}
