package com.cs.live.MVP.model;

import com.cs.live.MVP.BaseModel;
import com.cs.live.bean.LiveCategory;
import com.cs.live.bean.LiveInfo;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/15.
 */

interface LiveInfoModel extends BaseModel {
    Observable<List<LiveInfo>> getAllLiveList();
    Observable<List<LiveInfo>> getLiveListByCategory(String slug);
    Observable<List<LiveCategory>> getAllCategories();
}
