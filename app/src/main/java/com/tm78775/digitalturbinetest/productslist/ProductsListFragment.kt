package com.tm78775.digitalturbinetest.productslist


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
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager

import com.tm78775.digitalturbinetest.R
import com.tm78775.digitalturbinetest.datamodel.Product
import com.tm78775.digitalturbinetest.productdetail.ProductDetailFragment
import com.tm78775.digitalturbinetest.viewmodel.MainActivityViewModel
import com.tm78775.digitalturbinetest.recyclerview.SuperRecyclerView
import com.tm78775.digitalturbinetest.viewinterface.ProgressBarInterface

/**
 * This fragment will be responsible for displaying all products from which we can select.
 */
class ProductsListFragment : Fragment(), ProductsListContract.View {

    // region Variables

    private val presenter: ProductsListContract.Presenter = ProductsListPresenter(this)
    private lateinit var rv: SuperRecyclerView

    // endregion

    // region Lifecycle

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(activity is MainActivityViewModel.MainViewModelActivity)
            presenter.onAttach((activity as MainActivityViewModel.MainViewModelActivity).getViewModel())
        else
            throw IllegalStateException("Hosting activity must implement the MainActivityViewModel.MainViewModelActivity interface.")
    }

    override fun onDetach() {
        presenter.onDetach()
        super.onDetach()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_products_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv = view.findViewById<SuperRecyclerView>(R.id.productsRecyclerView)
        rv.layoutManager = GridLayoutManager(view.context, 2)
        rv.setOnBottomListener { presenter.onBottomReached() }
        rv.adapter = presenter.getAdapter()
    }

    override fun onStart() {
        super.onStart()
        presenter.displayProductsList()
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

    override fun showProgressBar(show: Boolean) {
        getUiHandler().post {
            (activity as? ProgressBarInterface)?.showProgressBar(show)
        }
    }

    override fun notifyDataSetChanged() {
        getUiHandler().post {
            rv.layoutAnimation = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_from_bottom)
            rv.adapter?.notifyDataSetChanged()
            rv.scheduleLayoutAnimation()
        }
    }

    override fun showFetchError() {
        getUiHandler().post {
            showToastMessage(getString(R.string.fetch_error))
        }
    }

    override fun onProductClicked(product: Product) {
        getUiHandler().post {
            // val fragment = ProductDetailFragment.newInstance(product)
//            val args = Bundle()
//            args.putSerializable(ProductDetailFragment.PRODUCT_ARG, product)
//            val action =
//            findNavController(this).navigate(R.id.productDetailFragment, args)
        }
    }

    // endregion
}
