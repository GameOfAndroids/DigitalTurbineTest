package com.tm78775.digitalturbinetest.productslist

import com.tm78775.digitalturbinetest.view.recyclerview.adapter.ProductsAdapter
import java.lang.IllegalStateException

class ProductsListPresenter(private val view: ProductsListContract.View): ProductsListContract.Presenter {

    private val model: ProductsListContract.Model = ProductsListModel(this)

    override fun fetchPageOfProducts() {
        view.showProgressBar(true)
        model.fetchPageOfProducts { products, exception ->
            if(exception != null)
                view.onDataFetchException(exception)
            else if(products != null) {
                view.onDataFetchedSuccessfully(products)
            }
            view.showProgressBar(false)
        }
    }

}