package com.example.renata.apitest

import com.example.renata.apitest.model.Car
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    fun getCars(@Url url:String): Response<Car>
}