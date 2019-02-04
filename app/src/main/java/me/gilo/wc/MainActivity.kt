package me.gilo.wc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import me.gilo.wc.ui.MenuActivity
import me.gilo.woodroid.Woocommerce
import me.gilo.woodroid.models.Coupon
import me.gilo.woodroid.models.Product
import java.util.ArrayList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(baseContext, MenuActivity::class.java));
        finish()

    }

//    private fun coupons() {
//        val woocommerce = Woocommerce.Builder()
//            .setSiteUrl("http://157.230.131.179")
//            .setApiVersion("2")
//            .setConsumerKey("ck_26c61abd7eeff238d87dc56585bf26cb2d1a1ec3")
//            .setConsumerSecret("cs_062e8e3a7ae0ce08fdebc0c39f8f834d5e87598e")
//            .build()
//
//        tvText.append("\n")
//        tvText.append("\n")
//        tvText.append("Products")
//        tvText.append("\n")
//        tvText.append("\n")
//
//        woocommerce.Coupon().coupons().enqueue(object : Callback<List<Coupon>> {
//            override fun onResponse(call: Call<List<Coupon>>, response: Response<List<Coupon>>) {
//                val coupons = response.body()
//                for (coupon in coupons!!) {
//                    tvText.append(coupon.description + "\n")
//                }
//            }
//
//            override fun onFailure(call: Call<List<Coupon>>, t: Throwable) {
//
//            }
//        })
//    }
}
