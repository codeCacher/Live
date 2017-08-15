package com.cs.live.MVP.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cs.live.R;
import com.cs.live.bean.LiveCategory;
import com.cs.live.bean.LiveInfo;
import com.cs.live.bean.LiveListResult;
import com.cs.live.http.APIRetrofit;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/8/14.
 */

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, container, false);

        APIRetrofit
                .getAPIService()
                .getLiveListResult()
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<LiveListResult>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(LiveListResult list) {
                        List<LiveInfo> data = list.getData();
                    }
                });

        APIRetrofit
                .getAPIService()
                .getAllCategories()
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<List<LiveCategory>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<LiveCategory> liveCategories) {
                        liveCategories.size();
                    }
                });

        APIRetrofit
                .getAPIService()
                .getLiveListResultByCategories("beauty")
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<LiveListResult>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LiveListResult liveListResult) {
                        List<LiveInfo> data = liveListResult.getData();
                        LiveInfo liveInfo = data.get(0);
                    }
                });


        return view;
    }
}
