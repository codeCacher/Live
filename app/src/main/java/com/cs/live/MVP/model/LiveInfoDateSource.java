package com.cs.live.MVP.model;

import com.cs.live.bean.LiveCategory;
import com.cs.live.bean.LiveInfo;
import com.cs.live.bean.LiveListResult;
import com.cs.live.http.APIRetrofit;
import com.cs.live.http.APIService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/8/17.
 */

public class LiveInfoDateSource implements LiveInfoModel {

    public static String SLUG_ALL_LIVE = "slug_all_live";

    private APIService getAPIService() {
        return APIRetrofit.getAPIService();
    }

    @Override
    public Observable<List<LiveInfo>> getAllLiveList() {

        return getAPIService()
                .getLiveList()
                .map(new Function<LiveListResult, List<LiveInfo>>() {
                    @Override
                    public List<LiveInfo> apply(@NonNull LiveListResult liveListResult) throws Exception {
                        return liveListResult.getData();
                    }
                })
                .subscribeOn(Schedulers.newThread());
    }

    @Override
    public Observable<List<LiveInfo>> getLiveListByCategory(String slug) {
        if(slug.equals(SLUG_ALL_LIVE)){
            return getAllLiveList();
        }else {
            return getAPIService()
                    .getLiveListByCategories(slug)
                    .map(new Function<LiveListResult, List<LiveInfo>>() {
                        @Override
                        public List<LiveInfo> apply(@NonNull LiveListResult liveListResult) throws Exception {
                            return liveListResult.getData();
                        }
                    })
                    .subscribeOn(Schedulers.newThread());
        }
    }

    @Override
    public Observable<List<LiveCategory>> getAllCategories() {
        return getAPIService()
                .getAllCategories()
                .subscribeOn(Schedulers.newThread());
    }
}
