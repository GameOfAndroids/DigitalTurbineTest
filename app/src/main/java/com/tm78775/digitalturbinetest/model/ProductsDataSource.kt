package com.tm78775.digitalturbinetest.model

import com.tm78775.digitalturbinetest.datamodel.Product

class ProductsDataSource: DataSource<Product>() {

    /**
     * This method will determine if a product object is
     * in the data source.
     */
    override fun contains(item: Product): Boolean {
        return dataSource.any{ p -> p.productId == item.productId }
    }

}