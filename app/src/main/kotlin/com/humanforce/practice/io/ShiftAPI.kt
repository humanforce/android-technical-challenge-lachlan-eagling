package com.humanforce.practice.io

import com.humanforce.practice.models.ShiftDetailResponse
import retrofit2.http.GET

object Services {
    val shiftApi: ShiftApi by lazy { NetworkModule.retrofit.create(ShiftApi::class.java) }
}

interface ShiftApi {
    @GET("shift/list")
    suspend fun getShiftList(): ShiftDetailResponse
}
