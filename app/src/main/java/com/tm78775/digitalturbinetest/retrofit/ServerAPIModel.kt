package com.tm78775.digitalturbinetest.retrofit

import android.util.Log
import com.google.gson.GsonBuilder
import com.tm78775.digitalturbinetest.datamodel.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServerAPIModel: Callback<String> {

    // region Variables

    private val tag = "ServerAPIModel"
    private val baseUrl = "http://ads.appia.com/"
    private val gson = GsonBuilder()
        .setLenient()
        .create()

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    private val serverAPI = retrofit.create(ServerAPI::class.java)

    // endregion

    // region API

    fun getSimulatedProductsList(): List<Product> {
        val products = ArrayList<Product>()

        products.add(Product("Roomba i7", "5 stars", "https://images.homedepot-static.com/productImages/0eed70da-29cc-408b-966d-a18b3937c4b2/svn/blacks-irobot-robotic-vacuums-i755020-64_1000.jpg"))
        products.add(Product("Roomba 960", "4 stars", "https://images-na.ssl-images-amazon.com/images/I/51YR9jp-yjL._SX425_.jpg"))
        products.add(Product("Broom & Dustpan", "1 stars", "https://images.homedepot-static.com/productImages/6cc41b27-afad-4f5d-87c7-6822da83c81e/svn/hdx-dust-pans-750441hdxrm-64_1000.jpg"))
        products.add(Product("Roomba i7", "5 stars", "https://images.homedepot-static.com/productImages/0eed70da-29cc-408b-966d-a18b3937c4b2/svn/blacks-irobot-robotic-vacuums-i755020-64_1000.jpg"))
        products.add(Product("Roomba 960", "4 stars", "https://images-na.ssl-images-amazon.com/images/I/51YR9jp-yjL._SX425_.jpg"))
        products.add(Product("Broom & Dustpan", "1 stars", "https://images.homedepot-static.com/productImages/6cc41b27-afad-4f5d-87c7-6822da83c81e/svn/hdx-dust-pans-750441hdxrm-64_1000.jpg"))
        products.add(Product("Roomba i7", "5 stars", "https://images.homedepot-static.com/productImages/0eed70da-29cc-408b-966d-a18b3937c4b2/svn/blacks-irobot-robotic-vacuums-i755020-64_1000.jpg"))
        products.add(Product("Roomba 960", "4 stars", "https://images-na.ssl-images-amazon.com/images/I/51YR9jp-yjL._SX425_.jpg"))
        products.add(Product("Broom & Dustpan", "1 stars", "https://images.homedepot-static.com/productImages/6cc41b27-afad-4f5d-87c7-6822da83c81e/svn/hdx-dust-pans-750441hdxrm-64_1000.jpg"))
        products.add(Product("Roomba i7", "5 stars", "https://images.homedepot-static.com/productImages/0eed70da-29cc-408b-966d-a18b3937c4b2/svn/blacks-irobot-robotic-vacuums-i755020-64_1000.jpg"))
        products.add(Product("Roomba 960", "4 stars", "https://images-na.ssl-images-amazon.com/images/I/51YR9jp-yjL._SX425_.jpg"))
        products.add(Product("Broom & Dustpan", "1 stars", "https://images.homedepot-static.com/productImages/6cc41b27-afad-4f5d-87c7-6822da83c81e/svn/hdx-dust-pans-750441hdxrm-64_1000.jpg"))

        return products
    }

    fun getProductList() {
        val call = serverAPI.getProductsList("miller")
        call.enqueue(this)
    }

    // endregion

    // region Callback Implementation Methods

    override fun onResponse(call: Call<String>, response: Response<String>) {
        if(response.isSuccessful) {
            val list = response.body()
            var s = ""
        }
    }

    override fun onFailure(call: Call<String>, t: Throwable) {
        val body = call.request().body()
        Log.e(tag, "An error occurred performing GET request: ${t.localizedMessage}")
        t.printStackTrace()
    }

    // endregion

}