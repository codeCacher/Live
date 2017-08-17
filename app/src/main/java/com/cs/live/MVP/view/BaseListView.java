package com.cs.live.MVP.view;

import com.cs.live.MVP.BaseView;
import com.cs.live.MVP.presenter.BaseListPresenter;

import java.util.List;

/**
 * Created by Administrator on 2017/8/15.
 */

public interface BaseListView<T extends Object, P extends BaseListPresenter> extends BaseView<P> {
    void showList(List<T> list);
    void showLoading();
    void showLoadError();
    void showNoneContent();
}
