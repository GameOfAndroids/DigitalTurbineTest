package com.tm78775.digitalturbinetest.viewmodel

import androidx.lifecycle.ViewModel
import com.tm78775.digitalturbinetest.datamodel.Product
import com.tm78775.digitalturbinetest.model.ServerAPIModel
import kotlinx.coroutines.*

class ProductsViewModel: ViewModel() {

    // region Variables

    private val fetchJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + fetchJob)
    private val serverAPIModel = ServerAPIModel()

    // endregion

    // region API

    fun fetchProductsList(page: Int, callback: (List<Product>?, Exception?) -> Unit) {
//        uiScope.launch {
//            serverAPIModel.fetchProductsList(page, callback)
//        }
    }

    // endregion

}