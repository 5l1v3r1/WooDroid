package me.gilo.wc.adapter.viewholder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.View
import android.widget.TextView
import me.gilo.wc.R
import me.gilo.woodroid.models.Coupon

class CouponViewHolder(val context: Context, itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    fun renderView(coupon: Coupon) {
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)

        tvTitle.text = coupon.code.toUpperCase()
        tvDescription.text = Html.fromHtml(coupon.description)
    }


}