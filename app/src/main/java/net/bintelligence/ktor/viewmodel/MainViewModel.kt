@file:Suppress("unused")

package net.bintelligence.ktor.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.bintelligence.ktor.data.remote.RestService

class MainViewModel : ViewModel() {

    private val service = RestService.create()

    private val _data =
        MutableLiveData<MutableList<com.example.domain.model.PostResponseModel>>().also {
            it.value = arrayListOf()
        }
    val data: LiveData<MutableList<com.example.domain.model.PostResponseModel>>
        get() = _data


    private val _post = MutableLiveData<com.example.domain.model.PostResponseModel>().also {
        it.value = com.example.domain.model.PostResponseModel()
    }
    val post: LiveData<com.example.domain.model.PostResponseModel>
        get() = _post

    fun getPosts() {
        viewModelScope.launch {
            service.getPosts().also {
                _data.value = it
            }
        }
    }

    fun addPost(newPost: com.example.domain.model.PostResponseModel) {
        viewModelScope.launch {
            service.addPost(newPost).also {
                _post.value = it
            }
        }
    }
}