package net.bintelligence.ktor.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.bintelligence.ktor.data.remote.RestService
import net.bintelligence.ktor.model.PostResponseModel

class MainViewModel: ViewModel() {

    private val service = RestService.create()

    private val _data = MutableLiveData<MutableList<PostResponseModel>>().also {
        it.value = arrayListOf()
    }
    val data: LiveData<MutableList<PostResponseModel>>
    get() = _data



    private val _post = MutableLiveData<PostResponseModel>().also {
        it.value = PostResponseModel()
    }
    val post: LiveData<PostResponseModel>
        get() = _post

//    init {
//        getPosts()
//    }


    fun getPosts(){
        viewModelScope.launch {
            service.getPosts().also {
                _data.value = it
            }
        }
    }

    fun addPost(newPost: PostResponseModel){
        viewModelScope.launch {
            service.addPost(newPost).also {
                _post.value = it
            }
        }
    }
}