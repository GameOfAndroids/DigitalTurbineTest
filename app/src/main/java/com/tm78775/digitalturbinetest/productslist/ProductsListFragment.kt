package com.tm78775.digitalturbinetest.productslist


import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.tm78775.digitalturbinetest.R
import com.tm78775.digitalturbinetest.main.MainActivity
import com.tm78775.digitalturbinetest.main.MainViewModel
import com.tm78775.digitalturbinetest.recyclerview.SuperRecyclerView
import com.tm78775.digitalturbinetest.viewinterface.ProgressBarInterface

/**
 * A simple [Fragment] subclass.
 *
 */
class ProductsListFragment : Fragment(), ProductsListContract.View {

    // region Variables

    private val presenter: ProductsListContract.Presenter = ProductsListPresenter(this)
    private lateinit var rv: SuperRecyclerView

    // endregion

    // region Lifecycle

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(activity is MainViewModel.ViewModelActivity)
            presenter.onAttach((activity as MainViewModel.ViewModelActivity).getViewModel())
        else
            throw IllegalStateException("Hosting activity must implement the MainViewModel.ViewModelActivity interface.")
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
        // rv.layoutAnimation = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_fall_down)
        rv.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
        rv.setOnBottomListener { presenter.onBottomReached() }
    }

    override fun onStart() {
        super.onStart()
        rv.adapter = presenter.getAdapter()
        rv.layoutAnimation = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_fall_down)
        rv.scheduleLayoutAnimation()
        presenter.displayProductsList()
    }

    // endregion

    // region Contract Methods

    override fun showProgressBar(show: Boolean) {
        (activity as? ProgressBarInterface)?.showProgressBar(show)
    }

    override fun scheduleRVAnimation() {
//        rv.adapter = presenter.getAdapter()
//        rv.layoutAnimation = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_fall_down)
//        rv.scheduleLayoutAnimation()
    }
    // endregion
}
