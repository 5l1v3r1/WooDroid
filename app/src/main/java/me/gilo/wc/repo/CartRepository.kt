package me.gilo.wc.repo


import android.content.Context
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import me.gilo.wc.common.CompletionGenericLiveData
import me.gilo.wc.common.QueryLiveData
import me.gilo.wc.common.WooLiveData
import me.gilo.wc.models.CartLineItem
import me.gilo.woodroid.Woocommerce
import me.gilo.woodroid.models.LineItem
import me.gilo.woodroid.models.Product
import javax.inject.Inject

open class CartRepository @Inject
constructor() {

    @Inject
    lateinit var woocommerce: Woocommerce


    private val cart: CollectionReference = FirebaseFirestore.getInstance()
        .collection("users")
        .document(FirebaseAuth.getInstance().currentUser!!.uid)
        .collection("cart")

    fun cart(): QueryLiveData<CartLineItem> {
        return QueryLiveData(cart, CartLineItem::class.java)
    }

    fun deleteItem(cartLineItem: CartLineItem): CompletionGenericLiveData<Void> {
        val completion = CompletionGenericLiveData<Void>()
        cart.document(cartLineItem.getId()).delete().addOnCompleteListener(completion)

        return completion
    }

    fun setQuantity(cartLineItem: CartLineItem, quantity: Int): CompletionGenericLiveData<Void> {
        val completion = CompletionGenericLiveData<Void>()
        cartLineItem.setQuantity(quantity)

        cart.document(cartLineItem.getId()).set(cartLineItem).addOnCompleteListener(completion)

        return completion
    }

    fun deleteItems(): CompletionGenericLiveData<Void> {
        val completion = CompletionGenericLiveData<Void>()
        deleteCartItems().addOnCompleteListener(completion)
        return completion
    }


    private fun deleteCartItems(): Task<Void> {
        return cart.firestore.runTransaction {
            cart.get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        cart.document(document.id).delete()
                    }

                } else {
                }
            }

            null
        }
    }


    fun addToCart(product: Product): CompletionGenericLiveData<DocumentReference> {
        val completion = CompletionGenericLiveData<DocumentReference>()

        val lineItem = CartLineItem()
        lineItem.setProductId(product.id)
        lineItem.product = product
        lineItem.setQuantity(1)

        cart.add(lineItem).addOnCompleteListener(completion)

        return completion

    }

    fun cart(context: Context): WooLiveData<Map<String, LineItem>> {
        val callBack = WooLiveData<Map<String, LineItem>>()
        woocommerce!!.CartRepository(context).cart().enqueue(callBack)

        return callBack
    }

}
