package com.example.hiltexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.hiltexample.adapter.ImageAdapter
import com.example.hiltexample.api.SearchVo
import com.skydoves.landscapist.glide.GlideImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivityCompose : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ItemImage(imageUrl = "", modifier = Modifier.fillMaxSize())
        }
        viewModel.API_KEY = BuildConfig.API_KEY

        setAdapter()

        viewModel.getData().observe(this) { data ->
            data?.let { it ->
                imageAdapter.addImage(it as MutableList<SearchVo>)
            }
        }

        viewModel.loadData("botchi")



    }

    private fun setAdapter() {
        imageAdapter = ImageAdapter()
    }
}

@Composable
fun Greeting() {
    Text(text = "안녕")
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewGreeting() {
    Greeting()
}

@Composable
fun LazyColum() {
    LazyColumn(
        modifier = Modifier,
        contentPadding = PaddingValues(vertical = 8.dp) // 8.dp between each item
    ) {
        item {
            // If you want a single item
        }
        items(items = listOf<Any>()) { item ->
            // display a single list item
            // it's like forEach {}
        }
    }

}

@Composable
fun CardImageItem(){

}

//@Composable
//fun ItemImage(imageUrl: String, modifier: Modifier) {
//    GlideImage(imageModel = { imageUrl },
//        requestBuilder = { Glide.with(LocalContext.current.applicationContext).asGif() },
//        requestListener = object : RequestListener<GifDrawable>, () -> RequestListener<Any> {
//            override fun onLoadFailed(
//                e: GlideException?,
//                model: Any?,
//                target: Target<GifDrawable>?,
//                isFirstResource: Boolean
//            ): Boolean {
//                Log.d("TAG", "onLoadFailed: ")
//                return false
//            }
//
//            override fun onResourceReady(
//                resource: GifDrawable?,
//                model: Any?,
//                target: Target<GifDrawable>?,
//                dataSource: DataSource?,
//                isFirstResource: Boolean
//            ): Boolean {
//                resource?.start()
//                Log.d("TAG", "onResourceReady: ")
//                return true
//            }
//
//            override fun invoke(): RequestListener<Any> {
//                TODO("Not yet implemented")
//            }
//        }, modifier = Modifier.fillMaxSize(),
//        loading = {
//            BoxWithConstraints(
//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center
//            ) {
//                CircularProgressIndicator()
//            }
//        },
//        failure = {
//            Text(text = "image loading failed.")
//        })
//}


