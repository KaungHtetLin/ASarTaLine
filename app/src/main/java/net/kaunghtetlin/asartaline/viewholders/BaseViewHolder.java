package net.kaunghtetlin.asartaline.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Kaung Htet Lin on 4/28/2018.
 */


public abstract class BaseViewHolder<W> extends RecyclerView.ViewHolder implements View.OnClickListener {

    private W mData;

    public BaseViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        ButterKnife.bind(this,itemView);
    }

    public abstract void setData(W data);

    public abstract void bind(Context context);
}