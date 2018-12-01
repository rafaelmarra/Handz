package com.marrapps.handz

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.list_hands_item.view.*

class AdapterRecyclerHands (private val numberList: List<Int>, val context: Context): RecyclerView.Adapter<AdapterRecyclerHands.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.list_hands_item, p0, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        val id: Int = numberList[p1]
        p0.bind(id, context, p1)
    }

    override fun getItemCount() = numberList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(handsId: Int, context: Context, position: Int){

            val image = itemView.imageHands
            val textNumber = itemView.txtNumber
            image.setImageDrawable(getImageFromId(handsId, context))
            textNumber.text = (position+1).toString()
        }

    }

}

