package org.pioneer.pioneerApp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.pioneer.pioneerApp.R


class WritingListAdapter(val context: Context, val message: MutableList<org.pioneer.pioneerApp.NoticeList.WritingModel>)
    : RecyclerView.Adapter<WritingListAdapter.ViewHolder>() {

    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }

    //클릭리스너 선언
    private lateinit var itemClickListner: ItemClickListener

    //클릭리스너 등록 매소드
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListner = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)


        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Title?.text = message[position].title
        holder.content?.text = message[position].content
        holder.time?.text = message[position].time


        holder.itemView.setOnClickListener {
            itemClickListner.onClick(it,position)
        }

    }

    override fun getItemCount(): Int = message.size



    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var Title: TextView? = null
        var content: TextView? = null
        var time: TextView? = null
        init {
            Title = view.findViewById(R.id.itemText_Title)
            content = view.findViewById(R.id.itemText_content)
            time = view.findViewById(R.id.itemText_Time)
        }
    }

}