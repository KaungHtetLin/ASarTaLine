package net.kaunghtetlin.asartaline.data.models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.util.Log;

import net.kaunghtetlin.asartaline.ASTLApp;
import net.kaunghtetlin.asartaline.data.db.AppDatabase;
import net.kaunghtetlin.asartaline.data.vos.OffersVO;
import net.kaunghtetlin.asartaline.network.responses.OfferResponse;
import net.kaunghtetlin.asartaline.utils.AppConstants;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Kaung Htet Lin on 5/1/2018.
 */

public class OffersModel extends BaseModel {

    Observable<OfferResponse> offersResponseObservable;
    private AppDatabase mAppDatabase;
    private MutableLiveData<List<OffersVO>> mOffers;

    public OffersModel() {
        initTheApi();
        mOffers = new MutableLiveData<>();
        LoadOffers();
    }

    public void initDatabase(Context context) {
        mAppDatabase = AppDatabase.getInMemoryDatabase(context);
    }

    public LiveData<List<OffersVO>> getOffers() {
        return mAppDatabase.offersDao().getAllOffers();
//       return mOffers;
    }

    public LiveData<OffersVO> getOfferById(long offerId) {
        return mAppDatabase.offersDao().getOfferById(offerId);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        AppDatabase.destroyInstance();
    }

    public void LoadOffers() {
        offersResponseObservable = theApi.getOffersList(AppConstants.ACCESS_TOKEN);
        offersResponseObservable
                .subscribeOn(Schedulers.io()) //run value creation code on a specific thread (non-UI thread)
                .observeOn(AndroidSchedulers.mainThread()) //observe the emitted value of the Observable on an appropriate thread
                .map(new Function<OfferResponse, List<OffersVO>>() {
                    @Override
                    public List<OffersVO> apply(@NonNull OfferResponse offersResponse) throws Exception {
                        return offersResponse.getOffersList();
                    }
                })
                .subscribe(new Observer<List<OffersVO>>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(List<OffersVO> offersVOS) {
                        mAppDatabase.offersDao().deleteAll();
                        long[] insertedIds = mAppDatabase.offersDao().insertOffers(offersVOS.toArray(new OffersVO[0]));
                        Log.d(ASTLApp.LOG_TAG, "Total inserted offers count : " + insertedIds.length);
//                        mOffers.setValue(offersVOS);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(ASTLApp.LOG_TAG, e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(ASTLApp.LOG_TAG, "complete");
                    }
                });
    }

}
