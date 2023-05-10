package com.example.hiltexample.api

import com.google.gson.annotations.SerializedName
import java.util.Objects

//class BaseResult {
//    @SerializedName("results")
//    private lateinit var results: MutableList<SearchVo>
//
//    override fun toString(): String {
//        return "BaseResult(result=$results)"
//    }
//
//}

data class BaseResult(
    @SerializedName("next")
    var next: String,
    @SerializedName("results")
    var results: MutableList<SearchVo>)