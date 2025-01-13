package ir.androidcoder.pagingrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.androidcoder.pagingrecyclerview.R
import ir.androidcoder.pagingrecyclerviewlibrary.basaAdapter.BaseDiffCallback
import ir.androidcoder.pagingrecyclerviewlibrary.basaAdapter.BasePagingAdapter

class ExampleAdapter : BasePagingAdapter<TestModel, ExampleAdapter.ExampleViewHolder>(
    BaseDiffCallback(
        {oldItem, newItem -> oldItem.id == newItem.id},
        {oldItem, newItem -> oldItem == newItem}
    )
) {


    inner class ExampleViewHolder(view : View) : RecyclerView.ViewHolder(view){
        fun bind(item: TestModel?) {

            val txt = itemView.findViewById<TextView>(R.id.txt)
            val txtId = itemView.findViewById<TextView>(R.id.txt_id)
            val img = itemView.findViewById<ImageView>(R.id.img)

            txt.text = item?.name
            txtId.text = item?.id.toString()
            Glide.with(img.context)
                .load(item?.image)
                .into(img)

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