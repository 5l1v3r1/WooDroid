package me.gilo.wc.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.gilo.wc.R
import me.gilo.wc.adapter.viewholder.CouponViewHolder
import me.gilo.woodroid.models.Coupon

class CouponAdapter(private val coupons: List<Coupon>) : RecyclerView.Adapter<CouponViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouponViewHolder {
        return CouponViewHolder(
            parent.context,
            LayoutInflater.from(parent.context).inflate(R.layout.single_coupon_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CouponViewHolder, position: Int) {
        holder.renderView(coupons[position])
    }


    override fun getItemCount(): Int {
        return if (coupons.size == 0) 0 else coupons.size
    }
}
