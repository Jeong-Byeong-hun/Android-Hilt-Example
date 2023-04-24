package com.example.hiltexample.api

import com.example.hiltexample.api.service.PictureService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClientComObj {
    init {
        val baseUrl = "https://tenor.googleapis.com/"

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(PictureService::class.java)
    }

    companion object {
        private var instance: ApiClientComObj? = null

        fun getInstance(): ApiClientComObj {
            return instance ?: synchronized(this) {
                instance ?: ApiClientComObj().also {
                    instance = it
                }
            }
        }
    }
}