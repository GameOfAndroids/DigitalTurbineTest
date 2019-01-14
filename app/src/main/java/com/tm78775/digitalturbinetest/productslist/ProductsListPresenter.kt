package com.tm78775.digitalturbinetest.productslist

import com.tm78775.digitalturbinetest.adapter.ProductsAdapter
import com.tm78775.digitalturbinetest.main.MainViewModel
import java.lang.IllegalStateException

class ProductsListPresenter(private val view: ProductsListContract.View): ProductsListContract.Presenter {

    var model: MainViewModel? = null
    lateinit var recyclerViewAdapter: ProductsAdapter

    override fun onAttach(model: MainViewModel) {
        this.model = model
    }

    override fun onDetach() {
        model = null
    }

    override fun getAdapter(): ProductsAdapter {
        recyclerViewAdapter = ProductsAdapter()
        return recyclerViewAdapter
    }

    override fun onBottomReached() {
        // load more items.
    }

    override fun displayProductsList() {
        model ?: throw IllegalStateException("The model must be instantiated for the ProductsListPresenter to function properly.")
        view.showProgressBar(true)
        model!!.getProductsSimulated { it ->
            recyclerViewAdapter.appendToDataSource(it)
            view.scheduleRVAnimation()
            view.showProgressBar(false)
        }
    }

}