package com.tm78775.digitalturbinetest.productslist

import com.tm78775.digitalturbinetest.adapter.ProductsAdapter
import com.tm78775.digitalturbinetest.main.MainViewModel

interface ProductsListContract {

    /**
     * View contract
     */
    interface View {
        fun showProgressBar(show: Boolean)
    }

    /**
     * Presenter contract
     */
    interface Presenter {
        fun onAttach(model: MainViewModel)
        fun onDetach()
        fun getAdapter(): ProductsAdapter
        fun onBottomReached()
        fun displayProductsList()
    }

}