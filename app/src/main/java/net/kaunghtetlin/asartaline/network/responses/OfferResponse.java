package net.kaunghtetlin.asartaline.network.responses;

import com.google.gson.annotations.SerializedName;

import net.kaunghtetlin.asartaline.data.vos.OffersVO;

import java.util.List;

/**
 * Created by Kaung Htet Lin on 5/1/2018.
 */

public class OfferResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("astlWarDee")
    private List<OffersVO> offersList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public List<OffersVO> getOffersList() {
        return offersList;
    }
}
