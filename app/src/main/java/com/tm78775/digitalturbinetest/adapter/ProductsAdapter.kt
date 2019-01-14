package com.tm78775.digitalturbinetest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tm78775.digitalturbinetest.R
import com.tm78775.digitalturbinetest.datamodel.Product
import com.tm78775.digitalturbinetest.viewholder.ProductListItemViewHolder

class ProductsAdapter: BaseAdapter<Product>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = (holder as ProductListItemViewHolder)
        viewHolder.bind(dataSource.getItem(position))
    }

}