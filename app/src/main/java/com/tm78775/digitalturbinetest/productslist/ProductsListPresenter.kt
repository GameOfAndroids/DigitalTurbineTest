package com.tm78775.digitalturbinetest.productslist

import com.tm78775.digitalturbinetest.view.recyclerview.adapter.ProductsAdapter
import com.tm78775.digitalturbinetest.viewmodel.ProductsViewModel
import java.lang.IllegalStateException

class ProductsListPresenter(): ProductsListContract.Presenter {

    var model: ProductsViewModel? = null
    lateinit var recyclerViewAdapter: ProductsAdapter
    var pageToFetch = 0

    override fun onAttach(model: ProductsViewModel) {
        this.model = model
    }

    override fun onDetach() {
        model = null
    }

    override fun getAdapter(): ProductsAdapter {
        recyclerViewAdapter = ProductsAdapter() { product ->
            //view.onProductClicked(product)
        }

        return recyclerViewAdapter
    }

    override fun onBottomReached() {
        // load more items.
    }

    override fun fetchPageOfProducts() {
        model ?: throw IllegalStateException("The model must be instantiated for the ProductsListPresenter to function properly.")
        //view.showProgressBar(true)
        model!!.fetchProductsList(pageToFetch) { products, exception ->
            if(exception != null) {
                //view.showFetchError()
                return@fetchProductsList
            }

            pageToFetch++
            recyclerViewAdapter.appendToDataSource(products ?: listOf())
//            view.notifyDataSetChanged()
//            view.showProgressBar(false)
        }
    }

    override fun resetPageToFetch() {
        pageToFetch = 0
    }

}