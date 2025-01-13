package ir.androidcoder.pagingrecyclerviewlibrary

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import ir.androidcoder.pagingrecyclerviewlibrary.databinding.AndroidcoderPagingRecyclerViewBinding
import koleton.api.hideSkeleton
import koleton.api.loadSkeleton

class PagingRecyclerViewLib @JvmOverloads constructor(context : Context, attrs : AttributeSet? = null) :
    ConstraintLayout(context, attrs) {

    private val binding = AndroidcoderPagingRecyclerViewBinding.inflate(LayoutInflater.from(context) , this , true)


    init {
        initView(attrs)
    }


    @SuppressLint("Recycle", "CustomViewStyleable")
    private fun initView(attrs: AttributeSet?) = with(binding){

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.PagingRecyclerView,
            0,
            0
        ).apply {

            attrs?.let {

                val typedArray = context.obtainStyledAttributes(it , R.styleable.PagingRecyclerView , 0 , 0)

                if (typedArray.getBoolean(R.styleable.PagingRecyclerView_prv_activatedSkeleton, true)) {
                    (prvRecyclerView.adapter as? PagingDataAdapter<* , *>)?.addLoadStateListener { loadState: CombinedLoadStates ->
                        when (loadState.source.refresh) {
                            is LoadState.Loading -> {
                                binding.prvRecyclerView.loadSkeleton()
                            }

                            is LoadState.Error -> {
                                binding.prvRecyclerView.hideSkeleton()
                            }

                            is LoadState.NotLoading -> {
                                binding.prvRecyclerView.hideSkeleton()
                            }
                        }
                    }
                } else {
                    prvRecyclerView.hideSkeleton()
                }


                typedArray.recycle()
            }

        }

    }

    //adapter
    fun setAdapter(adapter: PagingDataAdapter<*, *> , isActivatedSkeleton : Boolean = true): PagingRecyclerViewLib {
        binding.prvRecyclerView.adapter = adapter
        addLoadStateListener(isActivatedSkeleton)
        return this
    }


    //load state
    private fun addLoadStateListener(isActivatedSkeleton: Boolean){

        if (!isActivatedSkeleton){
            return
        }

        (binding.prvRecyclerView.adapter as? PagingDataAdapter<* , *>)?.addLoadStateListener { loadState: CombinedLoadStates ->
            when (loadState.source.refresh) {
                is LoadState.Loading -> {
                    binding.prvRecyclerView.loadSkeleton()
                }

                is LoadState.Error -> {
                    binding.prvRecyclerView.hideSkeleton()
                }

                is LoadState.NotLoading -> {
                    binding.prvRecyclerView.hideSkeleton()
                }
            }
        }

    }

    //layout manager
    fun setVerticalLinearLayoutManager(reversLayout : Boolean = false) : PagingRecyclerViewLib {
        binding.prvRecyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , reversLayout)
        return this
    }

    fun setHorizontalLinearLayoutManager(reversLayout : Boolean = false) : PagingRecyclerViewLib {
        binding.prvRecyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.HORIZONTAL , reversLayout)
        return this
    }

    fun setVerticalGridLinearLayoutManager(spaceCount : Int , reversLayout : Boolean = false) : PagingRecyclerViewLib {
        binding.prvRecyclerView.layoutManager = GridLayoutManager(context , spaceCount , GridLayoutManager.VERTICAL , reversLayout)
        return this
    }

    fun setHorizontalGridLinearLayoutManager(spaceCount : Int , reversLayout : Boolean = false) : PagingRecyclerViewLib {
        binding.prvRecyclerView.layoutManager = GridLayoutManager(context , spaceCount , GridLayoutManager.HORIZONTAL , reversLayout)
        return this
    }

    fun setVerticalStaggeredGridLayoutManager(spaceCount : Int) : PagingRecyclerViewLib{
        binding.prvRecyclerView.layoutManager = StaggeredGridLayoutManager(spaceCount , RecyclerView.VERTICAL)
        return this
    }

    fun setHorizontalStaggeredGridLayoutManager(spaceCount : Int) : PagingRecyclerViewLib{
        binding.prvRecyclerView.layoutManager = StaggeredGridLayoutManager(spaceCount , RecyclerView.HORIZONTAL)
        return this
    }


    //item size
    fun setItemSize(width : Int , height : Int) : PagingRecyclerViewLib {
        binding.apply {
            prvRecyclerView.layoutParams.width = width
            prvRecyclerView.layoutParams.height = height
        }
        return this
    }

    fun setHasFixedSize(hasFixedSize : Boolean = true) : PagingRecyclerViewLib {
        binding.prvRecyclerView.setHasFixedSize(hasFixedSize)
        return this
    }

    fun setItemViewCacheSize(size : Int) : PagingRecyclerViewLib{
        binding.prvRecyclerView.setItemViewCacheSize(size)
        return this
    }

    //scroll
    fun smoothScrollToPosition(position : Int) : PagingRecyclerViewLib{
        binding.prvRecyclerView.scrollToPosition(position)
        return this
    }

    //padding
    fun recyclerPadding(clipToPadding : Boolean = false , top : Int = 0 , bottom : Int = 0 , left : Int = 0 , right : Int = 0) : PagingRecyclerViewLib{
        binding.apply {
            prvRecyclerView.clipToPadding = clipToPadding
            prvRecyclerView.setPadding(left , top , right , bottom)
        }
        return this
    }

    //visibility
    fun setItemVisibility(visibility : Int) : PagingRecyclerViewLib {
        binding.prvMain.visibility = visibility
        return this
    }


    //scroll
    fun getScrollState(scrollState :(Int) -> Unit) : PagingRecyclerViewLib{
        scrollState(binding.prvRecyclerView.scrollState)
        return this
    }

    fun setScrollPosition(position : Int) : PagingRecyclerViewLib{
        binding.prvRecyclerView.scrollToPosition(position)
        return this
    }




}