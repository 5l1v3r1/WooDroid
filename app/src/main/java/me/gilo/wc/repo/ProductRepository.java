package me.gilo.wc.repo;


import me.gilo.wc.common.WooLiveData;
import me.gilo.woodroid.models.Product;

import javax.inject.Inject;
import java.util.List;

public class ProductRepository extends WoocommerceRepository {

    @Inject
    public ProductRepository() {

    }

    public WooLiveData<List<Product>> products() {
        final WooLiveData<List<Product>> callBack = new WooLiveData();

        woocommerce.ProductRepository().products().enqueue(callBack);
        return callBack;
    }


}
