package com.tm78775.digitalturbinetest.productslist

import android.os.Bundle
import android.os.Handler
import android.os.Looper
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
import com.google.android.material.snackbar.Snackbar

import com.tm78775.digitalturbinetest.R
import com.tm78775.digitalturbinetest.view.recyclerview.adapter.ProductsAdapter
import com.tm78775.digitalturbinetest.datamodel.Product
import com.tm78775.digitalturbinetest.view.ProgressBarInterface
import com.tm78775.digitalturbinetest.view.recyclerview.SuperRecyclerView
import kotlinx.android.synthetic.main.fragment_products_list.view.*

/**
 * This fragment will be responsible for displaying all products from which we can select.
 */
class ProductsListFragment : Fragment(), ProductsListContract.View {

    // region Variables

    private val presenter: ProductsListContract.Presenter = ProductsListPresenter(this)
    private lateinit var rv: SuperRecyclerView
    private lateinit var adapter: ProductsAdapter
    private var progressBarInterface: ProgressBarInterface? = null

    // endregion

    // region Lifecycle

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_products_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv = view.productsRecyclerView
        rv.layoutManager = GridLayoutManager(view.context, 2)
        rv.layoutAnimation = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_from_bottom)
        adapter = ProductsAdapter { clickedProduct ->
            onProductClicked(clickedProduct)
        }
        rv.adapter = adapter
        progressBarInterface = activity as? ProgressBarInterface
        activity?.actionBar?.setDisplayHomeAsUpEnabled(false)
    }

    override fun onStart() {
        super.onStart()
        adapter.dataSource.setDataSource(listOf())
        adapter.notifyDataSetChanged()
        presenter.fetchPageOfProducts()
    }

    // endregion

    // region Helper Methods

    private fun getUIHandler(): Handler {
        return Handler(if(Looper.myLooper() == Looper.getMainLooper()) Looper.myLooper() else Looper.getMainLooper())
    }

    override fun onDataFetchedSuccessfully(products: ArrayList<Product>) {
        getUIHandler().post {
            adapter.appendToDataSource(products)
            adapter.notifyDataSetChanged()
            rv.scheduleLayoutAnimation()
        }
    }

    override fun onDataFetchException(ex: Exception) {
//        when(ex) {
//            // choose what to do based on the exception.
//        }
        getUIHandler().post {
            showSnackMessage(getString(R.string.fetch_error))
        }
    }

    override fun showProgressBar(show: Boolean) {
        getUIHandler().post {
            progressBarInterface?.showProgressBar(show)
        }
    }

    /**
     * Helper method to simplify showing a simple toast message.
     */
    private fun showSnackMessage(msg: String) {
        view ?: return
        Snackbar.make(view!!, msg, Snackbar.LENGTH_LONG).show()
    }

    private fun onProductClicked(product: Product) {
        val args = Bundle()
        args.putSerializable(getString(R.string.product_arg), product)
        findNavController(this).navigate(R.id.action_productsListFragment_to_productDetailFragment, args)
    }

    // endregion
}
