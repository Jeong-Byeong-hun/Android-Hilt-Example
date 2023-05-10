package com.example.hiltexample.api

import com.google.gson.annotations.SerializedName

data class SearchVo(
    @SerializedName("id")
    var id: String,

    @SerializedName("media_formats")
    var media_formats: MediaFormat)

