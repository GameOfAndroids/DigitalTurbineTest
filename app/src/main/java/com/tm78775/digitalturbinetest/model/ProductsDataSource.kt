package com.tm78775.digitalturbinetest.model

import com.tm78775.digitalturbinetest.datamodel.Product

final class ProductsDataSource: DataSource<Product>() {

    override fun contains(item: Product): Boolean {
        return dataSource.any{ p -> p.productId == item.productId }
    }

}