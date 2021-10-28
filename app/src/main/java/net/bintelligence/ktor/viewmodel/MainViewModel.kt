@file:Suppress("unused")

package net.bintelligence.ktor.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.datasource.remote.network.RestService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val service = RestService.create()

    private val _data =
        MutableLiveData<MutableList<com.example.domain.model.PostModel>>().also {
            it.value = arrayListOf()
        }
    val data: LiveData<MutableList<com.example.domain.model.PostModel>>
        get() = _data


    private val _post = MutableLiveData<com.example.domain.model.PostModel>().also {
        it.value = com.example.domain.model.PostModel()
    }
    val post: LiveData<com.example.domain.model.PostModel>
        get() = _post

    fun getPosts() {
        viewModelScope.launch {
            service.getPosts().also {
                _data.value = it
            }
        }
    }

    fun addPost(newPost: com.example.domain.model.PostModel) {
        viewModelScope.launch {
            service.addPost(newPost).also {
                _post.value = it
            }
        }
    }
}