package me.gilo.woodroid.core.cart

import androidx.lifecycle.LiveData
import me.gilo.woodroid.core.cart.lines.LineItem


abstract class CartRepository{

    abstract fun clear(): LiveData<String>
    abstract fun count(id: Int): LiveData<Int>
    abstract fun cart(): LiveData<Cart>
    abstract fun addToCart(cartItem: CartItem)
    abstract fun delete(cartId: String): LiveData<String>
    abstract fun restore(cartId: String): LiveData<String>
    abstract fun update(cartId: String, quantity: Int)

}
