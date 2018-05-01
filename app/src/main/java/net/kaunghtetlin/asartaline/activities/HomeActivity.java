package net.kaunghtetlin.asartaline.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import net.kaunghtetlin.asartaline.R;
import net.kaunghtetlin.asartaline.adapters.OffersAdapter;
import net.kaunghtetlin.asartaline.components.EmptyViewPod;
import net.kaunghtetlin.asartaline.components.SmartRecyclerView;
import net.kaunghtetlin.asartaline.data.models.OffersModel;
import net.kaunghtetlin.asartaline.data.vos.OffersVO;
import net.kaunghtetlin.asartaline.delegates.OfferItemDelegate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements OfferItemDelegate {

    @BindView(R.id.appbar_layout)
    AppBarLayout appBarLayout;

    @BindView(R.id.rv_offers)
    SmartRecyclerView rvOffers;

    @BindView(R.id.vp_empty_offers)
    EmptyViewPod vpEmptyOffers;

    OffersAdapter mOffersAdapter;
    OffersModel mOffersModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this, this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //appbar's color transparent when expand
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            int scrollRange = -1;
            boolean isShow = false;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    appBarLayout.setBackground(new ColorDrawable(Color.parseColor("#FFC107")));
                    isShow = true;
                } else if (isShow) {
                    appBarLayout.setBackground(new ColorDrawable(Color.parseColor("#00000000")));
                    isShow = false;
                }
            }
        });

        //RecyclerView for Offers
        rvOffers.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

        mOffersAdapter = new OffersAdapter(getApplicationContext(), this);
        rvOffers.setEmptyView(vpEmptyOffers);
        rvOffers.setAdapter(mOffersAdapter);

        mOffersModel = ViewModelProviders.of(this).get(OffersModel.class);
        mOffersModel.initDatabase(getApplicationContext());
        mOffersModel.getOffers().observe(this, new Observer<List<OffersVO>>() {
            @Override
            public void onChanged(@Nullable List<OffersVO> offersVOs) {
                mOffersAdapter.setNewData(offersVOs);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTapOffer(long offerId) {
        Intent detailsIntent = DetailsActivity.newIntent(getApplicationContext(),offerId);
        startActivity(detailsIntent);
    }
}
