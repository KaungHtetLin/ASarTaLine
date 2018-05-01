package net.kaunghtetlin.asartaline.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

import net.kaunghtetlin.asartaline.data.db.DBConstants;
import net.kaunghtetlin.asartaline.data.db.GsonToListGeneralTastesConvector;
import net.kaunghtetlin.asartaline.data.db.GsonToListMatchWarDeeConvector;
import net.kaunghtetlin.asartaline.data.db.GsonToListShopByDistanceConvector;
import net.kaunghtetlin.asartaline.data.db.GsonToListShopByPopularityConvector;
import net.kaunghtetlin.asartaline.data.db.GsonToListSuitedForConvector;
import net.kaunghtetlin.asartaline.data.db.ImageConvector;

import java.util.List;

/**
 * Created by Kaung Htet Lin on 4/28/2018.
 */

@Entity(tableName = DBConstants.OFFERS_TABLE)
@TypeConverters({ImageConvector.class, GsonToListGeneralTastesConvector.class,
        GsonToListSuitedForConvector.class, GsonToListMatchWarDeeConvector.class,
        GsonToListShopByDistanceConvector.class, GsonToListShopByPopularityConvector.class})
public class OffersVO {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @SerializedName("warDeeId")
    private String offerId;

    @SerializedName("name")
    private String offerName;

    @SerializedName("images")
    private String[] images;

    @SerializedName("generalTaste")
    private List<GeneralTasteVO> generalTastes;

    @SerializedName("suitedFor")
    private List<SuitedForVO> suitedFor;

    @SerializedName("priceRangeMin")
    private int priceRangeMin;

    @SerializedName("priceRangeMax")
    private int priceRangeMax;

    @SerializedName("matchWarDeeList")
    private List<MatchWarDeeListVO> matchWarDee;

    @SerializedName("shopByDistance")
    private List<ShopByDistanceVO> shopByDistance;

    @SerializedName("shopByPopularity")
    private List<ShopByPopularityVO> shopByPopularity;

    public long getId() {
        return id;
    }

    public String getOfferId() {
        return offerId;
    }

    public String getOfferName() {
        return offerName;
    }

    public String[] getImages() {
        return images;
    }

    public List<GeneralTasteVO> getGeneralTastes() {
        return generalTastes;
    }

    public List<SuitedForVO> getSuitedFor() {
        return suitedFor;
    }

    public int getPriceRangeMin() {
        return priceRangeMin;
    }

    public int getPriceRangeMax() {
        return priceRangeMax;
    }

    public List<MatchWarDeeListVO> getMatchWarDee() {
        return matchWarDee;
    }

    public List<ShopByDistanceVO> getShopByDistance() {
        return shopByDistance;
    }

    public List<ShopByPopularityVO> getShopByPopularity() {
        return shopByPopularity;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public void setGeneralTastes(List<GeneralTasteVO> generalTastes) {
        this.generalTastes = generalTastes;
    }

    public void setSuitedFor(List<SuitedForVO> suitedFor) {
        this.suitedFor = suitedFor;
    }

    public void setPriceRangeMin(int priceRangeMin) {
        this.priceRangeMin = priceRangeMin;
    }

    public void setPriceRangeMax(int priceRangeMax) {
        this.priceRangeMax = priceRangeMax;
    }

    public void setMatchWarDee(List<MatchWarDeeListVO> matchWarDee) {
        this.matchWarDee = matchWarDee;
    }

    public void setShopByDistance(List<ShopByDistanceVO> shopByDistance) {
        this.shopByDistance = shopByDistance;
    }

    public void setShopByPopularity(List<ShopByPopularityVO> shopByPopularity) {
        this.shopByPopularity = shopByPopularity;
    }
}

