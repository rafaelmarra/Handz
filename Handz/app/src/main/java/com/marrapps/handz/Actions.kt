package com.marrapps.handz

import android.graphics.drawable.Drawable
import java.security.AccessController.getContext
import java.util.*

fun getImageFromId(handsId: Int): Drawable {

    return getContext().getResources()

}

val day = GregorianCalendar.DAY_OF_MONTH
val month = GregorianCalendar.MONTH
val handsNumberList = getNumberList()

fun getNumberList(): List<Int> {

    val numberList = listOf(first(), second(), third(), fourth(), fifth(), sixth())

    return numberList

}

fun first(): Int {

    var a: Double = ((month * month) + (day * day)).toDouble()
    a -= 100 * (a / 100)
    a *= 0.4

    return a.toInt()
}


fun second(): Int {

    var a: Double = ((month * month) - (day * day)).toDouble()
    a -= 100 * (a / 100)
    a *= 0.4

    return a.toInt()
}

fun third(): Int {

    var a: Double = (2 * (month * month) + (day * day)).toDouble()
    a -= 100 * (a / 100)
    a *= 0.4

    return a.toInt()
}

fun fourth(): Int {

    var a: Double = ((month * month) + 2 * (day * day)).toDouble()
    a -= 100 * (a / 100)
    a *= 0.4

    return a.toInt()
}

fun fifth(): Int {

    var a: Double = (2 * (month * month) - (day * day)).toDouble()
    a -= 100 * (a / 100)
    a *= 0.4

    return a.toInt()
}

fun sixth(): Int {

    var a: Double = ((month * month) - 2 * (day * day)).toDouble()
    a -= 100 * (a / 100)
    a *= 0.4

    return a.toInt()
}