package net.bintelligence.ktor

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.domain.model.PostResponseModel
import net.bintelligence.ktor.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy {
        MainViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.post.observe(this) {
            Log.d("_RESULT_", "ID: ${it.id}")
            Log.d("_RESULT_", "UserId: ${it.userId}")
            Log.d("_RESULT_", "Title: ${it.title}")
            Log.d("_RESULT_", "Body: ${it.body}")
        }

        val newPost =
            PostResponseModel(
                userId = 1,
                title = "Post de Omar",
                body = "Este es un nuevo post"
            )
        viewModel.addPost(newPost)

    }
}
