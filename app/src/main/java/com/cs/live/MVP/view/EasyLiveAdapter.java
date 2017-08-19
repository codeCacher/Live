package com.cs.live.MVP.view;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.cs.live.R;
import com.cs.live.bean.LiveInfo;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;


/**
 *
 */

public class EasyLiveAdapter extends RecyclerArrayAdapter<LiveInfo> {

    public EasyLiveAdapter(Context context, List<LiveInfo> objects) {
        super(context, objects);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new LiveViewHolder(parent);
    }

    private static class LiveViewHolder extends BaseViewHolder<LiveInfo> {

        SimpleDraweeView ivThumb;
        TextView tvTitle;
        TextView tvName;
        TextView tvViewer;

        LiveViewHolder(ViewGroup parent) {
            super(parent, R.layout.live_list_item);

            ivThumb = $(R.id.iv_thumb);
            tvTitle = $(R.id.tvTitle);
            tvName = $(R.id.tvName);
            tvViewer = $(R.id.tvViewer);
        }

        @Override
        public void setData(LiveInfo data) {
            super.setData(data);

            ivThumb.setImageURI(data.getThumb());
            tvTitle.setText(data.getTitle());
            tvName.setText(data.getNick());
            tvViewer.setText(data.getView());
        }
    }
}
