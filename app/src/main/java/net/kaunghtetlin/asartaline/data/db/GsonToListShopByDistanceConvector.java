package net.kaunghtetlin.asartaline.data.db;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.kaunghtetlin.asartaline.data.vos.ShopByDistanceVO;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Kaung Htet Lin on 5/1/2018.
 */

public class GsonToListShopByDistanceConvector {

    @TypeConverter
    public static List<ShopByDistanceVO> fromString(String value) {
        Type listType = new TypeToken<List<ShopByDistanceVO>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(List<ShopByDistanceVO> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

}
