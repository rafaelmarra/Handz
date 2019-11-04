package com.marrapps.handz.mvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marrapps.handz.R
import kotlinx.android.synthetic.main.list_numbers_item.view.*

class NumbersListAdapter(private val numberList: List<Int>): RecyclerView.Adapter<NumbersListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_numbers_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = numberList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tvNumberItem.text = numberList[position].toString()
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}