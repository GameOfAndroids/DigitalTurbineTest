package com.tm78775.digitalturbinetest.model

import com.tm78775.digitalturbinetest.datamodel.Product
import com.tm78775.digitalturbinetest.datamodel.ProductList
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ServerAPI {
    @GET("getAds?id=236&password=OVUJ1DJN&siteId=10777&deviceId=4230&sessionId=techtestsession&totalCampaignsRequested=10")
    fun getProductsList(@Query("lname") lname: String): Call<ProductList>
}