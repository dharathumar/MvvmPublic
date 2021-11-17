package com.example.publicapi.data.api

import com.example.publicapi.data.model.public
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("entries")
    fun getPublicList () : Call<public>
}

