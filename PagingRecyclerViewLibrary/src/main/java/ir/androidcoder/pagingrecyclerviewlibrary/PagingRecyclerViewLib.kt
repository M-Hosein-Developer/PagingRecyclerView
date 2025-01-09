package ir.androidcoder.pagingrecyclerviewlibrary

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.androidcoder.pagingrecyclerviewlibrary.databinding.AndroidcoderPagingRecyclerViewBinding

class PagingRecyclerViewLib @JvmOverloads constructor(context : Context, attrs : AttributeSet? = null) :
    ConstraintLayout(context , attrs , 0) {

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


    //item size
    fun setMaxItemSize(width : Int , height : Int) : PagingRecyclerViewLib {
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


    //visibility
    fun setItemVisibility(visibility : Int) : PagingRecyclerViewLib {
        binding.prvMain.visibility = visibility
        return this
    }



}