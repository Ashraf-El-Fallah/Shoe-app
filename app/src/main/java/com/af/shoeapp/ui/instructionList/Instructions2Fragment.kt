package com.af.shoeapp.ui.instructionList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.af.shoeapp.R
import com.af.shoeapp.databinding.FragmentInstructions2Binding

class Instructions2Fragment : Fragment() {
    private var _binding: FragmentInstructions2Binding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentInstructions2Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClicks()
    }

    private fun setOnClicks(){
        binding.btnNext2.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_instructions2Fragment_to_loginFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }


}