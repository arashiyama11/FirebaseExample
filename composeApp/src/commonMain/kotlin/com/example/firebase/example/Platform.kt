package com.example.firebase.example

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform