package com.tm78775.digitalturbinetest.productslist

import com.tm78775.digitalturbinetest.view.recyclerview.adapter.ProductsAdapter
import com.tm78775.digitalturbinetest.datamodel.Product

interface ProductsListContract {

    /**
     * View contract
     */
    interface View {
        fun showProgressBar(show: Boolean)
        fun onDataFetchedSuccessfully(products: ArrayList<Product>)
        fun onDataFetchException(ex: Exception)
    }

    /**
     * Presenter contract
     */
    interface Presenter {
        fun fetchPageOfProducts()
    }

    /**
     * Model contract
     */
    interface Model {
        fun fetchPageOfProducts(callback: (ArrayList<Product>?, Exception?) -> Unit)
    }

}