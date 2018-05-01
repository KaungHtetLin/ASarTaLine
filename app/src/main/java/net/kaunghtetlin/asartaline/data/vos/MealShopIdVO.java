package net.kaunghtetlin.asartaline.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import net.kaunghtetlin.asartaline.data.db.DBConstants;

/**
 * Created by Kaung Htet Lin on 5/1/2018.
 */

@Entity(tableName = DBConstants.MEAL_SHOP_ID_TABLE)
public class MealShopIdVO {

    @PrimaryKey
    @SerializedName("mealShopId")
    private String mealShopId;

    public String getMealShopId() {
        return mealShopId;
    }

    public void setMealShopId(String mealShopId) {
        this.mealShopId = mealShopId;
    }
}
