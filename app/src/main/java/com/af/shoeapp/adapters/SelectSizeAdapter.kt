package com.af.shoeapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.af.shoeapp.R
import com.af.shoeapp.data.SelectSize
import com.af.shoeapp.databinding.SelectSizeBinding

class SelectSizeAdapter(
    var sizes:List<SelectSize>,
    private val sizeClicked :(String)->Unit
):RecyclerView.Adapter<SelectSizeAdapter.SelectSizeViewHolder>() {

    inner class SelectSizeViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectSizeViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.select_size,parent,false)
//        val binding=SelectSizeBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return SelectSizeViewHolder(view)
    }

    override fun onBindViewHolder(holder: SelectSizeViewHolder, position: Int) {
        holder.itemView.apply {
            val size = sizes[position].size.toString()
            rootView.findViewById<Button>(R.id.btn).text=size
            rootView.findViewById<Button>(R.id.btn).setOnClickListener{
                sizeClicked(size)
            }


        }
    }

    override fun getItemCount(): Int {
        return sizes.size
    }


}