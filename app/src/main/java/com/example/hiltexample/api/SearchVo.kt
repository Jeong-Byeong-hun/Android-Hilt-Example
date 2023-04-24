package com.example.hiltexample.api

import com.google.gson.annotations.SerializedName

class SearchVo {
    @SerializedName("id")
    private lateinit var id: String

    @SerializedName("media_formats")
    private lateinit var media_formats : MediaFormat

    override fun toString(): String {
        return "SearchVo(id='$id', media_formats=$media_formats)"
    }

}