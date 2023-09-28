package com.af.shoeapp.ui.shoeDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.af.shoeapp.R
import com.af.shoeapp.ViewModel.ShareViewModel
import com.af.shoeapp.data.SelectSize
import com.af.shoeapp.data.Shoe
import com.af.shoeapp.databinding.FragmentShoeDetailBinding

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        setOnClicks()
        configurationToolBar()
        handlingRecyclerView()
    }

    private fun initViewModel(){
        viewModel= ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
    }

    private fun setOnClicks(){
            binding.btnCancel.setOnClickListener{
                binding.etCompany.text.clear()
                binding.etName.text.clear()
                findNavController().popBackStack()
            }
            binding.btnSave.setOnClickListener {
                passShoeData()
                findNavController().popBackStack()
            }
    }

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

    private fun passShoeData() {
        val companyName = binding.etCompany.text.toString()
        val shoeName = binding.etName.text.toString()

        if (shoeSize.isNullOrEmpty().not()) {
            viewModel.setShoe(
                Shoe(
                    shoeName = shoeName,
                    shoeDetail = companyName,
                    shoeSize = shoeSize,
                    shoePicUrl = R.drawable.shoe1
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}