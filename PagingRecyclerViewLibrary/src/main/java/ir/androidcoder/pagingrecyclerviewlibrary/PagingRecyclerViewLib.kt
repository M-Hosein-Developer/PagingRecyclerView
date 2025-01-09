package ir.androidcoder.pagingrecyclerviewlibrary

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import ir.androidcoder.pagingrecyclerviewlibrary.databinding.AndroidcoderPagingRecyclerViewBinding

class PagingRecyclerViewLib @JvmOverloads constructor(context : Context, attrs : AttributeSet? = null) : ConstraintLayout(context , attrs) {

    private val binding = AndroidcoderPagingRecyclerViewBinding.inflate(LayoutInflater.from(context) , this , true)


    init {
        initView(attrs)
    }


    @SuppressLint("Recycle")
    private fun initView(attrs: AttributeSet?) = with(binding){

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.PagingRecyclerView,
            0, 0
        ).apply {

            attrs?.let {

                val typeArray = context.obtainStyledAttributes(it , R.styleable.PagingRecyclerView , 0 , 0)



            }

        }

    }

}