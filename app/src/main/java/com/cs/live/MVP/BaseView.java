package com.cs.live.MVP;

/**
 * Created by Administrator on 2017/8/15.
 */

public interface BaseView<P extends BasePresenter> {
    void setPresenter(P presenter);
}
