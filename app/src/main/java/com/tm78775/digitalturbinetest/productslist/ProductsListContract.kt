package com.tm78775.digitalturbinetest.productslist

import com.tm78775.digitalturbinetest.adapter.ProductsAdapter
import com.tm78775.digitalturbinetest.datamodel.Product
import com.tm78775.digitalturbinetest.viewmodel.MainActivityViewModel

interface ProductsListContract {

    /**
     * View contract
     */
    interface View {
        fun showProgressBar(show: Boolean)
        fun notifyDataSetChanged()
        fun showFetchError()
        fun onProductClicked(product: Product)
    }

    /**
     * Presenter contract
     */
    interface Presenter {
        fun onAttach(model: MainActivityViewModel)
        fun onDetach()
        fun getAdapter(): ProductsAdapter
        fun onBottomReached()
        fun displayProductsList()
    }

}