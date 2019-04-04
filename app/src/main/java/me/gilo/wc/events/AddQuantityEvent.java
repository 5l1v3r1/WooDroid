package me.gilo.wc.events;

import me.gilo.wc.models.CartLineItem;
import me.gilo.woodroid.models.ProductReview;

public class AddQuantityEvent {

    CartLineItem cartLineItem;

    public AddQuantityEvent(CartLineItem cartLineItem) {
        this.cartLineItem = cartLineItem;
    }

    public CartLineItem getCartLineItem() {
        return cartLineItem;
    }

    public void setCartLineItem(CartLineItem cartLineItem) {
        this.cartLineItem = cartLineItem;
    }
}
