package com.marrapps.handz

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.format.Time
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.content_list.*
import kotlin.math.roundToInt

class ListActivity : AppCompatActivity() {

    var day: Int = 0
    var month: Int = 0

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setSupportActionBar(toolbar)
        setDates()

        viewManager = LinearLayoutManager(this)
        viewAdapter = AdapterRecyclerHands(getIdList(), this)

        recyclerView = recyclerViewHands.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    private fun getIdList(): List<Int> {

        val listSize = defineListSize()

        return when (listSize){
            4 -> listOf(first(), second(), third(), fourth())
            5 -> listOf(first(), second(), third(), fourth(), fifth())
            6 -> listOf(first(), second(), third(), fourth(), fifth(), sixth())
            else -> listOf(first(), second(), third(), fourth(), fifth())
        }
    }

    private fun setDates() {
        val today = Time(Time.getCurrentTimezone())
        today.setToNow()

        day = today.monthDay
        month = today.month + 1
    }

    private fun defineListSize(): Int {

        var a: Double = (month * day).toDouble()
        a -= 100 * ((a / 100).toInt())
        a *= 0.6

        return when (a.toInt()+1){
            1 -> 4
            2 -> 5
            3 -> 6
            else -> a.toInt()+1
        }
    }

    private fun first(): Int {

        var a: Double = ((month * month) + (day * day)).toDouble()
        a -= 100 * ((a / 100).toInt())
        a *= 0.8

        return a.toInt()+1
    }

    private fun second(): Int {

        var a: Double = ((month * month) - (day * day)).toDouble()
        a -= 100 * ((a / 100).toInt())
        a *= 0.8

        return a.toInt()+1
    }

    private fun third(): Int {

        var a: Double = (2 * (month * month) + (day * day)).toDouble()
        a -= 100 * ((a / 100).toInt())
        a *= 0.8

        return a.toInt()+1
    }

    private fun fourth(): Int {

        var a: Double = ((month * month) + 2 * (day * day)).toDouble()
        a -= 100 * ((a / 100).toInt())
        a *= 0.8

        return a.toInt()+1
    }

    private fun fifth(): Int {

        var a: Double = (2 * (month * month) - (day * day)).toDouble()
        a -= 100 * ((a / 100).toInt())
        a *= 0.8

        return a.toInt()+1
    }

    private fun sixth(): Int {

        var a: Double = ((month * month) - 2 * (day * day)).toDouble()
        a -= 100 * ((a / 100).toInt())
        a *= 0.8

        return a.toInt()+1
    }

}
