package com.example.publicapi.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private const val URL ="https://api.publicapis.org/"


    private val builder =Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = builder.create(ApiService::class.java)

    val requestCall  =service.getPublicList()




}