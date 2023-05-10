package com.example.hiltexample.api

import com.google.gson.annotations.SerializedName

data class GifFormat(
    @SerializedName("gif")
    var gif: String,

    @SerializedName("mediumgif")
    var mediumgif : String,

    @SerializedName("tinygif")
    var tinygif : String
)
