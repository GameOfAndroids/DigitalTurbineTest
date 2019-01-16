package com.tm78775.digitalturbinetest.productdetail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.tm78775.digitalturbinetest.R
import com.tm78775.digitalturbinetest.datamodel.Product
import java.lang.IllegalStateException

/**
 * A simple [Fragment] subclass.
 *
 */
class ProductDetailFragment : Fragment() {

    private lateinit var product: Product

    companion object {
        const val PRODUCT_ARG = "product_arg"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val arg = arguments?.get(PRODUCT_ARG)
        if(arg is Product)
            product = arg
        else
            throw IllegalStateException("No Product argument was passed to the ProductDetailFragment.")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }

}
