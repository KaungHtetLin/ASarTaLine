package net.kaunghtetlin.asartaline.data.vos;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import net.kaunghtetlin.asartaline.data.db.DBConstants;

/**
 * Created by Kaung Htet Lin on 5/1/2018.
 */

@Entity(tableName = DBConstants.SHOP_BY_DISTANCE_TABLE)
public class ShopByDistanceVO {

    @PrimaryKey
    @SerializedName("shopByDistanceId")
    private String shopByDistanceId;

    @Embedded
    @SerializedName("mealShop")
    private MealShopIdVO mealShopId;

    @SerializedName("distanceInFeet")
    private String distanceInFeet;

    public String getShopByDistanceId() {
        return shopByDistanceId;
    }

    public MealShopIdVO getMealShopId() {
        return mealShopId;
    }

    public String getDistanceInFeet() {
        return distanceInFeet;
    }

    public void setShopByDistanceId(String shopByDistanceId) {
        this.shopByDistanceId = shopByDistanceId;
    }

    public void setMealShopId(MealShopIdVO mealShopId) {
        this.mealShopId = mealShopId;
    }

    public void setDistanceInFeet(String distanceInFeet) {
        this.distanceInFeet = distanceInFeet;
    }
}
