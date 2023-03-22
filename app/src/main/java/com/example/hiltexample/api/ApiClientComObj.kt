package com.example.hiltexample.api

import android.content.Context

class ApiClientComObj {
    companion object {
        private var instance: ApiClientComObj? = null

        private lateinit var context: Context

        fun getInstance(_context: Context): ApiClientComObj {
            return instance ?: synchronized(this) {
                instance ?: ApiClientComObj().also {
                    context = _context
                    instance = it
                }
            }
        }
    }
}