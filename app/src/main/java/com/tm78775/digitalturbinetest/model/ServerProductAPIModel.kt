package com.tm78775.digitalturbinetest.model

import android.util.Log
import com.tm78775.digitalturbinetest.datamodel.Product
import com.tm78775.digitalturbinetest.datamodel.ProductList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.lang.Exception

interface ServerProductAPI {
    @GET("getAds?id=236&password=OVUJ1DJN&siteId=10777&deviceId=4230&sessionId=techtestsession&totalCampaignsRequested=10")
    fun getProductsList(@Query("lname") lname: String): Call<ProductList>
}

class ServerProductAPIModel {

    // region Variables

    private val tag = "ServerProductAPIModel"
    private val baseUrl = "http://ads.appia.com/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .build()

    private val serverAPI = retrofit.create(ServerProductAPI::class.java)
    private var loading = false

    // endregion

    // region API

    /**
     * This method will provide a way to fetch the products list from the API provided.
     * When the fetch has completed, it will either pass a populated list, unpopulated list, or null list
     * to the callback. If the fetch has encountered an exception, null will be passed as the list parameter a non-null exception
     * will be passed to the callback flagging an exception occurred event.
     * @param callback Callback accepting a nullable list parameter and a nullable exception parameter.
     */
    fun fetchProductsList(callback: (ArrayList<Product>?, Exception?) -> Unit) {
        if(!loading) {
            loading = true
            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val response = serverAPI.getProductsList("miller").execute()
                    val products = response.body()?.products
                    callback.invoke(products ?: arrayListOf(), null)
                } catch (ex: Exception) {
                    Log.e(tag, "An error occurred making GET request: ${ex.localizedMessage}")
                    callback(null, ex)
                }

                loading = false
            }
        }
        else
            callback(null, null)
    }

    // endregion

}