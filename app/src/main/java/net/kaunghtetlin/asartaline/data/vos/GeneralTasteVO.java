package net.kaunghtetlin.asartaline.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import net.kaunghtetlin.asartaline.data.db.DBConstants;

/**
 * Created by Kaung Htet Lin on 5/1/2018.
 */

@Entity(tableName = DBConstants.GENERAL_TASTE_TABLE)
public class GeneralTasteVO {

    @PrimaryKey
    @SerializedName("tasteId")
    private String tasteId;

    @SerializedName("taste")
    private String taste;

    @SerializedName("tasteDesc")
    private String tasteDesc;

    public String getTasteId() {
        return tasteId;
    }

    public String getTaste() {
        return taste;
    }

    public String getTasteDesc() {
        return tasteDesc;
    }

    public void setTasteId(String tasteId) {
        this.tasteId = tasteId;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public void setTasteDesc(String tasteDesc) {
        this.tasteDesc = tasteDesc;
    }
}
