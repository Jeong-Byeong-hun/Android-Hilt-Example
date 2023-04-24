package com.example.hiltexample.api

import com.example.hiltexample.api.service.PictureService
import javax.inject.Inject

class MyRepository @Inject constructor(private val pictureService: PictureService) {
    suspend fun getGifList(query: String, key: String, client_key: String, limit: Int) =
        pictureService.getGifList(query, key, client_key, limit)
}