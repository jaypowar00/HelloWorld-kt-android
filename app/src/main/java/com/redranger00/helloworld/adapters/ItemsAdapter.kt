package com.redranger00.helloworld.adapters

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.redranger00.helloworld.models.Hobby
import com.redranger00.helloworld.R
import com.redranger00.helloworld.showToast
import kotlinx.android.synthetic.main.list_item.view.*

class ItemsAdapter(
    val context: Context,
    private val hobbies: List<Hobby>,
    val clipboard: ClipboardManager
) : RecyclerView.Adapter<ItemsAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(hobby: Hobby?, pos: Int) {
            itemView.txvTitle.text = hobby!!.title
            this.currentHobby = hobby
            this.currentPosition = pos
        }

        var currentHobby: Hobby? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                currentHobby?.let {
                    context.showToast(currentHobby!!.title + " clicked !\n(Successfully Copied)")
                    val clip = ClipData.newPlainText("content",currentHobby!!.title)
                    clipboard.setPrimaryClip(clip)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }
}