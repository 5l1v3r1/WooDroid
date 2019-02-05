package me.gilo.woodroid.data;


import me.gilo.woodroid.models.Coupon;
import me.gilo.woodroid.models.OrderNote;
import me.gilo.woodroid.models.Refund;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface RefundAPI {

    @Headers("Content-Type: application/json")
    @POST("orders/{id}/refunds")
    Call<Refund> create(@Body Refund body);

    @GET("orders/{id}/refunds/{refund_id}")
    Call<Refund> view(@Path("id") int order_id, @Path("refund_id") int refund_id);

    @GET("orders/{id}/refunds")
    Call<List<Refund>> list(@Path("id") int order_id);

    @DELETE("orders/{id}/refunds/{refund_id}")
    Call<Refund> delete(@Path("id") int order_id, @Path("refund_id") int refund_id);

    @DELETE("orders/{id}/refunds/{refund_id}")
    Call<Refund> delete(@Path("id") int order_id, @Path("refund_id") int refund_id, @Query("force") boolean force);

}