package com.af.shoeapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.af.shoeapp.R
import com.af.shoeapp.databinding.FragmentInstructions1Binding


class Instructions1Fragment : Fragment() {
    private var _binding:FragmentInstructions1Binding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInstructions1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClicks()
    }

    private fun setOnClicks(){
        binding.btnNext1.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_instructions1Fragment_to_instructions2Fragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }


}