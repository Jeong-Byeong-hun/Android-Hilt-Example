package com.example.hiltexample.api.service

import com.example.hiltexample.api.BaseResult
import retrofit2.Call
import retrofit2.http.GET

interface PictureService {
    @GET("/v1/search")
    fun getGifList(): Call<BaseResult>


}