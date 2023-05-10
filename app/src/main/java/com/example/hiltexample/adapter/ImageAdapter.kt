package com.example.hiltexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltexample.api.GifVo
import com.example.hiltexample.api.SearchVo
import com.example.hiltexample.databinding.HolderImageBinding
import com.example.hiltexample.holder.ImageHolder

class ImageAdapter : RecyclerView.Adapter<ImageHolder>() {
    private var imageList: MutableList<SearchVo> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        return ImageHolder(HolderImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    fun addImage(imageList: MutableList<SearchVo>) {
        var prevSize = this.imageList.size
        this.imageList.addAll(imageList)
        notifyItemChanged(prevSize, imageList.size)
    }

    fun clearImage(){
        imageList.clear()
        notifyDataSetChanged()
    }
}