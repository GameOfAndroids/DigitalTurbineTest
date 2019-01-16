package com.tm78775.digitalturbinetest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.tm78775.digitalturbinetest.R
import com.tm78775.digitalturbinetest.datamodel.Product
import com.tm78775.digitalturbinetest.viewholder.ProductListItemViewHolder
import kotlinx.android.synthetic.main.item_product.view.*

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

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        super.onViewRecycled(holder)
        (holder as? ProductListItemViewHolder)?.thumbImageView?.setImageBitmap(null)
    }

}