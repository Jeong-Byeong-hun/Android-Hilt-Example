package com.example.hiltexample.api

import com.google.gson.annotations.SerializedName

class MediaFormat {
    @SerializedName("gif")
    private lateinit var gifVo: GifVo

    override fun toString(): String {
        return "MediaFormat(gifVo=$gifVo)"
    }

}