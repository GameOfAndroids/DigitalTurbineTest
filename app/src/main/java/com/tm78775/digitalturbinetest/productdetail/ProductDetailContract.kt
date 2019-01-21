package com.tm78775.digitalturbinetest.productdetail

import com.tm78775.digitalturbinetest.datamodel.Product

interface ProductDetailContract {

    interface View {

    }

    interface Presenter {
        fun setProduct(product: Product)
    }

    interface Model {

    }

}