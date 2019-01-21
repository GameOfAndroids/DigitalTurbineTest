package com.tm78775.digitalturbinetest.productdetail

import com.tm78775.digitalturbinetest.datamodel.Product

class ProductDetailPresenter(private val view: ProductDetailContract.View): ProductDetailContract.Presenter {

    lateinit var detailProduct: Product

    override fun setProduct(product: Product) {
        detailProduct = product
    }

}