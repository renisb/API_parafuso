package com.example.renata.apitest

import com.example.renata.apitest.model.Car
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface APIService1 {
    @GET
    fun getCars(@Url url:String): Response<Car>
    @GET
    fun getCars2(@Url url:String): Response<List<Car>>

    @GET("{from}")
    fun getCars1(@Path(value = "from", encoded = true) from : String): Call<List<Car>>
}