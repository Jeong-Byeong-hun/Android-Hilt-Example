package com.example.hiltexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hiltexample.adapter.ImageAdapter
import com.example.hiltexample.api.SearchVo
import com.skydoves.landscapist.glide.GlideImage
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivityCompose : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var imageAdapter: ImageAdapter
    private var searchList: MutableList<SearchVo> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.API_KEY = BuildConfig.API_KEY
        viewModel.getData().observe(this) { data ->
            data?.let { it ->
//                imageAdapter.addImage(it as MutableList<SearchVo>)
                searchList.addAll(it)
            }
        }
//        viewModel.loadData("bocchi")
        setContent {
//            ItemImage(imageUrl = "", modifier = Modifier.fillMaxSize())
//            LazyStaggeredGrid(searchList)
//            ItemImage(imageUrl = "https://media.tenor.com/j9qiT_IGBpYAAAAM/bocchi-the-rock-bocchi.gif")
            ImageView()
        }

        setAdapter()

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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyStaggeredGrid(searchList: MutableList<SearchVo>) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(searchList.size) { item ->
            ItemImage(imageUrl = searchList[item].media_formats.tinygif.url)
        }
    }

}

@Composable
fun RandomBoxImageItem() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .clip(RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center,
    ) {

    }
}


@Composable
fun ItemImage(imageUrl: String) {
    GlideImage(imageModel = { imageUrl }
    , Modifier.padding(6.dp))
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageView(viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val temp = viewModel.getData().observeAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.loadData("bocchi")
    }

    Log.d("TAG", "ImageView: " + temp)
    if (temp.value != null) {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(temp.value!!) { it ->
                ItemImage(imageUrl = it.media_formats.gifVo.url)
            }
        }
    }

}




