package com.tm78775.digitalturbinetest.productdetail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso

import com.tm78775.digitalturbinetest.R
import com.tm78775.digitalturbinetest.datamodel.Product
import com.tm78775.digitalturbinetest.view.ProgressBarInterface
import kotlinx.android.synthetic.main.fragment_product_detail.*
import java.lang.IllegalStateException

/**
 * A simple [Fragment] subclass.
 *
 */
class ProductDetailFragment : Fragment() {

    private var product: Product? = null
        set(value) {
            field = value
            field ?: return
            onProductReceived()
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arg = arguments?.get(getString(R.string.product_arg))
        if(arg is Product)
            product = arg
        else
            throw IllegalStateException("No Product argument was passed to the ProductDetailFragment.")

        (activity as? ProgressBarInterface)?.showProgressBar(false)
        activity?.actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun onProductReceived() {
        Picasso.get().load(product?.productThumbnail).into(productIconImageView)
        productNameTextView.text        = product?.productName
        productDescriptionTextView.text = product?.productDescription
        categoryTextEdit.text           = product?.categoryName
        callToActionButton.text         = product?.callToAction
        ratingCount.text                = product?.numberOfRatings
        ratingAvgTextEdit.text          = product?.rating
    }

}
