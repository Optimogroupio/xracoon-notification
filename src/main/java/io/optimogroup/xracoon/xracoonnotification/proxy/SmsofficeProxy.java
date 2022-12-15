package io.optimogroup.xracoon.xracoonnotification.proxy;


import io.optimogroup.xracoon.xracoonnotification.dto.SmsOfficeResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SmsofficeProxy {

    @FormUrlEncoded
    @POST("v2/send/")
    Call<SmsOfficeResponse> sendSms(@Field("key") String key,
                                    @Field("destination") String destination,
                                    @Field("sender") String sender,
                                    @Field("content") String content);
}
