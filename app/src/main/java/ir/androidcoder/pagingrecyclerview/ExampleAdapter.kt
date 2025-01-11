package ir.androidcoder.pagingrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.androidcoder.traktmovies.view.adapter.basaAdapter.BaseDiffCallback
import ir.androidcoder.traktmovies.view.adapter.basaAdapter.BasePagingAdapter

class ExampleAdapter : BasePagingAdapter<TestModel , ExampleAdapter.ExampleViewHolder>(
    BaseDiffCallback(
        {oldItem, newItem -> oldItem.id == newItem.id},
        {oldItem, newItem -> oldItem == newItem}
    )
) {


    inner class ExampleViewHolder(view : View) : RecyclerView.ViewHolder(view){
        fun bind(item: TestModel?) {

            val txt = itemView.findViewById<TextView>(R.id.txt)

            txt.text = item?.name

        }

    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ExampleViewHolder(view)
    }

}