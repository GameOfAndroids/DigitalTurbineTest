package com.tm78775.digitalturbinetest.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tm78775.digitalturbinetest.datamodel.Product
import com.tm78775.digitalturbinetest.datamodel.ProductList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.lang.Exception

class ServerAPIModel {

    // region Variables

    private val tag = "ServerAPIModel"
    private val baseUrl = "http://ads.appia.com/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .build()

    private val serverAPI = retrofit.create(ServerAPI::class.java)

    // Live Data object - this will allow a subscriber to listen for changes to this data set.
    val fetchedProducts = MutableLiveData<ArrayList<Product>>()
    val exceptionLiveData = MutableLiveData<Exception>()

    // endregion

    // region API

    /**
     * This method will provide a way to fetch the products list from the API provided.
     * When the fetch has completed, it will either pass a populated list, unpopulated list, or null list
     * to the callback. If the fetch has encountered an exception, null will be passed as the list parameter a non-null exception
     * will be passed to the callback flagging an exception occurred event.
     * @param callback Callback accepting a nullable list parameter and a nullable exception parameter.
     */
    suspend fun fetchProductsList() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = serverAPI.getProductsList("miller").execute()
                val products = response.body()?.products
                fetchedProducts.value?.addAll(products ?: arrayListOf())
                fetchedProducts.postValue(fetchedProducts.value)
            } catch (ex: Exception) {
                Log.e(tag, "An error occurred making GET request: ${ex.localizedMessage}")
                if(exceptionLiveData.hasActiveObservers())
                    exceptionLiveData.postValue(ex)
                else {
                    Log.e(tag, "There was no registered observer for the exception. Since exception was not caught, throwing exception...")
                    throw ex
                }
            }
        }
    }

    // endregion

}