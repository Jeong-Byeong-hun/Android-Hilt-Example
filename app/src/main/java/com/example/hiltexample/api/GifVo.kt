package com.example.hiltexample.api

import com.google.gson.annotations.SerializedName

class GifVo {
    @SerializedName("url")
    private lateinit var url: String
    @SerializedName("duration")
    private var duration: Int = 0

    override fun toString(): String {
        return "GifVo(url='$url', duration=$duration)"
    }


//    gif": {
//    "url": "https://media.tenor.com/5cp_8Cz4wOQAAAAC/circlethe-circledrain.gif",
//    "duration": 0,
//    "preview": "",
//    "dims": [
//    445,
//    498
//    ],
//    "size": 5732052

}