package me.gilo.woodroid.data;


import me.gilo.woodroid.models.Coupon;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ShippingZoneLocationAPI {

    @Headers("Content-Type: application/json")
    @POST("coupons")
    Call<Coupon> create(@Body Coupon body);

    @GET("coupons/{id}")
    Call<Coupon> view(@Path("id") int id);

    @GET("coupons")
    Call<List<Coupon>> list();

    @Headers("Content-Type: application/json")
    @PUT("coupons/{id}")
    Call<Coupon> update(@Path("id") int id, @Body Coupon body);

    @DELETE("coupons/{id}")
    Call<Coupon> delete(@Path("id") int id);

    @DELETE("coupons/{id}")
    Call<Coupon> delete(@Path("id") int id, @Query("force") boolean force);

    @POST("coupons/batch")
    Call<String> batch(@Body Coupon body);

}