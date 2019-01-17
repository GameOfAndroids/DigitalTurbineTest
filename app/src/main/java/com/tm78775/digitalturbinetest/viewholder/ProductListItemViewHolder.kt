package com.tm78775.digitalturbinetest.viewholder

import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.tm78775.digitalturbinetest.R
import com.tm78775.digitalturbinetest.adapter.OnClickedItemIndexListener
import com.tm78775.digitalturbinetest.datamodel.Product
import kotlinx.android.synthetic.main.item_product.view.*
import java.lang.Exception

class ProductListItemViewHolder(view: View, private val listener: OnClickedItemIndexListener): RecyclerView.ViewHolder(view) {

    val thumbImageView: ImageView = view.thumbImageView
    val nameTextView: TextView = view.nameTextView
    val ratingImageView: ImageView = view.findViewById(R.id.ratingStarsImageView)

    init {
        view.findViewById<CardView>(R.id.productItemCardView).preventCornerOverlap = false
        view.productItemCardView.setOnClickListener { _ ->
            listener.onItemClicked(adapterPosition)
        }
    }

    fun bind(product: Product) {
        nameTextView.text = product.productName
        Picasso.get().load(product.productThumbnail).into(thumbImageView)
        Picasso.get().load(product.averageRatingImageURL).into(ratingImageView, object : Callback {
            override fun onSuccess() {
                val s = ""
            }

            override fun onError(e: Exception?) {
                val er = e
            }
        })
    }

}