package com.example.hiltexample.api

import com.google.gson.annotations.SerializedName

class BaseResult {
    @SerializedName("results")
    private lateinit var results: MutableList<SearchVo>

    override fun toString(): String {
        return "BaseResult(result=$results)"
    }

}