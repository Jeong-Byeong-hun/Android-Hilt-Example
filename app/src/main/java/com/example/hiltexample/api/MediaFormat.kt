package com.example.hiltexample.api

import com.google.gson.annotations.SerializedName

data class MediaFormat(
    @SerializedName("gif")
    var gifVo: GifVo,

    @SerializedName("mediumgif")
    var mediumgif: GifVo,

    @SerializedName("tinygif")
    var tinygif: GifVo)