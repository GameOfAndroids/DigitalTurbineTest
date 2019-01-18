package com.tm78775.digitalturbinetest.view


import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager

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
            // todo: handle the clicked product, navigate to next fragment.
        }
        rv.adapter = adapter
//        rv.setOnBottomListener { presenter.onBottomReached() }
//        rv.adapter = presenter.getAdapter()
    }

    // endregion

    // region Helper Methods

    /**
     * Helper method to get a Handler which can be used ensure view calls are running on the main thread.
     */
    private fun getUiHandler(): Handler {
        return Handler(if(Looper.myLooper() == Looper.getMainLooper()) Looper.myLooper() ?: Looper.getMainLooper() else Looper.getMainLooper())
    }

    /**
     * Helper method to simplify calling and showing a simple toast message.
     */
    private fun showToastMessage(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

    // endregion

    // region Contract Methods

//    override fun showProgressBar(show: Boolean) {
//        getUiHandler().post {
//            (activity as? ProgressBarInterface)?.showProgressBar(show)
//        }
//    }
//
//    override fun notifyDataSetChanged() {
//        getUiHandler().post {
//            rv.layoutAnimation = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_from_bottom)
//            rv.adapter?.notifyDataSetChanged()
//            rv.scheduleLayoutAnimation()
//        }
//    }
//
//    override fun showFetchError() {
//        getUiHandler().post {
//            showToastMessage(getString(R.string.fetch_error))
//        }
//    }
//
//    override fun onProductClicked(product: Product) {
//        getUiHandler().post {
//            val args = Bundle()
//            args.putSerializable(ProductDetailFragment.PRODUCT_ARG, product)
//            findNavController(this).navigate(R.id.productDetailFragment, args)
//        }
//    }

    // endregion
}
