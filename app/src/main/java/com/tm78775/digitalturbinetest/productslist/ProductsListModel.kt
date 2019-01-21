package com.tm78775.digitalturbinetest.productslist

import com.tm78775.digitalturbinetest.datamodel.Product
import com.tm78775.digitalturbinetest.repository.ProductRepository

class ProductsListModel(private val presenter: ProductsListContract.Presenter): ProductsListContract.Model {

    private val productRepo = ProductRepository()

    override fun fetchPageOfProducts(callback: (ArrayList<Product>?, Exception?) -> Unit) {
        productRepo.getListOfProducts(callback)
    }

}