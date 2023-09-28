package com.af.shoeapp.ui.shoeList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.af.shoeapp.R
import com.af.shoeapp.data.Shoe


class ShoeAdapter(
    var shoes:List<Shoe>
):RecyclerView.Adapter<ShoeAdapter.ShoeViewHolder>()
{
    inner class ShoeViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_shoe,parent,false)
        return ShoeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        holder.itemView.apply {
            rootView.findViewById<TextView>(R.id.tvTitle).text=shoes[position].shoeName
            rootView.findViewById<TextView>(R.id.tvDetail).text=shoes[position].shoeDetail
            rootView.findViewById<TextView>(R.id.tvSize).text=shoes[position].shoeSize.toString()
            rootView.findViewById<ImageView>(R.id.ivShoe).setImageResource(shoes[position].shoePicUrl.toInt())
        }
    }

    override fun getItemCount(): Int {
        return shoes.size
    }
}