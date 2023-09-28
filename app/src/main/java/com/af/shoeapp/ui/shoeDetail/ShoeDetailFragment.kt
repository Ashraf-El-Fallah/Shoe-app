package com.af.shoeapp.ui.shoeDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.af.shoeapp.R
import com.af.shoeapp.ViewModel.ShareViewModel
import com.af.shoeapp.data.SelectSize
import com.af.shoeapp.databinding.FragmentShoeDetailBinding
import com.af.shoeapp.ui.shoeList.ShoeListFragment

class ShoeDetailFragment :Fragment()
{
    private var _binding: FragmentShoeDetailBinding?=null
    private val binding get()=_binding!!

    private lateinit var selectSizeAdapter: SelectSizeAdapter
    private var shoeSize:String=""
    lateinit var viewModel:ShareViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentShoeDetailBinding.inflate(inflater,container,false)

        val viewToSelectSize=inflater.inflate(R.layout.select_size,container,false)
        val sizeButton= viewToSelectSize.findViewById<AppCompatButton>(R.id.btn)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        setOnClicks()
        passShoeData()

        configurationToolBar()
        handlingRecyclerView()
    }

    private fun initViewModel(){
        viewModel= ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
    }

//    private fun initObservers() {
//        viewModel.eventSaveShoeDetailPress.observe(viewLifecycleOwner, Observer {
//            if (!it) {
//                saveShoeDetail()
//            }
//        })
//
//        viewModel.eventCancelShoeDetailPress.observe(viewLifecycleOwner, Observer {
//            if (!it) {
//                cancelShoeDetail()
//            }
//        })
//    }

    private fun setOnClicks(){
            binding.btnCancel.setOnClickListener{
                findNavController().navigateUp()
            }

            binding.btnSave.setOnClickListener {
                findNavController().popBackStack()
            }

    }



//    private fun moveToListScreen(){
//        val destinationFragment= ShoeListFragment()
//        destinationFragment.arguments=passShoeData()   //bundle
//        fragmentManager?.beginTransaction()?.replace(R.id.fragment_container_view,destinationFragment)?.commit()
//    }

    private fun configurationToolBar(){
        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(binding.toolbar2)
    }

    private fun handlingRecyclerView(){
        val sizes= arrayListOf<SelectSize>(
            SelectSize("8"),
            SelectSize("9") ,
            SelectSize("10"),
            SelectSize("11"),
            SelectSize("12")
        )

        val recyclerView=binding.rvSelectSize

        selectSizeAdapter= SelectSizeAdapter(sizes, sizeClicked = {
            shoeSize=it
            Toast.makeText(requireContext(),"you selected a shoe with $it size",Toast.LENGTH_SHORT).show()
        })
        recyclerView.adapter=selectSizeAdapter

    }


    private fun passShoeData(){
        var companyName=binding.etCompany.text.toString()
        var shoeName=binding.etName.text.toString()

//        val bundle=Bundle()

//        bundle.putString("companyName",companyName)
//        bundle.putString("shoeName",shoeName)
//        bundle.putString("shoeSize",shoeSize)


        if (!shoeSize.isNullOrEmpty()) {
            viewModel.setCompanyName(companyName)
            viewModel.setShoeName(shoeName)
            viewModel.setShoeSize(shoeSize)
        }

//        return bundle
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}