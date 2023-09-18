package com.af.shoeapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.af.shoeapp.R
import com.af.shoeapp.data.SelectSize
import com.af.shoeapp.adapters.SelectSizeAdapter
import com.af.shoeapp.databinding.FragmentInstructions2Binding
import com.af.shoeapp.databinding.FragmentLoginBinding
import com.af.shoeapp.databinding.FragmentShoeDetailBinding
import com.google.android.material.appbar.MaterialToolbar

class ShoeDetailFragment :Fragment()
{
    private var _binding: FragmentShoeDetailBinding?=null
    private val binding get()=_binding!!

    lateinit var selectSizeAdapter: SelectSizeAdapter
    lateinit var shoeSize:String
//    lateinit var sizeItemClickListener: SizeItemClickListener
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    _binding= FragmentShoeDetailBinding.inflate(inflater,container,false)
    val view=binding.root

        val toolBar = binding.toolbar2

        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(toolBar)



        //recycler view
        val sizes= arrayListOf<SelectSize>(
            SelectSize("8"),
            SelectSize("9") ,
            SelectSize("10"),
            SelectSize("11"),
            SelectSize("12")
        )

    val viewToSelectSize=inflater.inflate(R.layout.select_size,container,false)
    val sizeButton= viewToSelectSize.findViewById<AppCompatButton>(R.id.btn)

    val recyclerView=binding.rvSelectSize

    selectSizeAdapter= SelectSizeAdapter(sizes, sizeClicked = {
       shoeSize=it
        Toast.makeText(requireContext(),"you selected a shoe with $it size",Toast.LENGTH_LONG).show()
    })
    recyclerView.adapter=selectSizeAdapter

    //Used to  select the size




    val cancel=binding.btnCancel
    cancel.setOnClickListener{
        findNavController().navigateUp()
    }



    val save=binding.btnSave

        save.setOnClickListener {

            var companyName=binding.etCompany.text.toString()
            var shoeName=binding.etName.text.toString()

//            var companyName=companyNameView.text.toString()
//            var shoeName=shoeNameView.text.toString()

            val bundle=Bundle()

            bundle.putString("companyName",companyName)
            bundle.putString("shoeName",shoeName)
            bundle.putString("shoeSize",shoeSize)


            //findNavController().navigateUp()
            val destinationFragment= ShoeListFragment()
            destinationFragment.arguments=bundle
            fragmentManager?.beginTransaction()?.replace(R.id.fragment_container_view,destinationFragment)?.commit()
        }
        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}