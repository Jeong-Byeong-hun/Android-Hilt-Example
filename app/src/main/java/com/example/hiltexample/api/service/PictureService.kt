package com.example.hiltexample.api.service

import com.example.hiltexample.api.BaseResult
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.Objects

interface PictureService {

    /**
     * gif 리스트 가져오기
     */
    @GET("/v2/search")
    suspend fun getGifList(@Query("q") query: String, @Query("key") key:String, @Query("client_key") client_key :String, @Query("limit") limit : Int): Response<BaseResult>
}