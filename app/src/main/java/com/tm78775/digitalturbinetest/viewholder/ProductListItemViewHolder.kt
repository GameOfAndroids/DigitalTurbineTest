package com.tm78775.digitalturbinetest.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.tm78775.digitalturbinetest.R
import com.tm78775.digitalturbinetest.adapter.OnClickedItemIndexListener
import com.tm78775.digitalturbinetest.datamodel.Product
import kotlinx.android.synthetic.main.item_product.view.*

class ProductListItemViewHolder(view: View, val listener: OnClickedItemIndexListener): RecyclerView.ViewHolder(view) {

    val thumbImageView = view.findViewById<ImageView>(R.id.thumbImageView)
    val nameTextView = view.findViewById<TextView>(R.id.nameTextView)
    val ratingTextView = view.findViewById<TextView>(R.id.ratingTextView)

    init {
        view.findViewById<CardView>(R.id.productItemCardView).preventCornerOverlap = false
        view.productItemCardView.setOnClickListener { _ ->
            listener.onItemClicked(adapterPosition)
        }
    }

    fun bind(product: Product) {
        nameTextView.text = product.productName
        ratingTextView.text = product.rating
    }

}