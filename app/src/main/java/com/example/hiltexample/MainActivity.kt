package com.example.hiltexample

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_IDLE
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.hiltexample.adapter.ImageAdapter
import com.example.hiltexample.api.SearchVo
import com.example.hiltexample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private var page = 1
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setLayoutManager()
        setAdapter()

        viewModel.API_KEY = resources.getString(R.string.API_KEY)

        viewModel.getData().observe(this) { data ->
            data?.let { it ->
                imageAdapter.addImage(it as MutableList<SearchVo>)
            }
        }


        binding.btn.setOnClickListener {
            imageAdapter.clearImage()
            if (binding.etSearch.text?.toString()?.trim()?.isNotEmpty() == true) {
                viewModel.next = ""
                viewModel.loadData(binding.etSearch.text?.toString()?.trim() as String)
                binding.rcImage.scrollToPosition(0)
            }
        }

        binding.rcImage.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            private var state: Int = 0
            private lateinit var lastItem: IntArray
            private var totalItemCount = 0
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                Log.d("TAG", "onScrollStateChanged: $newState")
                state = newState
                if (state == SCROLL_STATE_IDLE) {
                    if (lastItem.isNotEmpty()) {
                        if (lastItem[0] == totalItemCount - 1 || lastItem[1] == totalItemCount - 1) {
                            viewModel.loadData(binding.etSearch.text?.toString()?.trim() as String)
                        }

                    }
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val spanCount = (recyclerView.layoutManager as StaggeredGridLayoutManager).spanCount
//                lastItem = (recyclerView.layoutManager as StaggeredGridLayoutManager).findLastCompletelyVisibleItemPositions(IntArray(spanCount))
                totalItemCount = (recyclerView.layoutManager as StaggeredGridLayoutManager).itemCount
                 lastItem = (recyclerView.layoutManager as StaggeredGridLayoutManager).findLastVisibleItemPositions(IntArray(spanCount))


                Log.d("TAG", "onScrolled: size " + lastItem[0])
                Log.d("TAG", "onScrolled: size " + lastItem[1])
                Log.d("TAG", "onScrolled: all size " + totalItemCount)
                Log.d("TAG", "onScrolled: state $state")

            }
        })

    }


    private fun setLayoutManager() {
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL).apply {
        }
        binding.rcImage.layoutManager = staggeredGridLayoutManager
    }

    private fun setAdapter() {
        imageAdapter = ImageAdapter()
        binding.rcImage.adapter = imageAdapter
    }
}