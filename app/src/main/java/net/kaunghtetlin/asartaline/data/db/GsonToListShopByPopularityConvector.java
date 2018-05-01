package net.kaunghtetlin.asartaline.data.db;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.kaunghtetlin.asartaline.data.vos.ShopByPopularityVO;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Kaung Htet Lin on 5/1/2018.
 */

public class GsonToListShopByPopularityConvector {

    @TypeConverter
    public static List<ShopByPopularityVO> fromString(String value) {
        Type listType = new TypeToken<List<ShopByPopularityVO>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(List<ShopByPopularityVO> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

}
