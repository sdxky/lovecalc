package com.example.lovecalc

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApiService {

    @GET("getPercentage")
    fun getPercentage(
        @Header("X-Rapidapi-Key") key: String = "bba0e0acaemsh38f1a7b99023527p1a7a8fjsn26046b35aa96",
        @Header("X-Rapidapi-Host") host: String = "love-calculator.p.rapidapi.com",
        @Query("fname") firstName: String,
        @Query("sname") secondName: String
    ) : Call<LoveModel>
}
