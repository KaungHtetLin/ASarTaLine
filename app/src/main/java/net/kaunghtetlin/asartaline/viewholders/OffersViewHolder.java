package net.kaunghtetlin.asartaline.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.aungpyaephyo.mmtextview.components.MMTextView;
import net.kaunghtetlin.asartaline.R;
import net.kaunghtetlin.asartaline.data.vos.OffersVO;
import net.kaunghtetlin.asartaline.delegates.OfferItemDelegate;

import butterknife.BindView;

/**
 * Created by Kaung Htet Lin on 4/28/2018.
 */

public class OffersViewHolder extends BaseViewHolder<OffersVO> {

//    @BindView(R.id.)

    @BindView(R.id.tv_offer_name)
    MMTextView tvOfferName;

    @BindView(R.id.tv_offer_category)
    MMTextView tvOfferCategory;

    @BindView(R.id.tv_offer_price)
    MMTextView tvOfferPrice;

    @BindView(R.id.iv_hero_image)
    ImageView ivHeroImage;

    private OfferItemDelegate mOfferItemDelegate;
    private OffersVO mOffers;

    public OffersViewHolder(View itemView, OfferItemDelegate offerItemDelegate) {
        super(itemView);
        mOfferItemDelegate = offerItemDelegate;
    }

    @Override
    public void setData(OffersVO data) {
        mOffers = data;
    }

    @Override
    public void bind(Context context) {
        if (mOffers != null) {

            if (mOffers.getOfferName() != null) {
                tvOfferName.setText(mOffers.getOfferName());
            }

            if (mOffers.getGeneralTastes() != null && mOffers.getGeneralTastes().size() > 0) {
                String category = "";
                for (int i = 0; i < mOffers.getGeneralTastes().size(); i++) {
                    category += mOffers.getGeneralTastes().get(i).getTaste();
                    if (i < mOffers.getGeneralTastes().size() - 1) {
                        category += ",";
                    }
                }
                tvOfferCategory.setText(category);
            }

            tvOfferPrice.setText(((mOffers.getPriceRangeMax() + mOffers.getPriceRangeMin()) / 2) + " ks");


            if (mOffers.getImages() != null && mOffers.getImages().length > 0) {
                String imageUrl = mOffers.getImages()[0];
                Glide.with(context)
                        .load(imageUrl)
                        .into(ivHeroImage);
            }
        }
    }

    @Override
    public void onClick(View view) {
        mOfferItemDelegate.onTapOffer(mOffers.getId());
    }
}
