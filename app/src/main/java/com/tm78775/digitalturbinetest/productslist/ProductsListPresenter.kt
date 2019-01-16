package com.tm78775.digitalturbinetest.productslist

import com.tm78775.digitalturbinetest.adapter.ProductsAdapter
import com.tm78775.digitalturbinetest.viewmodel.MainActivityViewModel
import java.lang.IllegalStateException

class ProductsListPresenter(private val view: ProductsListContract.View): ProductsListContract.Presenter {

    var model: MainActivityViewModel? = null
    lateinit var recyclerViewAdapter: ProductsAdapter

    override fun onAttach(model: MainActivityViewModel) {
        this.model = model
    }

    override fun onDetach() {
        model = null
    }

    override fun getAdapter(): ProductsAdapter {
        recyclerViewAdapter = ProductsAdapter() { product ->
            view.onProductClicked(product)
        }

        return recyclerViewAdapter
    }

    override fun onBottomReached() {
        // load more items.
    }

    override fun displayProductsList() {
        model ?: throw IllegalStateException("The model must be instantiated for the ProductsListPresenter to function properly.")
        view.showProgressBar(true)
        model!!.fetchProductsList { products, exception ->
            if(exception != null) {
                view.showFetchError()
                return@fetchProductsList
            }

            recyclerViewAdapter.appendToDataSource(products ?: listOf())
            view.notifyDataSetChanged()
            view.showProgressBar(false)
        }
    }

}