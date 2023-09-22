package com.af.shoeapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.af.shoeapp.R
import com.af.shoeapp.data.SelectSize
import com.af.shoeapp.adapters.SelectSizeAdapter
import com.google.android.material.appbar.MaterialToolbar

class ShoeDetailFragment :Fragment()
{
    private lateinit var selectSizeAdapter: SelectSizeAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.fragment_shoe_detail,container,false)

        val toolBar = view?.findViewById<MaterialToolbar>(R.id.toolbar2)

        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(toolBar)

        //recycler view
        val sizes= arrayListOf<SelectSize>(
            SelectSize(8),
            SelectSize(9) ,
            SelectSize(10),
            SelectSize(11),
            SelectSize(12)
        )
        selectSizeAdapter= SelectSizeAdapter(sizes)
        val recyclerView:RecyclerView=view.findViewById(R.id.rvSelectSize)
        recyclerView.adapter=selectSizeAdapter


        val save=view.findViewById<Button>(R.id.btnSave)

        save.setOnClickListener {

            val companyNameView=view.findViewById<EditText>(R.id.etCompany)
            val shoeNameView=view.findViewById<EditText>(R.id.etName)

            val companyName=companyNameView.text.toString()
            val shoeName=shoeNameView.text.toString()

            val bundle=Bundle()
            bundle.putString("companyName",companyName)
            bundle.putString("shoeName",shoeName)


            val destinationFragment= ShoeListFragment()
            destinationFragment.arguments=bundle
            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view,destinationFragment).commit()


        }


        return view

    }
}