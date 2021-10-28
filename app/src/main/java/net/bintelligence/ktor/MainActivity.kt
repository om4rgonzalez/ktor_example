package net.bintelligence.ktor

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.domain.model.PostModel
import net.bintelligence.ktor.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy {
        MainViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupObservers()

        val newPost =
            PostModel(
                userId = 1,
                title = "Post de Omar",
                body = "Este es un nuevo post"
            )
        viewModel.getPosts()
        viewModel.addPost(newPost)
    }

    private fun setupObservers() {
        viewModel.data.observe(this) { list ->
            list.forEach {
                Log.d("_RESULT_LIST", "Title: ${it.title}")
                Log.d("_RESULT_LIST", "Body: ${it.body}")
            }
        }

        viewModel.post.observe(this) {
            Log.d("_RESULT_DETAIL", "ID: ${it?.id}")
            Log.d("_RESULT_DETAIL", "UserId: ${it?.userId}")
            Log.d("_RESULT_DETAIL", "Title: ${it?.title}")
            Log.d("_RESULT_DETAIL", "Body: ${it?.body}")
        }
    }
}
