package com.marrapps.handz.model.numbers

import java.io.Serializable

data class NumbersResponse(
    val numbers: List<Int>
) : Serializable