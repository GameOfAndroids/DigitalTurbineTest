package com.tm78775.digitalturbinetest.productslist

import com.tm78775.digitalturbinetest.view.recyclerview.adapter.ProductsAdapter
import com.tm78775.digitalturbinetest.datamodel.Product
import com.tm78775.digitalturbinetest.viewmodel.ProductsViewModel

interface ProductsListContract {

    /**
     * Presenter contract
     */
    interface Presenter {
        fun onAttach(model: ProductsViewModel)
        fun onDetach()
        fun getAdapter(): ProductsAdapter
        fun onBottomReached()
        fun fetchPageOfProducts()
        fun resetPageToFetch()
    }

}