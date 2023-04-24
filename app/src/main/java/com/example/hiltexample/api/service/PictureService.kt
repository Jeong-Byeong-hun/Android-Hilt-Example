package com.example.hiltexample.api.service

import com.example.hiltexample.api.BaseResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PictureService {

    /**
     * gif 리스트 가져오기
     */
    @GET("/v1/search/{key}")
    suspend fun getGifList(@Path("key") key: String): Call<BaseResult>
}