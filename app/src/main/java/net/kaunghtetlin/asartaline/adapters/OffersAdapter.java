package net.kaunghtetlin.asartaline.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import net.kaunghtetlin.asartaline.R;
import net.kaunghtetlin.asartaline.data.vos.OffersVO;
import net.kaunghtetlin.asartaline.viewholders.OffersViewHolder;

/**
 * Created by Kaung Htet Lin on 4/28/2018.
 */

public class OffersAdapter extends BaseRecyclerAdapter<OffersViewHolder, OffersVO> {

    public OffersAdapter(Context context) {
        super(context);
    }

    @Override
    public OffersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View offerViewScreen = mLayoutInflator.inflate(R.layout.view_item_offer, parent, false);
        return new OffersViewHolder(offerViewScreen);
    }

    @Override
    public void onBindViewHolder(OffersViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 16;
    }
}
