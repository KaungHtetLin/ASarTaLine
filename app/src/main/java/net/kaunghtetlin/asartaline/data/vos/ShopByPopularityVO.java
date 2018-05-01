package net.kaunghtetlin.asartaline.data.vos;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import net.kaunghtetlin.asartaline.data.db.DBConstants;

/**
 * Created by Kaung Htet Lin on 5/1/2018.
 */

@Entity(tableName = DBConstants.SHOP_BY_POPULARITY_TABLE)
public class ShopByPopularityVO {

    @PrimaryKey
    @SerializedName("shopByPopularityId")
    private String shopByPopularityId;

    @Embedded
    @SerializedName("mealShop")
    private MealShopIdVO mealShopId;

    public String getShopByPopularityId() {
        return shopByPopularityId;
    }

    public MealShopIdVO getMealShopId() {
        return mealShopId;
    }

    public void setShopByPopularityId(String shopByPopularityId) {
        this.shopByPopularityId = shopByPopularityId;
    }

    public void setMealShopId(MealShopIdVO mealShopId) {
        this.mealShopId = mealShopId;
    }
}
