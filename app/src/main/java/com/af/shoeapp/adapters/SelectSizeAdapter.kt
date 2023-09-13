package com.af.shoeapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.af.shoeapp.R
import com.af.shoeapp.data.SelectSize

class SelectSizeAdapter(
    var sizes:List<SelectSize>
):RecyclerView.Adapter<SelectSizeAdapter.SelectSizeViewHolder>() {

    inner class SelectSizeViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectSizeViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.select_size,parent,false)
        return SelectSizeViewHolder(view)
    }

    override fun onBindViewHolder(holder: SelectSizeViewHolder, position: Int) {
        holder.itemView.apply {
            rootView.findViewById<Button>(R.id.btn).text=sizes[position].size.toString()


        }
    }

    override fun getItemCount(): Int {
        return sizes.size
    }
}