package org.pioneer.pioneerApp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_concert.view.*
import org.pioneer.pioneerApp.Concert.ConcertModel
import org.pioneer.pioneerApp.Concert.onConcertItemClickListener
import org.pioneer.pioneerApp.R

class ConcertAdapter: RecyclerView.Adapter<ConcertAdapter.ViewHolder>(){
    var items = ArrayList<ConcertModel>()

    lateinit var listener: onConcertItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_concert,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init{
            itemView.setOnClickListener{
                listener?.onItemClick(this,itemView,adapterPosition)
            }
        }

        fun setItem(item: ConcertModel){
            itemView.concertnameText.text=item.concertname
            itemView.concertdayText.text=item.concertday
            itemView.concertplaceText.text=item.concertPlace
        }
    }
}