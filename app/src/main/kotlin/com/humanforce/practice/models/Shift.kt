package com.humanforce.practice.models

import androidx.compose.runtime.Immutable

@Immutable
data class ShiftDetailResponse(
    val shifts: List<ShiftDetail> = emptyList(),
)

@Immutable
data class ShiftDetail(
    val id: String? = null,
    val company: String? = null,
    val location: String? = null,
    val department: String? = null,
    val role: String? = null,
    val shiftStartDateTime: String? = null,
    val shiftEndDateTime: String? = null,
)