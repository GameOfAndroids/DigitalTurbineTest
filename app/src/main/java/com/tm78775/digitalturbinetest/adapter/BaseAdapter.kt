package com.tm78775.digitalturbinetest.adapter

import androidx.recyclerview.widget.RecyclerView
import com.tm78775.digitalturbinetest.datasource.DataSource
import java.lang.IllegalStateException

abstract class BaseAdapter<T>: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var dataSource: DataSource<T> = DataSource()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }

    override fun getItemCount(): Int {
        return dataSource.getItemCount()
    }

    fun appendToDataSource(items: List<T>) {
        val startIndex = dataSource.getItemCount()
        dataSource.addPageOfItems(items)
        // notifyItemRangeInserted(startIndex, items.count())
    }

}