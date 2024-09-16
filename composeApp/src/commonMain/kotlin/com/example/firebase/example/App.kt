package com.example.firebase.example

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.storage.storage


@Composable
fun App() {
    var urls by remember { mutableStateOf(emptyList<String>()) }
    LaunchedEffect(Unit){
        urls=Firebase.storage.reference.listAll().items.map { it.getDownloadUrl() }
    }
    MaterialTheme {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(180.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize().padding(horizontal = 4.dp),) {
            items(urls){
                AsyncImage(it,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}