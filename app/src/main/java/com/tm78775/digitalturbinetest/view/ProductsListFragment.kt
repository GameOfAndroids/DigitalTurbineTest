package com.tm78775.digitalturbinetest.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.tm78775.digitalturbinetest.R
import com.tm78775.digitalturbinetest.view.recyclerview.adapter.ProductsAdapter
import com.tm78775.digitalturbinetest.datamodel.Product
import com.tm78775.digitalturbinetest.productslist.ProductsListContract
import com.tm78775.digitalturbinetest.productslist.ProductsListPresenter
import com.tm78775.digitalturbinetest.viewmodel.ProductsViewModel
import com.tm78775.digitalturbinetest.view.recyclerview.SuperRecyclerView
import kotlinx.android.synthetic.main.fragment_products_list.view.*

/**
 * This fragment will be responsible for displaying all products from which we can select.
 */
class ProductsListFragment : Fragment() {

    // region Variables

    private lateinit var rv: SuperRecyclerView
    private lateinit var viewModel: ProductsViewModel
    private lateinit var adapter: ProductsAdapter
    private var progressBarInterface: ProgressBarInterface? = null

    // endregion

    // region Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProductsViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_products_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv = view.productsRecyclerView
        rv.layoutManager = GridLayoutManager(view.context, 2)
        adapter = ProductsAdapter { clickedProduct ->
            onProductClicked(clickedProduct)
        }
        rv.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        adapter.dataSource.setDataSource(listOf())
        adapter.notifyDataSetChanged()
        progressBarInterface = activity as? ProgressBarInterface
        progressBarInterface?.showProgressBar(true)
        viewModel.observableProductsList.observe(this, object : Observer<ArrayList<Product>> {
            override fun onChanged(products: ArrayList<Product>) { onDataFetchSuccess(products) }
        })
        viewModel.observableError.observe(this, object : Observer<Throwable> {
            override fun onChanged(t: Throwable?) { onDataFetchException(t!!) }
        })
        viewModel.getListOfProducts()
    }

    // endregion

    // region Helper Methods

    /**
     * Helper method to simplify calling and showing a simple toast message.
     */
    private fun showToastMessage(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

    private fun onDataFetchSuccess(products: ArrayList<Product>) {
        progressBarInterface?.showProgressBar(false)
        adapter.appendToDataSource(products)
        rv.adapter?.notifyDataSetChanged()
        rv.scheduleLayoutAnimation()
    }

    private fun onDataFetchException(t: Throwable) {
//        handle thrown exception.
//        when(t) {
//
//        }
        progressBarInterface?.showProgressBar(false)
        showToastMessage(getString(R.string.fetch_error))
    }

    private fun onProductClicked(product: Product) {
        val args = Bundle()
        args.putSerializable(getString(R.string.product_arg), product)
        findNavController(this).navigate(R.id.productDetailFragment, args)
    }

    // endregion
}
