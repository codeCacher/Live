package com.cs.live.MVP.view;

import com.cs.live.MVP.BaseView;
import com.cs.live.MVP.presenter.LiveCategoryPresenter;
import com.cs.live.bean.LiveCategory;

import java.util.List;

/**
 * Created by Administrator on 2017/8/18.
 */

public interface LiveCategoryView extends BaseView<LiveCategoryPresenter>{
    void showTabs(List<LiveCategory> list);
    void initLiveListFragment(List<LiveCategory> list);
}
