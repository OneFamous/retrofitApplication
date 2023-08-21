package com.fatihates.retrofitapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _post = MutableLiveData<MyPost>()
    val post: LiveData<MyPost>
        get() = _post

    private val _isLoading = MutableLiveData<Boolean>()
    val isloading: LiveData<Boolean>
        get() = _isLoading


    init {
        fetchPost()
    }

    fun fetchPost() {
        viewModelScope.launch {
            _isLoading.value = true
            delay(2000)
            val post: MyPost = RetrofitInstance.api.fetchPost()
            _post.value = post
            _isLoading.value = false

        }
    }

}