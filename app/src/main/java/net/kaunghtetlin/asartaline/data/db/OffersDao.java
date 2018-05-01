package net.kaunghtetlin.asartaline.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import net.kaunghtetlin.asartaline.data.vos.OffersVO;

import java.util.List;

import static net.kaunghtetlin.asartaline.data.db.DBConstants.OFFERS_TABLE;

/**
 * Created by Kaung Htet Lin on 5/1/2018.
 */

@Dao
public interface OffersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertOffer(OffersVO offers);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertOffers(OffersVO... offers);

    @Query("SELECT * FROM " + OFFERS_TABLE)
    LiveData<List<OffersVO>> getAllOffers();

    @Query("SELECT * FROM " + OFFERS_TABLE + " WHERE id = :id")
    LiveData<OffersVO> getOfferById(long id);

    @Query("DELETE FROM " + OFFERS_TABLE)
    void deleteAll();

}
