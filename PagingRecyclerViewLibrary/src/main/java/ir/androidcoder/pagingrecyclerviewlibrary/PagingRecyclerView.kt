package ir.androidcoder.pagingrecyclerviewlibrary

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import koleton.api.hideSkeleton
import koleton.api.loadSkeleton

class PagingRecyclerView @JvmOverloads constructor(context : Context, attrs : AttributeSet? = null) : ConstraintLayout(context, attrs) {

    private val recyclerView: RecyclerView = RecyclerView(context).apply {
        layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )
    }

    var skeletonEnable: Boolean = true
        set(value) {
            field = value
            addLoadStateListener()
        }
        get() = field


    init {
        addView(recyclerView)
        initAttributes(attrs)
    }


    @SuppressLint("Recycle", "CustomViewStyleable")
    private fun initAttributes(attrs: AttributeSet?){

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.PagingRecyclerView,
            0,
            0
        ).apply {

            attrs?.let {

                val typedArray = context.obtainStyledAttributes(it , R.styleable.PagingRecyclerView , 0 , 0)

                skeletonEnable = typedArray.getBoolean(R.styleable.PagingRecyclerView_prv_activatedSkeleton, true)

                typedArray.recycle()
            }

        }

    }

    //adapter
    fun setAdapter(adapter: PagingDataAdapter<*, *>): PagingRecyclerView {
        recyclerView.adapter = adapter
        addLoadStateListener()
        return this
    }


    //load state
    private fun addLoadStateListener(){

        if (!skeletonEnable) return

        (recyclerView.adapter as? PagingDataAdapter<* , *>)?.addLoadStateListener { loadState: CombinedLoadStates ->
            when (loadState.source.refresh) {
                is LoadState.Loading -> recyclerView.loadSkeleton()

                is LoadState.Error -> Log.e("Load state error" , " -> error")

                is LoadState.NotLoading -> recyclerView.hideSkeleton()
            }
        }
    }

    //layout manager
    fun setLayoutManager(layoutManager : LayoutManager) : PagingRecyclerView {
        recyclerView.layoutManager = layoutManager
        return this
    }

    //recycler
    fun getRecyclerView() : RecyclerView = recyclerView

}