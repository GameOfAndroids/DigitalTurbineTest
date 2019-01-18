package com.tm78775.digitalturbinetest.repository

import androidx.lifecycle.MutableLiveData
import com.tm78775.digitalturbinetest.datamodel.Product
import com.tm78775.digitalturbinetest.model.ServerProductAPIModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ProductRepository {

    private val fetchJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + fetchJob)
    private val serverAPI = ServerProductAPIModel()

    fun getListOfProducts(callback: (ArrayList<Product>, Throwable?) -> Unit) {
        uiScope.launch {
            serverAPI.fetchProductsList(callback)
        }
    }

}