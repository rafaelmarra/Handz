package com.marrapps.handz.hands

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marrapps.handz.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_hands_item.view.*

class HandsRecyclerAdapter(private val urlList: List<String>) :
    RecyclerView.Adapter<HandsRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        val view: View =
            LayoutInflater.from(p0.context).inflate(R.layout.list_hands_item, p0, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(urlList[p1], p1 + 1)
    }

    override fun getItemCount() = urlList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(url: String, position: Int) {

            itemView.tvHandNumber.text = position.toString()

            Picasso.get()
                .load(url)
                .placeholder(R.drawable.loading)
                .error(R.drawable.unavailable)
                .into(itemView.ivHandImage)
        }
    }
}
