package net.kaunghtetlin.asartaline.data.db;

import android.arch.persistence.room.TypeConverter;

/**
 * Created by Kaung Htet Lin on 5/1/2018.
 */

public class ImageConvector {
    @TypeConverter
    public static String[] toStringArray(String images) {
        return images.split(",");
    }

    @TypeConverter
    public static String toString(String[] images) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String image : images) {
            stringBuilder.append(image).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
