package net.kaunghtetlin.asartaline.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.aungpyaephyo.mmtextview.components.MMTextView;
import net.kaunghtetlin.asartaline.R;
import net.kaunghtetlin.asartaline.data.models.OffersModel;
import net.kaunghtetlin.asartaline.data.vos.OffersVO;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kaung Htet Lin on 4/29/2018.
 */

public class DetailsActivity extends BaseActivity {

    private static final String KEY_OFFER_ID = "offer_id";

    @BindView(R.id.appbar_layout)
    AppBarLayout appBarLayout;

    @BindView(R.id.iv_details_image)
    ImageView ivDetailsImage;

    @BindView(R.id.tv_details_name)
    MMTextView tvDetailsName;

    @BindView(R.id.tv_details)
    MMTextView tvDetails;

    @BindView(R.id.tv_details_price)
    MMTextView tvOfferPrce;

    public static Intent newIntent(Context context, long offerId) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(KEY_OFFER_ID, offerId);
        return intent;
    }

    private OffersModel mOffersModel;
    private long offerId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_details);
        ButterKnife.bind(this, this);

        ButterKnife.bind(this, this);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        offerId = getIntent().getLongExtra(KEY_OFFER_ID, -1);

        mOffersModel = ViewModelProviders.of(this).get(OffersModel.class);
        mOffersModel.initDatabase(getApplicationContext());
        mOffersModel.getOfferById(offerId).observe(this, new Observer<OffersVO>() {
            @Override
            public void onChanged(@Nullable OffersVO offersVO) {
                bind(offersVO);
            }
        });
    }

    private void bind(OffersVO offersVO) {
        if (offersVO != null) {
            if (offersVO.getOfferName() != null) {
                tvDetailsName.setText(offersVO.getOfferName());
            }
            if (offersVO.getGeneralTastes() != null) {
                for (int i = 0; i < offersVO.getGeneralTastes().size(); i++) {
                    tvDetails.setText(offersVO.getGeneralTastes().get(i).getTasteDesc() + "\n");
                }
            }
            if (offersVO.getImages() != null && offersVO.getImages().length > 0) {
                String imageUrl = offersVO.getImages()[0];
                Glide.with(getApplicationContext())
                        .load(imageUrl)
                        .into(ivDetailsImage);
            }
            tvOfferPrce.setText((offersVO.getPriceRangeMin() + offersVO.getPriceRangeMax()) / 2+" ks");
        }
    }
}
