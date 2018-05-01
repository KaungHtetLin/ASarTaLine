package net.kaunghtetlin.asartaline.network;

import net.kaunghtetlin.asartaline.network.responses.OfferResponse;
import net.kaunghtetlin.asartaline.utils.AppConstants;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Kaung Htet Lin on 5/1/2018.
 */

public interface ASTLApi {

    @FormUrlEncoded
    @POST(AppConstants.API_GET_OFFERS_LISTS)
    Observable<OfferResponse> getOffersList(
            @Field(AppConstants.PARAM_ACCESS_TOKEN) String accessToken);

}
