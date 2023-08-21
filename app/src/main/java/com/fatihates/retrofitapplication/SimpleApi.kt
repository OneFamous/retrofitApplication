package com.fatihates.retrofitapplication

import retrofit2.http.GET

interface SimpleApi {

    @GET("posts/1")
    suspend fun fetchPost(): MyPost
}


data class MyPost(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String,
)