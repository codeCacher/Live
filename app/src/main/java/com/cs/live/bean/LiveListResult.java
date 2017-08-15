package com.cs.live.bean;

import java.util.List;

/**
 * 直播列表
 */
public class LiveListResult {

    private int total;
    private int pageCount;
    private int size;

    private List<LiveInfo> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<LiveInfo> getData() {
        return data;
    }

    public void setData(List<LiveInfo> data) {
        this.data = data;
    }
}
