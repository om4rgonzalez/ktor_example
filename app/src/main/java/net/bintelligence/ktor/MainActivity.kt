package net.bintelligence.ktor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import net.bintelligence.ktor.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy{
        MainViewModel()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.data.observe(this){
            it.forEach {
                Log.d("_RESULT_TI", "Title: ${it.title}")
                Log.d("_RESULT_BO", "Body: ${it.body}")
            }
        }

    }
}