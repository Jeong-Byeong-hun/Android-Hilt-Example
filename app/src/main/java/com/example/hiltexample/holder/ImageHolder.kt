package com.example.hiltexample.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hiltexample.api.GifVo
import com.example.hiltexample.api.SearchVo
import com.example.hiltexample.databinding.ActivityMainBinding
import com.example.hiltexample.databinding.HolderImageBinding

class ImageHolder(binding: HolderImageBinding) : RecyclerView.ViewHolder(binding.root) {
    private val binding = binding

    public fun bind(vo: SearchVo) {
        Glide.with(binding.root).asGif().load(vo.media_formats.tinygif.url).into(binding.image)
    }
}