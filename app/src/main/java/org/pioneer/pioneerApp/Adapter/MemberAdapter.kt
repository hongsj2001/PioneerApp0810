package org.pioneer.pioneerApp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_member.view.*
import org.pioneer.pioneerApp.MemberInformation.MemberModel
import org.pioneer.pioneerApp.R

class MemberAdapter: RecyclerView.Adapter<MemberAdapter.ViewHolder>() {
    var items = ArrayList<MemberModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_member,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setItem(item: MemberModel){
            itemView.nameText.text= item.name
            itemView.majorText.text= item.major
            itemView.positionText.text= item.position
            itemView.roleText.text= item.role
        }
    }
}