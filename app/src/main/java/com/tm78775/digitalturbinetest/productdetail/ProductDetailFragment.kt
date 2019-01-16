package com.tm78775.digitalturbinetest.productdetail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.tm78775.digitalturbinetest.R
import com.tm78775.digitalturbinetest.datamodel.Product

/**
 * A simple [Fragment] subclass.
 *
 */
class ProductDetailFragment : Fragment() {

//    companion object {
//        const val PRODUCT_ARG = "product_arg"
//
//        fun newInstance(product: Product): ProductDetailFragment {
//            val args = Bundle()
//            args.putSerializable(PRODUCT_ARG, product)
//            val fragment = ProductDetailFragment()
//            fragment.arguments = args
//            return fragment
//        }
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }

}
