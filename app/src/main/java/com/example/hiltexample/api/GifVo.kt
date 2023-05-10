package com.example.hiltexample.api

import com.google.gson.annotations.SerializedName

data class GifVo(
    @SerializedName("url")
    var url: String,
    @SerializedName("duration")
    var duration: String)

//    gif": {
//    "url": "https://media.tenor.com/5cp_8Cz4wOQAAAAC/circlethe-circledrain.gif",
//    "duration": 0,
//    "preview": "",
//    "dims": [
//    445,
//    498
//    ],
//    "size": 5732052
