package com.tm78775.digitalturbinetest.viewmodel

import androidx.lifecycle.ViewModel
import com.tm78775.digitalturbinetest.datamodel.Product
import com.tm78775.digitalturbinetest.retrofit.ServerAPIModel
import kotlinx.coroutines.*

class MainActivityViewModel: ViewModel() {

    // region Interface Contract

    /**
     * Any activity utilizing this ViewModel should implement the MainViewModelActivity interface.
     * This will allow fragment communication and view model usage within the parent activity.
     */
    interface MainViewModelActivity {
        fun getViewModel(): MainActivityViewModel
    }

    // endregion

    // region Variables

    private val fetchJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + fetchJob)
    private val serverAPIModel = ServerAPIModel()

    // endregion

    // region API

    fun fetchProductsList(page: Int, callback: (List<Product>?, Exception?) -> Unit) {
        uiScope.launch {
            serverAPIModel.fetchProductsList(page, callback)
        }
    }

    // endregion

}