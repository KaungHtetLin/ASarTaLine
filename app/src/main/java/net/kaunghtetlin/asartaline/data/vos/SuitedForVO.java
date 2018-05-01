package net.kaunghtetlin.asartaline.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import net.kaunghtetlin.asartaline.data.db.DBConstants;

/**
 * Created by Kaung Htet Lin on 5/1/2018.
 */

@Entity(tableName = DBConstants.SUITED_FOR_TABLE)
public class SuitedForVO {

    @PrimaryKey
    @SerializedName("suitedForId")
    private String suitedForId;

    @SerializedName("suitedFor")
    private String suitedFor;

    @SerializedName("suitedForDesc")
    private String suitedForDesc;

    public String getSuitedForId() {
        return suitedForId;
    }

    public String getSuitedFor() {
        return suitedFor;
    }

    public String getSuitedForDesc() {
        return suitedForDesc;
    }

    public void setSuitedForId(String suitedForId) {
        this.suitedForId = suitedForId;
    }

    public void setSuitedFor(String suitedFor) {
        this.suitedFor = suitedFor;
    }

    public void setSuitedForDesc(String suitedForDesc) {
        this.suitedForDesc = suitedForDesc;
    }
}
