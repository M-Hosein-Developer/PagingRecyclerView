package ir.androidcoder.pagingrecycler

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import ir.androidcoder.pagingrecyclerview.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val viewModel = ViewModel()

        val adapter = ExampleAdapter(binding.testPaging)

        binding.testPaging
            .setAdapter(adapter)
            .setLayoutManager(LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false))
            .getRecyclerView()
        binding.testPaging1.setAdapter(adapter).setLayoutManager(LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false))

        viewModel.searchMovies().flow.onEach {
            adapter.submitData(it)
        }.launchIn(lifecycleScope)



    }
}