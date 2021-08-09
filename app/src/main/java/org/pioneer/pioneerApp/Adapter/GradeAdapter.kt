package org.pioneer.pioneerApp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_grade.view.*
import org.pioneer.pioneerApp.MemberInformation.GradeModel
import org.pioneer.pioneerApp.MemberInformation.onGradeItemClickListener
import org.pioneer.pioneerApp.R

class GradeAdapter: RecyclerView.Adapter<GradeAdapter.ViewHolder>() {
    var items = ArrayList<GradeModel>()

    lateinit var listener: onGradeItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_grade,parent,false)
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

        fun setItem(item: GradeModel){
            itemView.gradeText.text=item.grade
        }
    }
}