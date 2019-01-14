package com.tm78775.digitalturbinetest.main

import android.os.Handler
import androidx.lifecycle.ViewModel
import com.tm78775.digitalturbinetest.datamodel.Product
import com.tm78775.digitalturbinetest.retrofit.ServerAPIModel

class MainViewModel: ViewModel() {

    interface ViewModelActivity {
        fun getViewModel(): MainViewModel
    }

    private val serverAPIModel = ServerAPIModel()
    private val products = ArrayList<Product>()

    fun getProducts(callback: (List<Product>) -> Unit) {
        // this should use the server API.
        callback(listOf())
    }

    fun getProductsSimulated(callback: (List<Product>) -> Unit) {
        val h = Handler()
        products.addAll(serverAPIModel.getSimulatedProductsList())
        h.postDelayed(Runnable { callback(products) }, 3000)
    }

}