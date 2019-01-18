package com.tm78775.digitalturbinetest.view.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tm78775.digitalturbinetest.R
import com.tm78775.digitalturbinetest.datamodel.Product
import com.tm78775.digitalturbinetest.view.recyclerview.viewholder.ProductListItemViewHolder

class ProductsAdapter(private val callback: (Product) -> Unit): BaseAdapter<Product>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductListItemViewHolder(view, this)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = (holder as ProductListItemViewHolder)
        viewHolder.bind(dataSource.getItem(position))
    }

    override fun onItemClicked(index: Int) {
        val product = dataSource.getItem(index)
        callback.invoke(product)
    }

}