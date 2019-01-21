package com.tm78775.digitalturbinetest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tm78775.digitalturbinetest.datamodel.Product
import com.tm78775.digitalturbinetest.repository.ProductRepository
import kotlinx.coroutines.*

//class ProductsViewModel: ViewModel() {
//
//    // region Private Variables
//
//    private val fetchJob = Job()
//    private val uiScope = CoroutineScope(Dispatchers.Main + fetchJob)
//    private val productRepo = ProductRepository()
//
//    // endregion
//
//    // region Observables
//
//    val observableProductsList = MutableLiveData<ArrayList<Product>>()
//    val observableError = MutableLiveData<Throwable>()
//
//    fun getListOfProducts() {
//        productRepo.getListOfProducts() { products, throwable ->
//            if(throwable != null)
//                observableError.value = throwable
//            else {
//                observableProductsList.value?.addAll(products)
//                observableProductsList.postValue(observableProductsList.value)
//            }
//        }
//    }

    // lateinit var observableProductFetchException: LiveData<Exception>

    // endregion

    // region API

//    fun fetchProductsList() {
//        ob
//        serverAPIModel.observableProductFetchException.observe(this,)
//
//        uiScope.launch {
//            serverAPIModel.fetchProductsList()
//        }
//    }

    // endregion

// }