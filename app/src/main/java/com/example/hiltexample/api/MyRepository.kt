package com.example.hiltexample.api

import com.example.hiltexample.api.service.PictureService
import javax.inject.Inject

class MyRepository @Inject constructor(private val pictureService: PictureService) {
    suspend fun getGifList(key : String) =
        pictureService.getGifList(key)
}