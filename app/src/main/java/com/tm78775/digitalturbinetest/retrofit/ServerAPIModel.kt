package com.tm78775.digitalturbinetest.retrofit

import android.util.Log
import com.tm78775.digitalturbinetest.datamodel.Product
import com.tm78775.digitalturbinetest.datamodel.ProductList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.lang.Exception

class ServerAPIModel: Callback<ResponseBody> {
    // TODO: TUTORIAL: https://futurestud.io/tutorials/retrofit-how-to-integrate-xml-converter
    // region Variables

    private val tag = "ServerAPIModel"
    private val baseUrl = "http://ads.appia.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .build()

    private val serverAPI = retrofit.create(ServerAPI::class.java)

    // endregion

    // region API

//    fun getSimulatedProductsList(): List<Product> {
//        val products = ArrayList<Product>()
//
//        products.add(Product("Roomba i7", "5 stars", "https://images.homedepot-static.com/productImages/0eed70da-29cc-408b-966d-a18b3937c4b2/svn/blacks-irobot-robotic-vacuums-i755020-64_1000.jpg"))
//        products.add(Product("Roomba 960", "4 stars", "https://images-na.ssl-images-amazon.com/images/I/51YR9jp-yjL._SX425_.jpg"))
//        products.add(Product("Broom & Dustpan", "1 stars", "https://images.homedepot-static.com/productImages/6cc41b27-afad-4f5d-87c7-6822da83c81e/svn/hdx-dust-pans-750441hdxrm-64_1000.jpg"))
//        products.add(Product("Roomba i7", "5 stars", "https://images.homedepot-static.com/productImages/0eed70da-29cc-408b-966d-a18b3937c4b2/svn/blacks-irobot-robotic-vacuums-i755020-64_1000.jpg"))
//        products.add(Product("Roomba 960", "4 stars", "https://images-na.ssl-images-amazon.com/images/I/51YR9jp-yjL._SX425_.jpg"))
//        products.add(Product("Broom & Dustpan", "1 stars", "https://images.homedepot-static.com/productImages/6cc41b27-afad-4f5d-87c7-6822da83c81e/svn/hdx-dust-pans-750441hdxrm-64_1000.jpg"))
//        products.add(Product("Roomba i7", "5 stars", "https://images.homedepot-static.com/productImages/0eed70da-29cc-408b-966d-a18b3937c4b2/svn/blacks-irobot-robotic-vacuums-i755020-64_1000.jpg"))
//        products.add(Product("Roomba 960", "4 stars", "https://images-na.ssl-images-amazon.com/images/I/51YR9jp-yjL._SX425_.jpg"))
//        products.add(Product("Broom & Dustpan", "1 stars", "https://images.homedepot-static.com/productImages/6cc41b27-afad-4f5d-87c7-6822da83c81e/svn/hdx-dust-pans-750441hdxrm-64_1000.jpg"))
//        products.add(Product("Roomba i7", "5 stars", "https://images.homedepot-static.com/productImages/0eed70da-29cc-408b-966d-a18b3937c4b2/svn/blacks-irobot-robotic-vacuums-i755020-64_1000.jpg"))
//        products.add(Product("Roomba 960", "4 stars", "https://images-na.ssl-images-amazon.com/images/I/51YR9jp-yjL._SX425_.jpg"))
//        products.add(Product("Broom & Dustpan", "1 stars", "https://images.homedepot-static.com/productImages/6cc41b27-afad-4f5d-87c7-6822da83c81e/svn/hdx-dust-pans-750441hdxrm-64_1000.jpg"))
//
//        return products
//    }

    suspend fun getProductList(): Response<Product>? {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response: Response<ProductList> = serverAPI.getProductsList("miller").execute()
                val products = response.body()?.products
                val s = ""
                // return call
            } catch (ex: Exception) {
                Log.e(tag, "An error occurred making GET request: ${ex.localizedMessage}")
                val t = ""
            }
            // return null
        }

        return null
    }

    // endregion

    // region Callback Implementation Methods

    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // endregion

}