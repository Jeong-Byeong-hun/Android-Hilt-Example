package com.example.hiltexample

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltexample.api.MyRepository
import com.example.hiltexample.api.SearchVo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val myRepository: MyRepository) : ViewModel() {

    val API_KEY = "AIzaSyBMUxoWmHIF1EMZcPDS6JJlOeJCOegcDT4"
    val CLIENT_KEY = "Hilt Example"

    var liveData = MutableLiveData<List<SearchVo>>()
    fun getData() = liveData

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            val data = myRepository.getGifList("ralo", API_KEY, CLIENT_KEY, 4)

            when (data.isSuccessful) {
                true -> {
                    val gson = Gson()
                    val jsonObject = gson.toJsonTree(data.body()).asJsonObject

                    Log.d("TAG", "loadData: " + jsonObject.get("results").asJsonArray)
//                    val type = object : TypeToken<List<클래스>>() {}.type
//                    val className = Gson().fromJson<List<클래스>>(json... , type)

                    val type = object : TypeToken<List<SearchVo>>() {}.type
                    val className = gson.fromJson<List<SearchVo>>(jsonObject.get("results"), type)

                    liveData.postValue(className)

                    Log.d("TAG", "loadData array : " + className)

                }
                else -> {
                    Log.d("TAG", "loadData fail: " + data.toString())
                }
            }

        }
    }

}