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

            textNumber.text = (position+1).toString()
            setImageFromId(handsId, image, context)
        }

        private fun setImageFromId(handsId: Int, image: ImageView, context: Context) {
            when (handsId) {
                1 -> image.setImageDrawable(context.getDrawable(R.drawable.hand1))
                2 -> image.setImageDrawable(context.getDrawable(R.drawable.hand2))
                3 -> image.setImageDrawable(context.getDrawable(R.drawable.hand3))
                4 -> image.setImageDrawable(context.getDrawable(R.drawable.hand4))
                5 -> image.setImageDrawable(context.getDrawable(R.drawable.hand5))
                6 -> image.setImageDrawable(context.getDrawable(R.drawable.hand6))
                7 -> image.setImageDrawable(context.getDrawable(R.drawable.hand7))
                8 -> image.setImageDrawable(context.getDrawable(R.drawable.hand8))
                9 -> image.setImageDrawable(context.getDrawable(R.drawable.hand9))
                10 -> image.setImageDrawable(context.getDrawable(R.drawable.hand10))
                11 -> image.setImageDrawable(context.getDrawable(R.drawable.hand11))
                12 -> image.setImageDrawable(context.getDrawable(R.drawable.hand12))
                13 -> image.setImageDrawable(context.getDrawable(R.drawable.hand13))
                14 -> image.setImageDrawable(context.getDrawable(R.drawable.hand14))
                15 -> image.setImageDrawable(context.getDrawable(R.drawable.hand15))
                16 -> image.setImageDrawable(context.getDrawable(R.drawable.hand16))
                17 -> image.setImageDrawable(context.getDrawable(R.drawable.hand17))
                18 -> image.setImageDrawable(context.getDrawable(R.drawable.hand18))
                19 -> image.setImageDrawable(context.getDrawable(R.drawable.hand19))
                20 -> image.setImageDrawable(context.getDrawable(R.drawable.hand20))
                21 -> image.setImageDrawable(context.getDrawable(R.drawable.hand21))
                22 -> image.setImageDrawable(context.getDrawable(R.drawable.hand22))
                23 -> image.setImageDrawable(context.getDrawable(R.drawable.hand23))
                24 -> image.setImageDrawable(context.getDrawable(R.drawable.hand24))
                25 -> image.setImageDrawable(context.getDrawable(R.drawable.hand25))
                26 -> image.setImageDrawable(context.getDrawable(R.drawable.hand26))
                27 -> image.setImageDrawable(context.getDrawable(R.drawable.hand27))
                28 -> image.setImageDrawable(context.getDrawable(R.drawable.hand28))
                29 -> image.setImageDrawable(context.getDrawable(R.drawable.hand29))
                30 -> image.setImageDrawable(context.getDrawable(R.drawable.hand30))
                31 -> image.setImageDrawable(context.getDrawable(R.drawable.hand31))
                32 -> image.setImageDrawable(context.getDrawable(R.drawable.hand32))
                33 -> image.setImageDrawable(context.getDrawable(R.drawable.hand33))
                34 -> image.setImageDrawable(context.getDrawable(R.drawable.hand34))
                35 -> image.setImageDrawable(context.getDrawable(R.drawable.hand35))
                36 -> image.setImageDrawable(context.getDrawable(R.drawable.hand36))
                37 -> image.setImageDrawable(context.getDrawable(R.drawable.hand37))
                38 -> image.setImageDrawable(context.getDrawable(R.drawable.hand38))
                39 -> image.setImageDrawable(context.getDrawable(R.drawable.hand39))
                40 -> image.setImageDrawable(context.getDrawable(R.drawable.hand40))
                41 -> image.setImageDrawable(context.getDrawable(R.drawable.hand41))
                42 -> image.setImageDrawable(context.getDrawable(R.drawable.hand42))
                43 -> image.setImageDrawable(context.getDrawable(R.drawable.hand43))
                44 -> image.setImageDrawable(context.getDrawable(R.drawable.hand44))
                45 -> image.setImageDrawable(context.getDrawable(R.drawable.hand45))
                46 -> image.setImageDrawable(context.getDrawable(R.drawable.hand46))
                47 -> image.setImageDrawable(context.getDrawable(R.drawable.hand47))
                48 -> image.setImageDrawable(context.getDrawable(R.drawable.hand48))
                49 -> image.setImageDrawable(context.getDrawable(R.drawable.hand49))
                50 -> image.setImageDrawable(context.getDrawable(R.drawable.hand50))
                51 -> image.setImageDrawable(context.getDrawable(R.drawable.hand51))
                52 -> image.setImageDrawable(context.getDrawable(R.drawable.hand52))
                53 -> image.setImageDrawable(context.getDrawable(R.drawable.hand53))
                54 -> image.setImageDrawable(context.getDrawable(R.drawable.hand54))
                55 -> image.setImageDrawable(context.getDrawable(R.drawable.hand55))
                56 -> image.setImageDrawable(context.getDrawable(R.drawable.hand56))
                57 -> image.setImageDrawable(context.getDrawable(R.drawable.hand57))
                58 -> image.setImageDrawable(context.getDrawable(R.drawable.hand58))
                59 -> image.setImageDrawable(context.getDrawable(R.drawable.hand59))
                60 -> image.setImageDrawable(context.getDrawable(R.drawable.hand60))
                61 -> image.setImageDrawable(context.getDrawable(R.drawable.hand61))
                62 -> image.setImageDrawable(context.getDrawable(R.drawable.hand62))
                63 -> image.setImageDrawable(context.getDrawable(R.drawable.hand63))
                64 -> image.setImageDrawable(context.getDrawable(R.drawable.hand64))
                65 -> image.setImageDrawable(context.getDrawable(R.drawable.hand65))
                66 -> image.setImageDrawable(context.getDrawable(R.drawable.hand66))
                67 -> image.setImageDrawable(context.getDrawable(R.drawable.hand67))
                68 -> image.setImageDrawable(context.getDrawable(R.drawable.hand68))
                69 -> image.setImageDrawable(context.getDrawable(R.drawable.hand69))
                70 -> image.setImageDrawable(context.getDrawable(R.drawable.hand70))
                71 -> image.setImageDrawable(context.getDrawable(R.drawable.hand71))
                72 -> image.setImageDrawable(context.getDrawable(R.drawable.hand72))
                73 -> image.setImageDrawable(context.getDrawable(R.drawable.hand73))
                74 -> image.setImageDrawable(context.getDrawable(R.drawable.hand74))
                75 -> image.setImageDrawable(context.getDrawable(R.drawable.hand75))
                76 -> image.setImageDrawable(context.getDrawable(R.drawable.hand76))
                77 -> image.setImageDrawable(context.getDrawable(R.drawable.hand77))
                78 -> image.setImageDrawable(context.getDrawable(R.drawable.hand78))
                79 -> image.setImageDrawable(context.getDrawable(R.drawable.hand79))
                80 -> image.setImageDrawable(context.getDrawable(R.drawable.hand80))
                else -> {
                    image.setImageDrawable(context.getDrawable(R.drawable.hand42))
                }
            }
        }

    }

}

